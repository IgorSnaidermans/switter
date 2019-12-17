package lv.helloit.switter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class SwitController {
    private final SwitService switService;

    public SwitController(SwitService switService) {
        this.switService = switService;
    }

    @GetMapping("/swits")
    String getSwits(Model model) {
        model.addAttribute("swits", switService.getAllSwits());
        return "swits";
    }

    @GetMapping("/swit/{id}")
    String getSwit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("swit", switService.getSwitById(id));
        return "swit";
    }
}
