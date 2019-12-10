package lv.helloit.switter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {
    List<String> sweets = new ArrayList<>();

    @GetMapping("/sweets")
    public List<String> getAllSweets() {
        return sweets;
    }

    @DeleteMapping("/sweets")
    public void deleteAllSweets() {
        sweets.clear();
    }

    @PostMapping("/switt")
    public ResponseEntity<String> addSweet(@RequestBody String switt) {
        sweets.add(switt);
        return new ResponseEntity<String>("Switt created. Everything went good!", HttpStatus.CREATED);
    }
}
