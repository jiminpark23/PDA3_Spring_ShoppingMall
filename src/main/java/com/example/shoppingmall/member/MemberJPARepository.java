package com.example.shoppingmall.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberJPARepository extends JpaRepository<Member, Integer>, MemberRepository {
    // extends 하고 있는 인터페이스의 기본 메소드는 그대로 사용하면 됨
    //                  -> hibernate
    // 커스텀 메소드 (QueryByExampleExecutor)
    //Optional<Member> findByUserId(String userId);  // 이렇게 선언만 해주면 가져다 쓸 수 있음

}
