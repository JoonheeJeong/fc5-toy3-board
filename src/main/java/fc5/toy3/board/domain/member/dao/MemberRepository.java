package fc5.toy3.board.domain.member.dao;

import fc5.toy3.board.domain.member.entity.Member;

public interface MemberRepository {

    Member save(Member member);

    Member findByUsername(String username);
}
