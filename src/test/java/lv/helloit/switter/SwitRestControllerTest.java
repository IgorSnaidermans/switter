package lv.helloit.switter;

import lv.helloit.switter.swit.Swit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SwitRestControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @Test
    void shouldPostAndGetSwit() {
        Swit swit = new Swit();
        swit.setAuthor("Me");
        swit.setContent("Test swit");

        restTemplate.postForObject(getUrl() + "/swit", swit, String.class);

        List<Swit> swits = restTemplate.getForObject(
                getUrl() + "/swits",
                SwitList.class);

        var fetchedSwit = swits.get(0);
        assertEquals(1L, fetchedSwit.getId());
    }

    @Test
    void shouldDeleteSwits() {
        Swit swit = new Swit();
        swit.setAuthor("Me");
        swit.setContent("Test swit");

        restTemplate.postForObject(getUrl() + "/swit", swit, String.class);

        restTemplate.delete(getUrl() + "/swits");

        List<Swit> swits = restTemplate.getForObject(
                getUrl() + "/swits",
                SwitList.class);

        assertEquals(0, swits.size());
    }

    @Test
    void shouldPut() {
        Swit swit = new Swit();
        swit.setAuthor("Me");
        swit.setContent("Test swit");

        Swit createdSwit = restTemplate.postForObject(
                getUrl() + "/swit", swit, Swit.class);

        Swit newSwit = new Swit();
        newSwit.setContent("New Content");

        restTemplate.put(getUrl() + "/swit/" + createdSwit.getId(), newSwit);

        List<Swit> swits = restTemplate.getForObject(
                getUrl() + "/swits",
                SwitList.class);

        assertEquals("New Content", swits.get(0).getContent());
    }

    private String getUrl() {
        return "http://localhost:" + port + "/rest";
    }
}

class SwitList extends ArrayList<Swit> {
};
