package com.SportyShoes.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.SportyShoes.entity.Product;
import com.SportyShoes.entity.Purchase;
import com.SportyShoes.service.PurchaseService;

@Controller
public class PurchaseController {
	
	@Autowired
	private PurchaseService purchaseService;
	
	public PurchaseController() {
		System.out.println("purchase controller constructor");
	}
	
	@GetMapping("/report")
	public String listPurchases(Model model) {
		System.out.println("report page");
		
		List<Purchase> purchaseList = purchaseService.getAllPurchases();
		model.addAttribute("purchaseList", purchaseList);
		
		for(Purchase p: purchaseList) {
			System.out.println(p.getStatus());
			System.out.println(p.getItems());
		}
		
		return "report";
	}

}
