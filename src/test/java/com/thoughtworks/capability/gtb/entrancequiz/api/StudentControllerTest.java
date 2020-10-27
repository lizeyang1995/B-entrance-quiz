package com.thoughtworks.capability.gtb.entrancequiz.api;

import com.thoughtworks.capability.gtb.entrancequiz.domain.Students;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {
    @Autowired
    MockMvc mockMvc;
    @BeforeEach
    void setUp() {

    }

    @Test
    void should_get_all_students() throws Exception {
        Students students = new Students();
        mockMvc.perform(get("/students"))
                .andExpect(jsonPath("$[0].students.get(1)", is("成吉思汗")))
                .andExpect(status().isOk());
    }
}
