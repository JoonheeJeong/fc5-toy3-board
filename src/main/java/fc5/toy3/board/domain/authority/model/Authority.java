package fc5.toy3.board.domain.authority.model;

import fc5.toy3.board.domain.BaseEntity;
import fc5.toy3.board.domain.authority.type.AuthorityType;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Authority extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "name", unique = true, nullable = false)
    private AuthorityType type;
}
