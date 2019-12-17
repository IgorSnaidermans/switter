package lv.helloit.switter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SerializationTest {
    @Autowired
    private ObjectMapper mapper;

    @Test
    void shouldSerializeAndDeSerializeSwit() throws JsonProcessingException {
        Swit swit = new Swit();
        swit.setId(1L);
        swit.setAuthor("John Doe");
        swit.setContent("Test swit");
        swit.setLastUpdateDate(LocalDateTime.now());
        swit.setPublishDate(LocalDateTime.now());

        String json = mapper.writeValueAsString(swit);
        Swit deSerializedSwit = mapper.readValue(json, Swit.class);

        assertEquals(swit, deSerializedSwit);
    }
}
