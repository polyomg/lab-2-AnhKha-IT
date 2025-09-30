package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import poly.edu.model.Product;

@Controller

public class ProductController {

	@GetMapping("/product/form")
    public String form(Model model) {
        // Tạo một product trống để binding vào form
        model.addAttribute("product", new Product());
        return "product/form";
    }

    @PostMapping("/product/save")
    public String save(@ModelAttribute Product product, Model model) {
        // Lưu lại dữ liệu product gửi từ form
        model.addAttribute("product", product);
        return "product/form";
    }
}
