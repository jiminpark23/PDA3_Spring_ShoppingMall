package com.example.shoppingmall.member;

import com.example.shoppingmall.order.Order;
import com.example.shoppingmall.product.Product;
import com.example.shoppingmall.utils.ApiUtils;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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
    public ApiUtils.ApiResult join(@Valid @RequestBody MemberDTO memberDTO) {  //, Errors errors) {

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
        if(isDuplicateId(memberDTO))
            return error("아이디 중복", HttpStatus.CONFLICT);

        // 생성자 이용한 변환
        Member requestMember = memberDTO.convertToEntity();

        String userId = memberService.join(requestMember);
        return success(userId);
    }

    private boolean isDuplicateId(MemberDTO memberDTO) {
        return memberService.checkDuplicateId(memberDTO.getUserId());
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

    @PostMapping("/check")
    public ResponseEntity<String> checkDuplicateId(@RequestBody Member member) {
        boolean isExist = memberService.checkDuplicateId(member.getUserId());

        if (isExist) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody Member member) {
        if (memberService.login(member.getUserId(), member.getPw()) == null ) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
