package fc5.toy3.board.domain.member.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static fc5.toy3.board.domain.member.controller.WithMockCustomUser.USER_USERNAME;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
class LoginControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @DisplayName("로그인 페이지 접속")
    @Test
    void whenAnybodyAccessToLoginPage_thenSuccess() throws Exception {
        mockMvc.perform(get("/login"))
                .andExpect(status().isOk());
    }

    @DisplayName("미인증 접속은 login으로 리디렉션")
    @Test
    void whenNotAuthenticated_thenShouldBeUnauthorized() throws Exception {
        mockMvc.perform(get("/board"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrlPattern("**/login"));
    }

    @WithMockCustomUser
    @DisplayName("인증된 회원 게시판 접속 허용")
    @Test
    void whenAuthenticated_thenSuccessToAccessBoard() throws Exception {
        mockMvc.perform(get("/board"))
                .andExpect(status().isOk())
                .andExpect(view().name("board"))
                .andExpect(model().attributeExists("username"))
                .andExpect(model().attribute("username", USER_USERNAME));
    }

    @DisplayName("인증 실패 시 로그인 에러 페이지로 포워딩")
    @Test
    void whenAuthenticationFailed_thenShouldBeRedirectedToLoginWithError() throws Exception {
        mockMvc.perform(post("/login")
                        .param("username", "invalid_username")
                        .param("password", "invalid_password")
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/login?error"));
    }
}