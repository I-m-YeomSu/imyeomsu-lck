package imyeom_lck.common.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.jupiter.api.DisplayName;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@WebMvcTest(IndexController.class)
class IndexControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @BeforeEach
    void setUp() {

    }

    @Test
    @DisplayName("메인 화면으로 가는 컨트롤러 테스트 - 성공")
    void indexForm() throws Exception {
        this.mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("main/index"));
    }

    @Test
    @DisplayName("메인 이벤트 화면으로 가는 컨트롤러 테스트 - 성공")
    void mainEventForm() throws Exception {
        this.mockMvc.perform(get("/event/main"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("event/main"));

    }
}