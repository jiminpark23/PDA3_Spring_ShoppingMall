package com.example.shoppingmall.member;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
public class MemberController {
    MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody Member member) {
        log.info(member.toString());

//         id 중복 체크
//         중복이면, 사용자 예외 클래스 소환
//                  방법1) 예외 클래스한테 니가 return해!
//                        - 예외 처리 주체가 예외 클래스
//                  방법2) 예외만 발생시키고.. 메시지는 내가 보낼게
//                        - 예외 처리 주체가 컨트롤러
        try {
            String userId = memberService.signup(member);

            if (userId == null) {
                throw new DuplicateMemberIdException("이미 존재하는 id입니다.");
            }

            return new ResponseEntity<>(userId, HttpStatus.CREATED);
        } catch(DuplicateMemberIdException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
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
