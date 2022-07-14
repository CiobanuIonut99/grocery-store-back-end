package com.grocerystore.controller;

import com.grocerystore.dto.ProductDto;
import com.grocerystore.entity.Product;
import com.grocerystore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAll() {
        return productService.getAll();
    }

    @PostMapping
    public ProductDto save(@RequestBody ProductDto productDto) {
        return productService.save(productDto);
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return productService.getById(id);
    }

    @DeleteMapping("/{id}")
    public Product deleteById(@PathVariable Long id) {
        return productService.deleteById(id);
    }

    @PutMapping("/{id}")
    public ProductDto updateById(@PathVariable Long id, @RequestBody ProductDto productDto) {
        return productService.updateById(id, productDto);
    }
}
