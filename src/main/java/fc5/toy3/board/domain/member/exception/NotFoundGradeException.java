package fc5.toy3.board.domain.member.exception;

import java.util.NoSuchElementException;

public class NotFoundGradeException extends NoSuchElementException {

    private static final String DEFAULT_MESSAGE = "해당하는 id를 가진 Grade를 찾지 못했습니다.";

    public NotFoundGradeException() {
        this(DEFAULT_MESSAGE);
    }

    public NotFoundGradeException(String s) {
        super(s);
    }
}
