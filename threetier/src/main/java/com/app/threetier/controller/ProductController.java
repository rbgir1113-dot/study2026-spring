package com.app.threetier.controller;

import com.app.threetier.domain.vo.MemberVO;
import com.app.threetier.domain.vo.ProductVO;
import com.app.threetier.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/products/*")
@RequiredArgsConstructor
public class ProductController {

    private final ProductMapper productMapper;

    @GetMapping("register")
    public void goToRegister(ProductVO productVO){;}

    @PostMapping("register")
    public RedirectView addProduct(ProductVO productVO){
        productMapper.insert(productVO);
        return new RedirectView("/products/productList");
    }

    @GetMapping("productList")
    public void goToProductList(Model model){
        model.addAttribute("products", productMapper.selectAll());
    }
}
