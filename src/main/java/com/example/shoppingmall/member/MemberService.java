package com.example.shoppingmall.member;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MemberService {
    MemberRepository memberRepository;

    public void makeConnection() {
        memberRepository.makeConnection();
    }

    @Transactional
    public Member join(Member member) {
        memberRepository.save(member);

        return memberRepository.findByUserId(member.getUserId());
    }

    public boolean checkDuplicateId(String userId) {
        Member existMember = memberRepository.findByUserId(userId);

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
