package fc5.toy3.board.domain.member.entity;

import fc5.toy3.board.domain.member.dao.AuthorityRepository;
import fc5.toy3.board.domain.member.type.AuthorityType;
import fc5.toy3.board.domain.member.MemberFactory;
import fc5.toy3.board.domain.member.MemberTestConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@Import(MemberTestConfig.class)
@SpringBootTest
class MemberTest {

    @Autowired
    private AuthorityRepository authorityRepository;
    @Autowired
    private MemberFactory memberFactory;

    @Transactional
    @DisplayName("무권환 회원에게 권한 하나 추가")
    @Test
    void whenAddAnAuthorityToMemberWithNoAuthority_thenGetsOne() {
        Member newbie = memberFactory.createNewbie(1);
        AuthorityType[] authorityTypes = AuthorityType.values();
        for (int i = 1; i <= authorityTypes.length; ++i) {
            // given
            newbie.getAuthorities().clear();

            // when
            Authority userAuthority = authorityRepository.findById((long) i);
            newbie.addAuthority(userAuthority);

            // then
            assertThat(newbie.getAuthorities()).hasSize(1);
            assertThat(newbie.getAuthorities().get(0)).isSameAs(userAuthority);
        }
    }

    @Transactional
    @DisplayName("무권환 회원에게 모든 권한 추가")
    @Test
    void whenAddAllAuthoritiesToMemberWithNoAuthority_thenGetsAll() {
        // given
        Member newbie = memberFactory.createNewbie(1);
        assertThat(newbie.getAuthorities()).hasSize(0);

        AuthorityType[] authorityTypes = AuthorityType.values();
        for (int i = 1; i <= authorityTypes.length; ++i) {
            // when
            Authority userAuthority = authorityRepository.findById((long) i);
            newbie.addAuthority(userAuthority);
        }

        // then
        assertThat(newbie.getAuthorities()).hasSize(authorityTypes.length);
        for (int i = 0; i < authorityTypes.length; ++i) {
            assertThat(newbie.getAuthorities().get(i).getType()).isSameAs(authorityTypes[i]);
        }
    }

    @Test
    void gen() {
        System.out.println(memberFactory.generateEncodedPassword("admin"));
    }
}