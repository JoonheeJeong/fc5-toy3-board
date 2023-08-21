package fc5.toy3.board.domain.member.model;

import fc5.toy3.board.domain.BaseEntity;
import fc5.toy3.board.domain.authority.model.Authority;
import fc5.toy3.board.domain.grade.model.Grade;
import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Member extends BaseEntity implements UserDetails {

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
    @Builder.Default
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "member_authority",
            joinColumns = @JoinColumn(name = "member_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
    private List<Authority> authorities = new ArrayList<>();

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void addAuthority(@NonNull Authority authority) {
        if (!authorities.contains(authority)) {
            authorities.add(authority);
            authority.addMember(this);
        }
    }
}
