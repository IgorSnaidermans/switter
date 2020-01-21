package lv.helloit.switter.rest;

import lv.helloit.switter.swit.SwitService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class SwitWebControllerTest {

    @Autowired
    private SwitService service;

    @Autowired
    private MockMvc mockMvc;

    /*@Test
    void shouldAddAndGetSwit() throws Exception{
        ChangeSwitDTO swit = new ChangeSwitDTO();
        swit.setUserId("random");
        swit.setContent("random");
        service.addSwit(swit);

        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("swits"))
                .andExpect(model().attribute("swits", hasSize(1)));
    }*/

    @Test
    void shouldShowSwitById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/swit/1"))
                .andExpect(view().name("/swit/1"));
    }

}