package com.SportyShoes.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.SportyShoes.entity.Product;
import com.SportyShoes.service.ProductService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	public ProductController() {
		System.out.println("product controller constructor");
	}
	
	@GetMapping("/products")
	public String listProducts(HttpServletRequest request) {
		System.out.println("products page");
		
		List<Product> productList = productService.getAllProducts();
		request.setAttribute("productList", productList);
		
		for(Product p: productList) {
			System.out.println(p.getPid());
			System.out.println(p.getName());
		}
		
		return "products";
	}
	

}
