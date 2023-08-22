package fc5.toy3.board.domain.member.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AuthorityType {

    USER("사용자"),
    ADMIN("관리자")
    ;

    private final String description;
}
