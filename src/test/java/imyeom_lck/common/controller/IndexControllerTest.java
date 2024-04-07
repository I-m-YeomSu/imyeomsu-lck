package imyeom_lck.common.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@WebMvcTest(IndexController.class)
@AutoConfigureMockMvc
class IndexControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @BeforeEach
    void setUp() {

    }

    @Test
    void indexForm() throws Exception {
        this.mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("main/index"));
    }

    @Test
    void mainEventForm() throws Exception {
        this.mockMvc.perform(get("/event/main"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("event/main"));

    }
}