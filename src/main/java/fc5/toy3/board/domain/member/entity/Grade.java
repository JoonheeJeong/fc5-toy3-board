package fc5.toy3.board.domain.member.entity;

import fc5.toy3.board.domain.BaseEntity;
import fc5.toy3.board.domain.member.type.GradeType;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Entity
public class Grade extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "name", unique = true, nullable = false)
    private GradeType type;
}
