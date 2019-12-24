package lv.helloit.switter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
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

    @DeleteMapping("/swit/{id}")
    public void deleteSwitById(@PathVariable("id") Long id) {
        service.deleteSwitById(id);
    }

    @PostMapping("/swit/update")
    public RedirectView saveSwitUpdate(@ModelAttribute Swit swit) {
        service.update(swit.getId(), swit.getContent());
        return new RedirectView("/");
    }

    @PostMapping("/swit")
    public RedirectView createSwit(Model model, @Valid @ModelAttribute ChangeSwitDTO swit) {
        service.addSwit(swit);
        return new RedirectView("/");
    }
}
