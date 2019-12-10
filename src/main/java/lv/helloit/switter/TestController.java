package lv.helloit.switter;

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
    public void addSweet(@RequestBody String switt) {
        sweets.add(switt);
    }
}
