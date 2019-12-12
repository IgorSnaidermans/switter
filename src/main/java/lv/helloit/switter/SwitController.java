package lv.helloit.switter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class SwitController {
    private List<Swit> swits = new ArrayList<>();
    private Long idCounter = 1L;

    @GetMapping("/swits")
    public List<Swit> getAllSwits() {
        return swits;
    }

    @DeleteMapping("/swits")
    public void deleteAllSwits() {
        swits.clear();
    }

    @PostMapping("/swit")
    public ResponseEntity<String> addSwit(@RequestBody Swit newSwit) {
        newSwit.setId(idCounter);
        idCounter++;
        newSwit.setPublishDate(LocalDateTime.now());
        swits.add(newSwit);
        return new ResponseEntity<>("Switt created. Everything went good!", HttpStatus.CREATED);
    }

    @PutMapping("/swit/{id}")
    public void update(@PathVariable("id") Long id,
                       @RequestBody Swit newSwit) {
        for (Swit existingSwit : swits) {
            if (existingSwit.getId().equals(id)) {
                existingSwit.setAuthor(newSwit.getAuthor());
                existingSwit.setContent(newSwit.getContent());
                break;
            }
        }
    }
}
