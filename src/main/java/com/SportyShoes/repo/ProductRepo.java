package com.SportyShoes.repo;

import org.springframework.data.repository.CrudRepository;

import com.SportyShoes.entity.Product;

public interface ProductRepo extends CrudRepository<Product, String>{

}
