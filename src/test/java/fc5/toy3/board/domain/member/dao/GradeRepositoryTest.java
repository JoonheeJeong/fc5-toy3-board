package fc5.toy3.board.domain.member.dao;

import fc5.toy3.board.domain.member.exception.NotFoundGradeException;
import fc5.toy3.board.domain.member.dao.GradeRepository;
import fc5.toy3.board.domain.member.entity.Grade;
import fc5.toy3.board.domain.member.type.GradeType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
class GradeRepositoryTest {

    @Autowired
    private GradeRepository gradeRepository;

    @DisplayName("id 조회 성공")
    @Test
    void whenExists_thenGetsMember() {
        GradeType[] values = GradeType.values();
        for (int i = 1; i <= values.length; ++i) {
            Grade foundGrade = gradeRepository.findById((long) i);
            assertThat(foundGrade.getType())
                    .isSameAs(values[i-1]);
        }
    }

    @DisplayName("id 조회 실패")
    @Test
    void whenNotExists_thenThrows() {
        assertThatThrownBy(() -> gradeRepository.findById(3L))
                .isInstanceOf(NotFoundGradeException.class);
    }
}