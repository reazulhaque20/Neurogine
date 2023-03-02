package com.neurogine.demo.service;

import java.util.List;

import com.neurogine.demo.model.Product;
import org.springframework.stereotype.Service;
public interface ProductService {

	List<Product> findAll();
	Product addProduct(Product product);
	void deleteProduct(long id);
	Product updateProduct(Long id, Product product);
	Product findById(long id);

}
