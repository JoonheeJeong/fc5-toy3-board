package fc5.toy3.board.domain.grade.repository;

import fc5.toy3.board.domain.grade.model.Grade;

public interface GradeRepository {

    Grade findById(Long id);
}
