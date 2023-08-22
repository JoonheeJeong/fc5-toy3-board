package fc5.toy3.board.domain.member;

import fc5.toy3.board.domain.member.dao.GradeRepository;
import fc5.toy3.board.domain.member.type.GradeType;
import fc5.toy3.board.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;

@RequiredArgsConstructor
public class MemberFactory {

    private final GradeRepository gradeRepository;
    private final PasswordEncoder passwordEncoder;

    public Member createNewbie(int i) {
        return createMember(1L, i);
    }

    public Member createVip(int i) {
        return createMember(2L, i);
    }

    private Member createMember(long gradeId, int i) {
        assertThat(gradeId).isGreaterThan(0);
        assertThat(gradeId).isLessThan(3);
        assertThat(i).isGreaterThan(0);
        assertThat(i).isLessThan(100);

        String formattedId = String.format("%02d", i);
        GradeType gradeType = GradeType.values()[((int) gradeId) - 1];
        String prefix = "test_" + gradeType.name().toLowerCase();
        String prefixDesc = "테스트" + gradeType.getDescription().substring(0, 2).toLowerCase();

        return Member.builder()
                .grade(gradeRepository.findById(gradeId))
                .username(prefix + formattedId)
                .email(prefix + formattedId + "@example.com")
                .nickname(prefixDesc + formattedId)
                .password(passwordEncoder.encode("password"))
                .build();
    }

    public String generateEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }
}
