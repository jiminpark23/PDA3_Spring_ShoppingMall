package com.example.shoppingmall.member;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class MemberMapRepository implements MemberRepository {
    Map<String, Member> memberTable = new HashMap<>();
    @Autowired
    EntityManager entityManager;

    @Autowired
    DataSource dataSource;

    public void makeConnection() {
        DataSourceUtils.getConnection(dataSource);
    }

    public Member save(Member member) {
        entityManager.persist(member);

//        entityManager.flush();
        Member savedMember = entityManager.find(Member.class, member.getId());

        return savedMember;
    }

    public Optional<Member> findByUserId(String userId) {
        String jpql = "SELECT m FROM Member m WHERE m.userId = :userId";

        Member foundMember = entityManager.createQuery(jpql, Member.class)
                            .setParameter("userId", userId)
                            .getSingleResult();
//        return memberTable.get(userId);
        if (foundMember == null) {
            return null;
        } else {
            return Optional.ofNullable(foundMember);
        }
    }

    public Member findById(int id) {
        return entityManager.find(Member.class, id);
    }

}
