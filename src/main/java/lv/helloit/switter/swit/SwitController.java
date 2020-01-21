package lv.helloit.switter.swit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @DeleteMapping("/swits")
    RedirectView deleteAllSwits(){
        switService.deleteAllSwits();
        return new RedirectView("/");
    }

    @DeleteMapping("/swit/{id}")
    RedirectView deleteAllSwits(@PathVariable("id") String id){
        switService.deleteSwitById(id);
        return new RedirectView("/");
    }

    @GetMapping({"/", "/swits"})
    String getSwits(Model model) {
        model.addAttribute("swits", switService.getAllSwits());
        return "swits";
    }

    @GetMapping("/swit/{id}")
    String getSwit(Model model, @PathVariable("id") String id) {
        model.addAttribute("switDTO", switService.getSwitByIdToShow(id));
        return "swit";
    }

    @GetMapping("/swit/{id}/update")
    String updateSwit(Model model, @PathVariable("id") String id) {
        model.addAttribute("swit", switService.getSwitByIdToShow(id));
        return "updateSwit";
    }

    @GetMapping("/postSwit")
    String createSwit(Model model) {
        return "createSwit";
    }

    @PostMapping("/swit")
    public RedirectView createSwit(Model model,
                                   @Valid @ModelAttribute ChangeSwitDTO switDTO,
                                   BindingResult bindingResult,
                                   Authentication authentication) {
        if (bindingResult.hasErrors()) {
            String wrongField = bindingResult.getFieldErrors().get(0).getField();
            model.addAttribute(wrongField + "_fail", true);
            return new RedirectView("/postSwit");
        } else {
            SecurityContextHolder.getContext().getAuthentication();
            switService.addSwit(switDTO, authentication.getName());
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
