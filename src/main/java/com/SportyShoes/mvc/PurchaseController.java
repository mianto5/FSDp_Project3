package com.SportyShoes.mvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.SportyShoes.entity.Purchase;
import com.SportyShoes.service.PurchaseService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class PurchaseController {
	
	@Autowired
	private PurchaseService purchaseService;
	
	public PurchaseController() {
		System.out.println("purchase controller constructor");
	}
	
	@GetMapping("/report")
	public String listPurchases(HttpServletRequest request, Model model) {
		System.out.println("report page");
		
		String status = request.getParameter("status");
		String pcdate = request.getParameter("pcdate");
		
		List<Purchase> purchaseList = new ArrayList<Purchase>();
		
		if(status==null && pcdate==null)
			purchaseList = purchaseService.getAllPurchases();
		else if (status!=null && pcdate==null)
			purchaseList = purchaseService.getPurchasesByStatus(status);
		else if (status==null && pcdate!=null)
			purchaseList = purchaseService.getPurchasesByDate(pcdate);
		
		model.addAttribute("purchaseList", purchaseList);
		
		return "report";
	}

}
