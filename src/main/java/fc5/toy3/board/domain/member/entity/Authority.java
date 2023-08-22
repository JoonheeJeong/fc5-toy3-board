package fc5.toy3.board.domain.member.entity;

import fc5.toy3.board.domain.BaseEntity;
import fc5.toy3.board.domain.member.type.AuthorityType;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Entity
public class Authority extends BaseEntity implements GrantedAuthority {

    @Enumerated(EnumType.STRING)
    @Column(name = "name", unique = true, nullable = false)
    private AuthorityType type;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "authorities")
    private final List<Member> members = new ArrayList<>();

    @Override
    public String getAuthority() {
        return type.name();
    }

    public void addMember(@NonNull Member member) {
        if (!members.contains(member)) {
            members.add(member);
            member.addAuthority(this);
        }
    }
}
