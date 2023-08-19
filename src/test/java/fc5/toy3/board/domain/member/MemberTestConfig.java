package fc5.toy3.board.domain.member;

import fc5.toy3.board.domain.grade.repository.GradeRepository;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@TestConfiguration
public class MemberTestConfig {

    @Bean
    public MemberFactory memberBuilder(GradeRepository gradeRepository, PasswordEncoder passwordEncoder) {
        return new MemberFactory(gradeRepository, passwordEncoder);
    }
}
