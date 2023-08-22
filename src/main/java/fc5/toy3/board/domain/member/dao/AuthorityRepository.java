package fc5.toy3.board.domain.member.dao;

import fc5.toy3.board.domain.member.entity.Authority;

public interface AuthorityRepository {

    Authority findById(Long id);
}
