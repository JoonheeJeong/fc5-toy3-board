package fc5.toy3.board.domain.member.repository;

import fc5.toy3.board.domain.member.model.Member;
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
