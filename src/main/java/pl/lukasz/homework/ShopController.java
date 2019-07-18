package pl.lukasz.homework;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShopController {
    ProductRepository productRepository;

    public ShopController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @RequestMapping("/add")
    public String addProduct(@RequestParam String name, Double price) {
        Product product = new Product(name, price);
        productRepository.addProduct(product);
        return "redirect:/";
    }

    @RequestMapping("/table")
    public String displayTable(Model model) {
        model.addAttribute("products", productRepository.getProduct());
        model.addAttribute("totalPrice", productRepository.getTotalPrice());
        return "table";
    }

    @RequestMapping("/list")
    public String displayList(Model model) {
        model.addAttribute("products", productRepository.getProduct());
        model.addAttribute("totalPrice", productRepository.getTotalPrice());
        return "list";
    }
}