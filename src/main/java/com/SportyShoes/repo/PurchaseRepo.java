package com.SportyShoes.repo;

import org.springframework.data.repository.CrudRepository;

import com.SportyShoes.entity.Purchase;

public interface PurchaseRepo extends CrudRepository<Purchase, String>{

}
