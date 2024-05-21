package com.example.shoppingmall.member;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Repository
public class MemberRepository {
    Map<String, Member> memberTable = new HashMap<>();
    @Autowired
    EntityManager entityManager;

    @Autowired
    DataSource dataSource;

    public void makeConnection() {
        DataSourceUtils.getConnection(dataSource);
    }

    @Transactional
    public String save(Member member) {
        entityManager.persist(member);
//        memberTable.put(member.getUserId(), member);
//        Member savedMember = memberTable.get(member.getUserId());
        Member savedMember = entityManager.find(Member.class, member.getId());

        return savedMember.getUserId();
    }

    public Member findById(String userId) {
        return memberTable.get(userId);
    }

    public void login(String userId, String pw) {

    }
}
