package fc5.toy3.board.domain.member.dao;

import fc5.toy3.board.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@RequiredArgsConstructor
@Repository
public class JpaMemberRepository implements MemberRepository {

    private final EntityManager em;

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Member findByUsername(String username) {
        final String jpql = "select m from Member m " +
                            "where m.username = :username";

        return em.createQuery(jpql, Member.class)
                .setParameter("username", username)
                .getSingleResult();
    }
}
