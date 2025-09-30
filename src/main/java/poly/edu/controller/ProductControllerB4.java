package poly.edu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import poly.edu.model.Product;

@Controller
public class ProductControllerB4 {

    @GetMapping("/product/formB4")
    public String form(Model model,
                       @RequestParam(defaultValue = "1") int page,
                       @RequestParam(defaultValue = "5") int size) {

        // sản phẩm mặc định
        Product p = new Product("iPhone 30", 5000.0);
        model.addAttribute("productDefault", p);

        // danh sách 20 sản phẩm
        List<Product> all = getItems();

        // tính phân trang
        int totalPages = (int) Math.ceil((double) all.size() / size);
        int fromIndex = (page - 1) * size;
        int toIndex = Math.min(fromIndex + size, all.size());

        List<Product> pageItems = all.subList(fromIndex, toIndex);

        model.addAttribute("items", pageItems);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("size", size);

        return "product/formB4";
    }

    @PostMapping("/product/saveB4")
    public String save(@ModelAttribute("product") Product p,
                       Model model,
                       @RequestParam(defaultValue = "1") int page,
                       @RequestParam(defaultValue = "5") int size) {

        // sản phẩm vừa lưu
        model.addAttribute("savedProduct", p);

        // sản phẩm mặc định
        Product defaultProduct = new Product("iPhone 30", 5000.0);
        model.addAttribute("productDefault", defaultProduct);

        // danh sách sản phẩm & phân trang
        List<Product> all = getItems();
        int totalPages = (int) Math.ceil((double) all.size() / size);
        int fromIndex = (page - 1) * size;
        int toIndex = Math.min(fromIndex + size, all.size());
        List<Product> pageItems = all.subList(fromIndex, toIndex);

        model.addAttribute("items", pageItems);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("size", size);

        return "product/formB4";
    }

    @ModelAttribute("allItems")
    public List<Product> getItems() {
        List<Product> list = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            list.add(new Product("Product " + i, (double) i * 10));
        }
        return list;
    }
}
