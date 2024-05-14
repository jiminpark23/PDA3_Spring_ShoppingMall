package com.example.shoppingmall.member;

import com.example.shoppingmall.utils.ApiUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.example.shoppingmall.utils.ApiUtils.error;
import static com.example.shoppingmall.utils.ApiUtils.success;

@Slf4j
@RestController
@AllArgsConstructor
public class MemberController {
    MemberService memberService;

    @PostMapping("/join/api/result") // After
    public ApiUtils.ApiResult<String> joinByApiResult(@RequestBody Member member) {
        log.info(member.toString());

        if(isDuplicateId(member))
            return error("아이디 중복", HttpStatus.CONFLICT);

        String userId = memberService.join(member);
        return success(userId);
    }

    private boolean isDuplicateId(Member member) {
        return memberService.checkDuplicateId(member.getUserId());
    }

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
        memberService.login(member.getUserId(), member.getPw());

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
