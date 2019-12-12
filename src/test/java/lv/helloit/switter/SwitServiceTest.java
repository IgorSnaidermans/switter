package lv.helloit.switter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SwitServiceTest {
    SwitService service;

    @BeforeEach
    void setUp() {
        service = new SwitService();
    }

    @Test
    void shouldCreateAndGetSwit() {
        Swit swit = new Swit();
        swit.setContent("Test content");
        swit.setAuthor("John Doe");
        service.addSwit(swit);

        List<Swit> existingSwits = service.getAllSwits();

        assertEquals(1, existingSwits.size());
        Swit existingSwit = existingSwits.get(0);
        assertEquals("John Doe", existingSwit.getAuthor());
        assertEquals("Test content", existingSwit.getContent());
        assertEquals(1L, existingSwit.getId());
        assertNotNull(existingSwit.getPublishDate());
        assertNotNull(existingSwit.getLastUpdateDate());
    }

    @Test
    void shouldIncreaseIdsForNewSwits() {
        Swit swit1 = new Swit();
        Swit swit2 = new Swit();

        service.addSwit(swit1);
        service.addSwit(swit2);

        List<Swit> swits = service.getAllSwits();
        assertEquals(2, swits.size());

        assertEquals(1L, swits.get(0).getId());
        assertEquals(2L, swits.get(1).getId());
    }
}
