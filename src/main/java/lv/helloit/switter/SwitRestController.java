package lv.helloit.switter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class SwitRestController {
    private final SwitService service;

    @Autowired
    public SwitRestController(SwitService service) {
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

    @DeleteMapping("/swit/{id}/delete")
    public void deleteSwitById(@PathVariable("id") Long id) {
        service.deleteSwitById(id);
    }

    @PostMapping("/swit/update")
    public void saveSwitUpdate(@ModelAttribute Swit swit){
        service.update(swit.getId(), swit.getContent());
    }

    @PostMapping("/swit")
    public void createSwit(Model model, @ModelAttribute Swit swit) {
        service.addSwit(swit);
    }
}
