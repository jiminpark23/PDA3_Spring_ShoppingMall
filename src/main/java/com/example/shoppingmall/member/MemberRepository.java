package com.example.shoppingmall.member;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MemberRepository {
    Map<String, Member> memberTable = new HashMap<>();

    int id = 0;

    public String save(Member member) {
        if (findById(member.getUserId())) {
            memberTable.put(member.getUserId(), member);
            Member savedMember = memberTable.get(member.getUserId());

            return savedMember.getUserId();
        }

        return null;
    }

    public void login(String userId, String pw) {

    }

    public boolean findById(String userId) {
        return (memberTable.get(userId) == null);
    }
}
