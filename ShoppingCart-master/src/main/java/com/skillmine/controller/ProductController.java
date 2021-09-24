package com.skillmine.controller;

import com.skillmine.domain.Product;
import com.skillmine.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @ResponseBody
    @GetMapping( produces = "application/json")
    public List<Product> getAll(){
    	List<Product> prods = productService.findAll();
        return prods;
        
    }
    
    @ResponseBody
    @GetMapping( produces = "application/json", value ="/categories")
    public List<String> getAllCategories(){
    	List<String> prods = productService.findAllCategories();
        return prods;
        
    }
    
    @ResponseBody
    @GetMapping(produces = "application/json", value ="/category/{category}")
    public List<Product> getByCategory(@PathVariable("category") String category){
        return productService.findByCategory(category);
    }
    
    @ResponseBody
    @GetMapping( produces = "application/json", value ="/{id}")
    public Product get(@PathVariable("id") Long id){
        return productService.find(id);
    }
    
    @PostMapping( produces = "application/json", consumes = "application/json")
    public void addProductItem(@RequestBody List<Product> products) {
        productService.saveInitialBatch(products);
    }
    
}