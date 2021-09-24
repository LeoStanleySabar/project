package com.skillmine.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.skillmine.domain.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {
	
	List<Product> findByCategory(String category);
	
	@Query("SELECT DISTINCT p.category FROM Product p ")
	List<String> findAllCategories();

}
