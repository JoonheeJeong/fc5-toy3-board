package fc5.toy3.board.global.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests(authorize -> authorize
                .antMatchers("/hello/**").permitAll() // /hello 경로는 모두에게 허용
                .anyRequest().authenticated() // 그 외 경로는 인증 필요
            )
            .formLogin(formLogin -> formLogin
                .loginPage("/login") // 사용자 정의 로그인 페이지 지정
                .permitAll()
            );

        return http.build();
    }
}
