package com.skillmine.service;

import com.skillmine.domain.Product;
import com.skillmine.domain.ShoppingCart;
import com.skillmine.repository.ProductRepository;
import com.skillmine.repository.ShoppingCartRepository;
import com.skillmine.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


@Service
@Transactional
public class ShoppingCartService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    public ShoppingCart saveProducts(ShoppingCart shoppingCartDTO) {
        ShoppingCart shoppingCart = new ShoppingCart();
        Product product = productRepository.findById(Long.parseLong(String.valueOf(shoppingCartDTO.getId()))).get();
        shoppingCart.setProduct(product);
        shoppingCart.setUser(userRepository.findById(1L).get());
        shoppingCart.setStatus(shoppingCartDTO.getStatus());
        shoppingCart.setDate(new Date());
        shoppingCart.setStock(shoppingCartDTO.getStock());
        shoppingCart.setAmount(product.getPrice() * shoppingCartDTO.getStock());
        shoppingCart.setId(shoppingCartDTO.getId());
        shoppingCart.setUserId(shoppingCartDTO.getUserId());

        return shoppingCartRepository.save(shoppingCart);
    }


    public List<ShoppingCart> findAll() {
//        return shoppingCartRepository.findAll();
        return shoppingCartRepository.findByStatus("NOT_PURCHASED");
    }

    public ShoppingCart updateProduct(ShoppingCart shoppingCartDTO, Long id) {
        ShoppingCart updateItem = shoppingCartRepository.findById(id).get();
        updateItem.setStock(shoppingCartDTO.getStock());
        updateItem.setAmount(updateItem.getProduct().getPrice() * shoppingCartDTO.getStock());
        return shoppingCartRepository.save(updateItem);
    }

    public void deleteProduct(Long id) {
        shoppingCartRepository.deleteById(id);
    }

    public void clearShoppingCart(Object object) {
        shoppingCartRepository.deleteAll();
    }


    public List<ShoppingCart> findByPurchased() {
        return shoppingCartRepository.findByStatus("PURCHASED");
    }


    public void purchaseProducts(Long id) {
        ShoppingCart shoppingCart = shoppingCartRepository.findById(id).get();
        shoppingCart.setStatus("PURCHASED");
        shoppingCartRepository.save(shoppingCart);
    }
}
