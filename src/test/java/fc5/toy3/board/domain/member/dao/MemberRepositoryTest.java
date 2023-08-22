package fc5.toy3.board.domain.member.dao;

import fc5.toy3.board.domain.member.type.GradeType;
import fc5.toy3.board.domain.member.MemberFactory;
import fc5.toy3.board.domain.member.MemberTestConfig;
import fc5.toy3.board.domain.member.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Slf4j
@Import(MemberTestConfig.class)
@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private MemberFactory memberFactory;

    @Transactional
    @DisplayName("회원 추가")
    @Test
    void save() {
        for (int i = 1; i <= 10; ++i) {
            // given
            Member member = (i <= 5) ? memberFactory.createNewbie(i) : memberFactory.createVip(i);

            // when
            Member savedMember = memberRepository.save(member);

            // then
            assertThat(savedMember.getId()).isNotNull();
            assertThat(savedMember.getGrade().getType())
                    .isSameAs((i <= 5) ? GradeType.NEWBIE : GradeType.VIP);
            log.info("username: {}, password: {}",
                    savedMember.getUsername(),
                    savedMember.getPassword());
        }
    }

    @Transactional
    @DisplayName("username으로 조회 성공")
    @Test
    void whenExists_thenGetsMember() {
        // given
        Member savedMember = memberRepository.save(memberFactory.createNewbie(1));

        // when
        Member foundMember = memberRepository.findByUsername(savedMember.getUsername());

        // then
        Long id = foundMember.getId();
        assertThat(id).isNotNull();
    }

    @Transactional(readOnly = true)
    @DisplayName("username으로 조회 실패")
    @Test
    void whenNotExists_thenThrows() {
        assertThatThrownBy(() -> memberRepository.findByUsername("not_exists"))
                .isInstanceOf(EmptyResultDataAccessException.class);
    }
}