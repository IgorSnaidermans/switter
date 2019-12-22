package lv.helloit.switter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SwitController {
    private final SwitService switService;

    @Autowired
    public SwitController(SwitService switService) {
        this.switService = switService;
    }

    @GetMapping({"/", "/swits"})
    String getSwits(Model model) {
        model.addAttribute("swits", switService.getAllSwits());
        return "swits";
    }

    @GetMapping("/swit/{id}")
    String getSwit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("swit", switService.getSwitById(id));
        return "swit";
    }

    @GetMapping("/swit/{id}/update")
    String updateSwit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("swit", switService.getSwitById(id));
        return "updateSwit";
    }

    @GetMapping("/postSwit")
    String createSwit(Model model) {
        return "createSwit";
    }
}