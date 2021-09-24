package com.skillmine.controller;

import com.skillmine.domain.ShoppingCart;
import com.skillmine.dto.ShoppingCartDTO;
import com.skillmine.service.ShoppingCartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/shoppingCart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @ResponseBody
    @PostMapping( produces = "application/json", consumes = "application/json")
    public ShoppingCart addProductItem(@RequestBody ShoppingCart shoppingCart) {
        return shoppingCartService.saveProducts(shoppingCart);
    }


    @ResponseBody
    @GetMapping(produces = "application/json")
    public List<ShoppingCart> getAll(HttpServletResponse response){
        return shoppingCartService.findAll();
    }

    @ResponseBody
    @PutMapping( produces = "application/json", consumes = "application/json", value ="/{id}")
    public ShoppingCart updateProductItem(@RequestBody ShoppingCart shoppingCart, @PathVariable("id") Long ids) {
    	return shoppingCartService.updateProduct(shoppingCart, ids);
    }

    @DeleteMapping(value ="/{id}")
    public void deleteProductItem(@PathVariable("id") Long ids) {
        shoppingCartService.deleteProduct(ids);
    }

    @DeleteMapping()
    public void ClearCart( Object object) {
        shoppingCartService.clearShoppingCart(object);
    }

    @ResponseBody
    @PostMapping( value = "/purchase/{id}")
    public void purchaseProducts(@PathVariable("id") Long id) {
        shoppingCartService.purchaseProducts(id);
    }
}