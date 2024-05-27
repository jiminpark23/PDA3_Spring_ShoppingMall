package com.example.shoppingmall.member;

import java.util.Optional;

public interface MemberRepository {

    public Member save(Member member);

    Optional<Member> findByUserId(String userId);


}
