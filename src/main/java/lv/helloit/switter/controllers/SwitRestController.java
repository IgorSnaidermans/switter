package lv.helloit.switter.controllers;

import lv.helloit.switter.swit.ChangeSwitDTO;
import lv.helloit.switter.swit.Swit;
import lv.helloit.switter.swit.SwitService;
import lv.helloit.switter.swit.UpdateSwitDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    public RedirectView saveSwitUpdate(@ModelAttribute @Valid UpdateSwitDTO updateSwitDTO) {
        service.update(updateSwitDTO);
        return new RedirectView("/");
    }

    @PostMapping("/swit")
    public RedirectView createSwit(Model model,
                                   @Valid @ModelAttribute ChangeSwitDTO changeSwitDTO) {
        service.addSwit(changeSwitDTO);
        return new RedirectView("/");
    }
}
