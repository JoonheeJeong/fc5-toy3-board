package fc5.toy3.board.domain.member.service;

import fc5.toy3.board.domain.member.dao.MemberRepository;
import fc5.toy3.board.domain.member.entity.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MemberServiceImplTest {

    @InjectMocks
    private MemberServiceImpl sut;
    @Mock
    private MemberRepository memberRepository;

    @DisplayName("해당 username의 회원 존재")
    @Test
    void whenUsernameExists_thenShouldBeFound() {
        // given
        Member member = mock(Member.class);
        when(memberRepository.findByUsername(anyString())).thenReturn(member);

        // when
        UserDetails userDetails = sut.loadUserByUsername(anyString());

        // then
        Mockito.verify(memberRepository, times(1))
                .findByUsername(anyString());
        assertThat(userDetails).isNotNull();
    }
}