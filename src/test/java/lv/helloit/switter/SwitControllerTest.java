package lv.helloit.switter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SwitControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @Test
    void shouldPostAndGetSwit() {
        Swit swit = new Swit();
        swit.setAuthor("Me");
        swit.setContent("Test swit");

        restTemplate.postForObject("http://localhost:" + port + "/swit", swit, String.class);

        List<Swit> swits = restTemplate.getForObject(
                "http://localhost:" + port + "/swits",
                SwitList.class);

        System.out.println(swit);

        assertEquals(1, swits.size());
        var fetchedSwit = swits.get(0);
        assertEquals(1L, fetchedSwit.getId());
    }

    @Test
    void shouldDeleteSwits() {
        Swit swit = new Swit();
        swit.setAuthor("Me");
        swit.setContent("Test swit");

        restTemplate.postForObject("http://localhost:" + port + "/swit", swit, String.class);

        restTemplate.delete("http://localhost:" + port + "/swits");

        List<Swit> swits = restTemplate.getForObject(
                "http://localhost:" + port + "/swits",
                SwitList.class);

        assertEquals(0, swits.size());
    }

    @Test
    void shouldPut() {
        Swit swit = new Swit();
        swit.setAuthor("Me");
        swit.setContent("Test swit");

        Swit createdSwit = restTemplate.postForObject(
                "http://localhost:" + port + "/swit", swit, Swit.class);

        Swit newSwit = new Swit();
        newSwit.setContent("New Content");

        restTemplate.put("http://localhost:" + port + "/swit/" + createdSwit.getId(), newSwit);

        List<Swit> swits = restTemplate.getForObject(
                "http://localhost:" + port + "/swits",
                SwitList.class);

        assertEquals("New Content", swits.get(0).getContent());
    }
}

class SwitList extends ArrayList<Swit> {
};
