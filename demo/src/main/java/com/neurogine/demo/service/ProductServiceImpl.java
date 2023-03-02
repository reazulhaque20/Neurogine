package com.neurogine.demo.service;

import java.util.List;
import java.util.Optional;

import com.neurogine.demo.exphandler.TaskException;
import com.neurogine.demo.model.Product;
import com.neurogine.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductRepository productRepository;

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public Product updateProduct(Long id, Product product) {
		Optional<Product> pOptional = productRepository.findById(id);
		Product newProduct = new Product();
		if (pOptional.isPresent()) {
			newProduct = pOptional.get();
			newProduct.setDescription(product.getDescription());
			newProduct.setProductName(product.getProductName());
			newProduct.setPrice(product.getPrice());
			return productRepository.saveAndFlush(newProduct);
		}

		return null;
	}

	@Override
	public Product addProduct(Product product) {
		return productRepository.saveAndFlush(product);

    }

	@Override
	public void deleteProduct(long id) {
		Optional<Product> proOptional = productRepository.findById(id);
		proOptional.ifPresent(product -> productRepository.delete(product));
		
	}

	@Override
	public Product findById(long id) {
		Optional<Product> productOptional = productRepository.findById(id);
		if(!productOptional.isPresent()){
			throw new TaskException("Product Not Found With ID: " + id, HttpStatus.NOT_FOUND);
		}
		return productOptional.get();
	}

}
