package com.SportyShoes.service;

import java.time.LocalDate;
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
	
	public List<Purchase> getPurchasesByStatus(String status){
		return this.purchaseRepo.findByStatus(status);
	}
	
	public List<Purchase> getPurchasesByDate(String pcdate){
		LocalDate today = LocalDate.now();
		if(pcdate.equals("today"))
			return this.purchaseRepo.findByPcdate(today);
		else if(pcdate.equals("week"))
			return this.purchaseRepo.findByPcdateBetween(today.minusWeeks(1), today);
		else if(pcdate.equals("month"))
			return this.purchaseRepo.findByPcdateBetween(today.minusMonths(1), today);
		else
			return null;
	}

}
