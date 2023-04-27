package com.SportyShoes.repo;

import org.springframework.data.repository.CrudRepository;

import com.SportyShoes.entity.PurchasedItems;

public interface PurchasedItemsRepo extends CrudRepository<PurchasedItems, String>{

}
