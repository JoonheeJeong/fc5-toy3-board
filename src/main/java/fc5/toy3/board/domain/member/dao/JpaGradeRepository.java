package fc5.toy3.board.domain.member.dao;

import fc5.toy3.board.domain.member.exception.NotFoundGradeException;
import fc5.toy3.board.domain.member.entity.Grade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@RequiredArgsConstructor
@Repository
public class JpaGradeRepository implements GradeRepository {

    private final EntityManager em;

    @Override
    public Grade findById(Long id) {
        Grade grade = em.find(Grade.class, id);
        if (grade == null) {
            throw new NotFoundGradeException();
        }
        return grade;
    }
}
