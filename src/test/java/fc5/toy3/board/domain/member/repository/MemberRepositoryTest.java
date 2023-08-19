package fc5.toy3.board.domain.member.repository;

import fc5.toy3.board.domain.grade.repository.GradeRepository;
import fc5.toy3.board.domain.grade.type.GradeType;
import fc5.toy3.board.domain.member.model.Member;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Slf4j
@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    private GradeRepository gradeRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    @DisplayName("회원 추가")
    @Test
    void save() {
        for (int i = 1; i <= 10; ++i) {
            // given
            Member member = (i <= 5) ? buildNewbie(i) : buildVip(i);

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

    private Member buildNewbie(int i) {
        return buildMember(1L, i);
    }

    private Member buildVip(int i) {
        return buildMember(2L, i);
    }

    private Member buildMember(long gradeId, int i) {
        assertThat(gradeId).isGreaterThan(0);
        assertThat(gradeId).isLessThan(3);
        assertThat(i).isGreaterThan(0);
        assertThat(i).isLessThan(100);

        String formattedId = String.format("%02d", i);
        GradeType gradeType = GradeType.values()[((int) gradeId) - 1];
        String prefix = gradeType.name().toLowerCase();
        String prefixDesc = gradeType.getDescription().substring(0, 2).toLowerCase();

        return Member.builder()
                .grade(gradeRepository.findById(gradeId))
                .username(prefix + formattedId)
                .email(prefix + formattedId + "@example.com")
                .nickname(prefixDesc + formattedId)
                .password(passwordEncoder.encode("password"))
                .build();
    }
}