package lv.helloit.switter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SwitController {
    private SwitService service = new SwitService();

    @GetMapping("/swits")
    public List<Swit> getAllSwits() {
        return service.getAllSwits();
    }

    @DeleteMapping("/swits")
    public void deleteAllSwits() {
        service.deleteAllSwits();
    }

    @PostMapping("/swit")
    public ResponseEntity<String> addSwit(@RequestBody Swit newSwit) {
        service.addSwit(newSwit);
        return new ResponseEntity<>("Switt created. Everything went good!", HttpStatus.CREATED);
    }

    @PutMapping("/swit/{id}")
    public void update(@PathVariable("id") Long id,
                       @RequestBody Swit newSwit) {
        service.update(id, newSwit);
    }
}
