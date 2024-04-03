package kr.co.farmstory.controller.admin;

import kr.co.farmstory.entity.Product;
import kr.co.farmstory.service.admin.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final ProductService service;

    @GetMapping("/product/list")
    public String list(Model model) {
        List<Product> products = service.prodFindAll();
        model.addAllAttributes(products);
        return "/admin/product/list";
    }

    @GetMapping(value = {"/index", "/"})
    public String index() {
        return "/admin/index";
    }

    @GetMapping("/product/register")
    public String registerFrom() {
        return "/admin/product/register";
    }

    @PostMapping("/product/register")
    public String register(@ModelAttribute Product product) {
        log.info("product={}", product.toString());
        return null;
//        return "reditct:/amdin/product/list";
    }
}
