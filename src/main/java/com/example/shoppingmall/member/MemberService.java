package com.example.shoppingmall.member;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class MemberService {
    MemberRepository memberRepository;
    MemberJPARepository memberJPARepository;

    public void makeConnection() {
        memberRepository.makeConnection();
    }

    @Transactional
    public String join(Member member) {

        memberJPARepository.save(member);

        return memberJPARepository.findByUserId(member.getUserId()).get().getUserId();
    }

    public boolean checkDuplicateId(String userId) {
        Member existMember = memberJPARepository.findByUserId(userId).orElse(null);

        if (existMember == null)
            return false;
        else
            return true;
    }

//    public Member login(String userId, String pw) {
//        if (memberRepository.findById(userId) == null) {
//            // 해당 id는 존재하지 않는 id
//            return null;
//        }
//        if (!pw.equals(memberRepository.findById(userId).getPw())) {
//            // 비밀번호 오류
//            return null;
//        }
//
//        return memberRepository.login(userId, pw);
//    }


}
