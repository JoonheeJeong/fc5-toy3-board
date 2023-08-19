package fc5.toy3.board.domain.member.model;

import fc5.toy3.board.domain.BaseEntity;
import fc5.toy3.board.domain.grade.model.Grade;
import fc5.toy3.board.domain.authority.model.Authority;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Member extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "grade_id", referencedColumnName = "id", nullable = false)
    private Grade grade;
    @Column(length = 32, unique = true, nullable = false, updatable = false)
    private String username;
    @Column(length = 64, unique = true, nullable = false)
    private String email;
    @Column(length = 60, nullable = false)
    private String password;
    @Column(length = 16, unique = true, nullable = false)
    private String nickname;
}
