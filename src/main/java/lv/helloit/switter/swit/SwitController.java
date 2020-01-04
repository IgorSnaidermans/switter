package lv.helloit.switter.swit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;

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

    @PostMapping("/swit")
    public RedirectView createSwit(Model model,
                                   @Valid @ModelAttribute ChangeSwitDTO swit,
                                   BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String wrongField = bindingResult.getFieldErrors().get(0).getField();
            model.addAttribute(wrongField + "_fail", true);
            return new RedirectView("/postSwit");
        } else {
            switService.addSwit(swit);
            return new RedirectView("/");
        }
    }

    @PostMapping("/swit/update")
    public RedirectView saveSwitUpdate(Model model,
                                       @ModelAttribute @Valid UpdateSwitDTO updateSwitDTO,
                                       BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String wrongField = bindingResult.getFieldErrors().get(0).getField();
            model.addAttribute(wrongField + "_fail", true);
            return new RedirectView("/swit/" + updateSwitDTO.getId() + "/update");
        } else {
            switService.update(updateSwitDTO);
            return new RedirectView("/");
        }
    }
}