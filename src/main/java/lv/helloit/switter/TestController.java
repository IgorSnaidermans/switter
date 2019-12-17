package lv.helloit.switter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TestController {
    @GetMapping({"/", "/hello", "/test"})
    public String hello(Model model,
                        @RequestParam(value="name", defaultValue="World") String name) {
        model.addAttribute("pageTitle", "Welcome page");
        model.addAttribute("visitorName", name);
        model.addAttribute("numbers", List.of("Apple", "Grape", "Coconut"));
        return "hello";
    }
}
