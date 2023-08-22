package fc5.toy3.board.domain.member.dao;

import fc5.toy3.board.domain.member.entity.Grade;

public interface GradeRepository {

    Grade findById(Long id);
}
