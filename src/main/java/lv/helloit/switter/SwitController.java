package lv.helloit.switter;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SwitController {
    private final SwitService service;

    public SwitController(SwitService service) {
        this.service = service;
    }

    @GetMapping("/swits")
    public List<Swit> getAllSwits() {
        return service.getAllSwits();
    }

    @DeleteMapping("/swits")
    public void deleteAllSwits() {
        service.deleteAllSwits();
    }

    @PostMapping("/swit")
    public ResponseEntity<Swit> addSwit(@RequestBody Swit newSwit) {
        return new ResponseEntity<>(service.addSwit(newSwit), HttpStatus.CREATED);
    }

    @PutMapping("/swit/{id}")
    public void update(@PathVariable("id") Long id,
                       @RequestBody Swit newSwit) {
        service.update(id, newSwit);
    }
}
