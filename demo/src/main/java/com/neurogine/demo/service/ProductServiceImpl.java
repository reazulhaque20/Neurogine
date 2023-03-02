package com.neurogine.demo.service;

import java.util.List;
import java.util.Optional;

import com.neurogine.demo.model.Product;
import com.neurogine.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
	public void updateProduct(Product product) {
		Product proOptional = productRepository.findById(product.getId()).get();
		proOptional.setDescription(product.getDescription());
		proOptional.setProductName(product.getProductName());
		proOptional.setPrice(product.getPrice());
		productRepository.save(proOptional);
		
	}

	@Override
	public Product addProduct(Product product) {
		productRepository.save(product);

        return product;
    }

	@Override
	public void deleteProduct(long id) {
		Optional<Product> proOptional = productRepository.findById(id);
		productRepository.delete(proOptional.get());
		
	}

	@Override
	public Product findById(long id) {
		Optional<Product> productOptional = productRepository.findById(id).get();
		productOptional.ifPresent(return productOptional);
		productOptional.orElseThrow()
	}

}
