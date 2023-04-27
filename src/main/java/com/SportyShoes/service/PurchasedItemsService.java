package com.SportyShoes.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SportyShoes.entity.PurchasedItems;
import com.SportyShoes.repo.PurchasedItemsRepo;

@Service
public class PurchasedItemsService {
	
	@Autowired
	private PurchasedItemsRepo itemRepo;
	
	public List<PurchasedItems> getAllPurchases() {
		List<PurchasedItems> items = new ArrayList<>();
		this.itemRepo.findAll().forEach(item -> {
			PurchasedItems i = new PurchasedItems();
			i.setPiid(item.getPiid());
			i.setPcid(item.getPcid());
			i.setPid(item.getPid());
			items.add(i);
		});
		return items;
	}

}
