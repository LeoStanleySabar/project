package com.skillmine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.skillmine.service.ProductService;
import com.skillmine.service.UserService;

@SpringBootApplication
public class ShoppingCartApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(ShoppingCartApplication.class, args);
		
		UserService userService = applicationContext.getBean(UserService.class);
		userService.saveInitialBatch();
		
		ProductService productService = applicationContext.getBean(ProductService.class);
		productService.saveInitialBatch();

	}
}
