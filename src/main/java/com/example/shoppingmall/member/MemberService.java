package com.example.shoppingmall.member;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class MemberService {
//    MemberRepository memberRepository;
    MemberJPARepository memberJPARepository;

//    public void makeConnection() {
//        memberRepository.makeConnection();
//    }

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

    public Member login(String userId, String pw) {
        Member existMember = memberJPARepository.findByUserId(userId).orElse(null);

        if (existMember == null || !pw.equals(existMember.getPw())) {
            return null;
        }

        return existMember;
    }

}
