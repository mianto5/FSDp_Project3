package com.SportyShoes.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SportyShoes.entity.Purchase;
import com.SportyShoes.repo.PurchaseRepo;

@Service
public class PurchaseService {
	
	@Autowired
	private PurchaseRepo purchaseRepo;
	
	public List<Purchase> getAllPurchases() {
		List<Purchase> purchases = new ArrayList<>();
		this.purchaseRepo.findAll().forEach(purchase -> {
			Purchase p = new Purchase();
			p.setPcid(purchase.getPcid());
			p.setPcemail(purchase.getPcemail());
			p.setPcdate(purchase.getPcdate());
			p.setTotalprice(purchase.getTotalprice());
			p.setStatus(purchase.getStatus());
			p.setItems(purchase.getItems());
			purchases.add(p);
		});
		return purchases;
	}

}
