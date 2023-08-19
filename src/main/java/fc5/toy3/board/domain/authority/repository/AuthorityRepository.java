package fc5.toy3.board.domain.authority.repository;

import fc5.toy3.board.domain.authority.model.Authority;

public interface AuthorityRepository {

    Authority findById(Long id);
}
