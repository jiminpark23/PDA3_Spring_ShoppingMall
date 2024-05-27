package com.example.shoppingmall.member;

import com.example.shoppingmall.exception.PasswordNotValidException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class MemberService {
//    MemberJPARepository memberJPARepository;
    MemberRepository memberRepository;

//    public void makeConnection() {
//        memberRepository.makeConnection();
//    }

    @Transactional
    public String join(MemberDTO memberDTO) {
        Member requestMember = memberDTO.convertToEntity();

        Member joinedMember = memberRepository.save(requestMember);
        return joinedMember.getUserId();
//        return memberRepository.findByUserId(requestMember.getUserId()).get().getUserId();
    }

    public boolean checkDuplicateId(String userId) {
        Optional<Member> existMember = memberRepository.findByUserId(userId);
//        Member existMember = memberRepository.findByUserId(userId).orElse(null);

//        existMember.ifPresent();  //만약에 존재하면 ~
        if (existMember.isPresent()) {
            log.info(existMember.get().getUserId());
            return true;  // 중복
        } else
            return false;

//        if (existMember == null)
//            return false;
//        else
//            return true;
    }

    public String login(MemberLoginReq memberLoginReq) {
        /*
         * 1) userId로 DB를 조회
         * - 만약 없으면? 예외 "아이디가 존재하지 않습니다."
         * 2) pw 비교
         * - 만약 틀리면? 예외 "비밀번호가 틀렸습니다."
         * 3) 성공? 로그인 한 유저 이름 반환
         */

        // 값이 있으면 loginMember에 값을 담고, 값이 없으면 orElseThrow로 예외처리
        Member loginMember = memberRepository.findByUserId(memberLoginReq.getUserId()).orElseThrow(() -> new NoSuchElementException("아이디가 존재하지 않습니다."));;

        if (loginMember.getPw().equals(memberLoginReq.getPw()))
            return loginMember.getName();
        else
            throw new PasswordNotValidException("비밀번호가 일치하지 않습니다.");

    }

}
