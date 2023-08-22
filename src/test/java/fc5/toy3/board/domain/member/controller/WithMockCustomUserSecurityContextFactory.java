package fc5.toy3.board.domain.member.controller;

import fc5.toy3.board.domain.member.entity.Authority;
import fc5.toy3.board.domain.member.entity.Member;
import fc5.toy3.board.domain.member.service.MemberService;
import fc5.toy3.board.domain.member.type.AuthorityType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.test.context.support.WithSecurityContextFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WithMockCustomUserSecurityContextFactory implements WithSecurityContextFactory<WithMockCustomUser> {

    @Override
    public SecurityContext createSecurityContext(WithMockCustomUser mockCustomUser) {
        List<Authority> authorities = getAuthorities(mockCustomUser);

        MemberService memberService = (username ->
                Member.builder()
                        .username(username)
                        .password(mockCustomUser.password())
                        .authorities(authorities)
                        .build());

        UserDetails userDetails = memberService.loadUserByUsername(mockCustomUser.username());
        SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
        securityContext.setAuthentication(new UsernamePasswordAuthenticationToken(userDetails,
                userDetails.getPassword(), userDetails.getAuthorities()));
        return securityContext;
    }

    private static List<Authority> getAuthorities(WithMockCustomUser mockCustomUser) {
        return Arrays.stream(mockCustomUser.authorities())
                .map(AuthorityType::valueOf)
                .map(authorityType -> Authority.builder()
                        .type(authorityType)
                        .build())
                .collect(Collectors.toList());
    }
}
