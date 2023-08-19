package fc5.toy3.board.domain.authority.exception;

import java.util.NoSuchElementException;

public class NotFoundAuthorityException extends NoSuchElementException {

    private static final String DEFAULT_MESSAGE = "해당하는 id를 가진 Authority를 찾지 못했습니다.";

    public NotFoundAuthorityException() {
        this(DEFAULT_MESSAGE);
    }
    public NotFoundAuthorityException(String s) {
        super(s);
    }
}
