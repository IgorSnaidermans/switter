package lv.helloit.switter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SwitControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldPostAndGetSwit() throws Exception {
        String switJson = "{ \"author\": \"Me\", " +
                "\"content\": \"My first tweet\"" +
                "}";

        mockMvc.perform(
                post("/swit")
                        .content(switJson)
                        .contentType("application/json")
        ).andExpect(status().is2xxSuccessful());

        MvcResult result = mockMvc.perform(get("/swits"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        String responseJson = result.getResponse().getContentAsString();
        assertTrue(responseJson.contains("\"id\":1"));
        assertTrue(responseJson.contains("My first tweet"));
    }
}
