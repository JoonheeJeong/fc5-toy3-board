package fc5.toy3.board.domain.member.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
}