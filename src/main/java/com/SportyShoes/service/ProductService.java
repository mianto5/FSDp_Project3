package com.SportyShoes.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SportyShoes.entity.Product;
import com.SportyShoes.repo.ProductRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepo productRepo;
	
	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<>();
		this.productRepo.findAll().forEach(product -> {
			Product p = new Product();
			p.setPid(product.getPid());
			p.setName(product.getName());
			p.setPrice(product.getPrice());
			p.setSport(product.getSport());
			p.setSex(product.getSex());
			products.add(p);
		});
		return products;
	}


}
