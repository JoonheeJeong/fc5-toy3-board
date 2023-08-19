package fc5.toy3.board.domain.member.repository;

import fc5.toy3.board.domain.member.model.Member;

public interface MemberRepository {

    Member save(Member member);

    Member findByUsername(String username);
}
