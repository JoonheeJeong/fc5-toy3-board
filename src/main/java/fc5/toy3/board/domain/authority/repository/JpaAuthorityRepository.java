package fc5.toy3.board.domain.authority.repository;

import fc5.toy3.board.domain.authority.exception.NotFoundAuthorityException;
import fc5.toy3.board.domain.authority.model.Authority;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@RequiredArgsConstructor
@Repository
public class JpaAuthorityRepository implements AuthorityRepository {

    private final EntityManager em;

    @Override
    public Authority findById(Long id) {
        Authority authority = em.find(Authority.class, id);
        if (authority == null) {
            throw new NotFoundAuthorityException();
        }
        return authority;
    }
}
