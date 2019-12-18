package lv.helloit.switter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.view.RedirectView;

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

    @GetMapping("/swit/{id}/delete")
    RedirectView deleteSwitById(@PathVariable("id") Long id) {
        switService.deleteSwitById(id);
        return new RedirectView("/swits");
    }

    @GetMapping("/swits/delete")
    RedirectView deleteAllSwits() {
        switService.deleteAllSwits();
        return new RedirectView("/swits");
    }

    @GetMapping("/swit/{id}/update")
    String updateSwit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("swit", switService.getSwitById(id));
        return "updateSwit";
    }

    //@GetMapping("/swit/{id}/update/save")
}