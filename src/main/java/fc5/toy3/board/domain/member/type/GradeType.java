package fc5.toy3.board.domain.member.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum GradeType {

    NEWBIE("새싹회원"),
    VIP("우수회원")
    ;

    private final String description;
}
