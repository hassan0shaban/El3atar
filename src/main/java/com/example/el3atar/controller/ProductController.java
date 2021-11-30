package com.example.el3atar.controller;


import com.example.el3atar.pojo.Product;
import com.example.el3atar.request.ProductRequest;
import com.example.el3atar.service.ProductServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ProductController {

    @Resource(name = "productService")
    private ProductServiceImpl productService;

    @GetMapping("/products")
    public List<Product> getProducts(
            @RequestParam("page") Integer page,
            @RequestParam("page-size") Integer pageSize
    ) {
       return productService.getProducts(page, pageSize);
    }

    @GetMapping("/{category}/products")
    public List<Product> getCategoryProducts(
            @PathVariable("category") String category
    ) {
       return productService.getProducts(category);
    }

    @GetMapping("/product/{product-id}")
    public Product getProduct(
            @PathVariable("product-id") Integer productId
    ) {
       return productService.getProduct(productId).orElse(null);
    }

    @PostMapping("/product")
    public Integer insertProduct(
            @RequestBody Product product
    ) {
       return productService.insertProduct(product);
    }
}
