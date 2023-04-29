package com.SportyShoes.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.SportyShoes.entity.Product;

public interface ProductRepo extends CrudRepository<Product, String>{
	
	public List<Product> findByStatus(String status);

}
