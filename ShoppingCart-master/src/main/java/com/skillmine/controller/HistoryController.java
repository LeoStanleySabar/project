package com.skillmine.controller;

import com.skillmine.domain.ShoppingCart;
import com.skillmine.service.ShoppingCartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/history")
public class HistoryController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @ResponseBody
    @GetMapping( produces = "application/json")
    public List<ShoppingCart> getAll(){
    	
        return shoppingCartService.findByPurchased();
    }

}