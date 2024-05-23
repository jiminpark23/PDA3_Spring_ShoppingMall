package com.example.shoppingmall.member;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Repository
public class MemberRepository  {
    Map<String, Member> memberTable = new HashMap<>();
    @Autowired
    EntityManager entityManager;

    @Autowired
    DataSource dataSource;

    public void makeConnection() {
        DataSourceUtils.getConnection(dataSource);
    }

//    public void save(Member member) {
//        entityManager.persist(member);
//        entityManager.flush();
////        Member savedMember = entityManager.find(Member.class, member.getId());
////
////        return savedMember.getUserId();
//    }

//    public Member findByUserId(String userId) {
//        String jpql = "SELECT m FROM Member m WHERE m.userId = :userId";
//
//        return entityManager.createQuery(jpql, Member.class)
//                            .setParameter("userId", userId)
//                            .getSingleResult();
////        return memberTable.get(userId);
//    }

    public Member findById(int id) {
        return entityManager.find(Member.class, id);
    }


//    public Member login(String userId, String pw) {
//        return findByUserId(userId);
//    }
}
