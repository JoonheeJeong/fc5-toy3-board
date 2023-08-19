package fc5.toy3.board.domain.authority.model;

import fc5.toy3.board.domain.BaseEntity;
import fc5.toy3.board.domain.authority.type.AuthorityType;
import fc5.toy3.board.domain.member.model.Member;
import lombok.Getter;
import lombok.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Authority extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "name", unique = true, nullable = false)
    private AuthorityType type;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "authorities")
    private List<Member> members = new ArrayList<>();

    public void addMember(@NonNull Member member) {
        if (!members.contains(member)) {
            members.add(member);
            member.addAuthority(this);
        }
    }
}
