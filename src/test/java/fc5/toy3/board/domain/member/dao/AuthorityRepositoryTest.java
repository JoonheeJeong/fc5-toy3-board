package fc5.toy3.board.domain.member.dao;

import fc5.toy3.board.domain.member.dao.AuthorityRepository;
import fc5.toy3.board.domain.member.exception.NotFoundAuthorityException;
import fc5.toy3.board.domain.member.entity.Authority;
import fc5.toy3.board.domain.member.type.AuthorityType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
class AuthorityRepositoryTest {

    @Autowired
    private AuthorityRepository authorityRepository;

    @DisplayName("id 조회 성공")
    @Test
    void whenExists_thenGetsMember() {
        AuthorityType[] values = AuthorityType.values();
        for (int i = 1; i <= values.length; ++i) {
            Authority foundAuthority = authorityRepository.findById((long) i);
            assertThat(foundAuthority.getType())
                    .isSameAs(values[i-1]);
        }
    }

    @DisplayName("id 조회 실패")
    @Test
    void whenNotExists_thenThrows() {
        assertThatThrownBy(() -> authorityRepository.findById(3L))
                .isInstanceOf(NotFoundAuthorityException.class);
    }
}