package com.example.shoppingmall.member;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MemberService {
    MemberRepository memberRepository;


    public String signup(Member member) {
        return memberRepository.save(member);
    }

    public void login(String userId, String pw) {
        memberRepository.login(userId, pw);
    }

    public boolean checkDuplicateId(String userId) {
        return memberRepository.findById(userId);
    }
}
