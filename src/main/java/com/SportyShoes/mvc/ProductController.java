package com.SportyShoes.mvc;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	public String listProducts(Model model) {
		System.out.println("products page");
		
		List<Product> productList = productService.getAllProducts();
		model.addAttribute("productList", productList);
		
		for(Product p: productList) {
			System.out.println(p.getPid());
			System.out.println(p.getName());
		}
		
		return "products";
	}
	
	@GetMapping("/addProduct")
	public String addProductGet() {
		return "addProduct";
	}
	
	@PostMapping("/addProduct")
	public String addProductPost(HttpServletRequest request) {
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		String sport = request.getParameter("sport");
		String sex = request.getParameter("sex");
		
		Product p = new Product(name, price, sport, sex);
		try {
			productService.insertProduct(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:products";
	}

}
