package com.example.shoppingmall.member;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        Member existMember = memberRepository.findByUserId(userId).orElse(null);

        if (existMember == null)
            return false;
        else
            return true;
    }

    public Member login(String userId, String pw) {
        Member existMember = memberRepository.findByUserId(userId).orElse(null);

        if (existMember == null || !pw.equals(existMember.getPw())) {
            return null;
        }

        return existMember;
    }

}
