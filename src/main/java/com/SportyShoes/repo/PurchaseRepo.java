package com.SportyShoes.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.SportyShoes.entity.Purchase;

public interface PurchaseRepo extends CrudRepository<Purchase, String>{
	
	public List<Purchase> findByStatus(String status);
	
	public List<Purchase> findByPcdate(LocalDate date);
	
	public List<Purchase> findByPcdateBetween(LocalDate startDate, LocalDate endDate);

}
