package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/poly")
public class ResultController {

    // /a → view a.html
    @RequestMapping("/a")
    public String m1() {
        return "poly/a"; // file a.html nằm trong templates/poly/a.html
    }

    // /b → forward sang /a giữ Model
    @RequestMapping("/b")
    public String m2(Model model) {
        model.addAttribute("message", "I come from b");
        return "forward:/poly/a"; // ?1: forward sang /poly/a, giữ Model
    }

    // /c → redirect sang /a truyền message qua param
    @RequestMapping("/c")
    public String m3(RedirectAttributes params) {
        params.addAttribute("message", "I come from c");
        return "redirect:/poly/a"; // ?2: redirect sang /poly/a
    }

    // /d → trả về trực tiếp text
    @RequestMapping("/d")
    @ResponseBody // ?3: trả về text trực tiếp
    public String m4() {
        return "I come from d";
    }
}
