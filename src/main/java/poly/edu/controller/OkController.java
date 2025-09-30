package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/poly")
public class OkController {


    @GetMapping("/ok")
    public String form() {
        return "poly/ok"; 
    }


    @PostMapping("/ok")
    public String m1(Model model) {
        model.addAttribute("message", "m1");
        return "poly/ok";
    }

    
    @GetMapping(value = "/ok", params = "!x")
    public String m2(Model model) {
        model.addAttribute("message", "m2");
        return "poly/ok";
    }

  
    @RequestMapping("/ok/{x}")
    public String m3(@PathVariable("x") String x, Model model) {
        model.addAttribute("message", "m3");
        return "poly/ok";
    }
}
