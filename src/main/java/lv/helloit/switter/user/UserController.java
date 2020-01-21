package lv.helloit.switter.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    String signUp(Model model,
                          @Valid @ModelAttribute CreateUserDTO createUserDTO,
                          BindingResult bindingResult){
        if (!bindingResult.hasErrors()) {
            userService.addUser(createUserDTO);
        }
        return "redirect:/";
    }

    @GetMapping("/signup")
    String signUp(Model model){
        return "signUp";
    }
}
