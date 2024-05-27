package com.example.shoppingmall.member;

import com.example.shoppingmall.exception.DuplicateMemberIdException;
import com.example.shoppingmall.utils.ApiUtils;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.example.shoppingmall.utils.ApiUtils.error;
import static com.example.shoppingmall.utils.ApiUtils.success;

@Slf4j
@RestController
@AllArgsConstructor
public class MemberController {
    MemberService memberService;

//    @PostMapping("/database")
//    public void makeConnection() {
//        memberService.makeConnection();
//    }

    @PostMapping("/join")
    public ApiUtils.ApiResult<String> join(@Valid @RequestBody MemberDTO memberDTO) {  //, Errors errors) {

//        if (errors.hasErrors()) {
//            Map<String, String> errorMessages = new HashMap<>();
//
//            for (FieldError error : errors.getFieldErrors()) {
//                String errorField = error.getField(); // 예외 field명
//                String errorMessage = error.getDefaultMessage(); // 예외 message
//                errorMessages.put(errorField, errorMessage);
//            }
//
//            return error(errorMessages, HttpStatus.BAD_REQUEST);
////            return error("Validation errors", HttpStatus.BAD_REQUEST, errors.getAllErrors());
//        }

        // 유효성 검사는 아님 - 검증
        if(isDuplicateId(memberDTO.getUserId()))
            return error("아이디 중복", HttpStatus.CONFLICT);

        // 생성자 이용한 변환
//        Member requestMember = memberDTO.convertToEntity();

        String userId = memberService.join(memberDTO);
        return success(userId);
    }


//    // 유효성 검사하다가 에러가 터지면 호출되는 예외 처리 메소드
//    @ExceptionHandler//(MethodArgumentNotValidException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ApiUtils.ApiResult<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException errors) {
//
//        Map<String, String> errorMessages = new HashMap<>();
//
//        for (FieldError error : errors.getFieldErrors()) {
//            String errorField = error.getField(); // 예외 field명
//            String errorMessage = error.getDefaultMessage(); // 예외 message
//            errorMessages.put(errorField, errorMessage);
//        }
//
//        return error(errorMessages, HttpStatus.BAD_REQUEST);
//    }

    // 아이디 중복 확인
    @PostMapping("/members/check")
    public ApiUtils.ApiResult<String> checkUsableId(@RequestBody String userId) throws DuplicateMemberIdException {
        if (isDuplicateId(userId)) {
            throw new DuplicateMemberIdException("이미 사용중인 아이디입니다.");
        } else {
            return success("사용 가능한 아이디입니다.");
        }
    }

    private boolean isDuplicateId(String userId) {
        return memberService.checkDuplicateId(userId);
    }

    @PostMapping("/login")
    public ApiUtils.ApiResult<String> login(@Valid @RequestBody MemberLoginReq memberLoginReq) {
        String loginMemberName = memberService.login(memberLoginReq);

        return success(loginMemberName);
    }
}
