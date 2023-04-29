package com.SportyShoes.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
		
		List<Product> productList = productService.getProductByStatus("active");
		model.addAttribute("productList", productList);
		
		return "products";
	}
	
	@GetMapping("/addProduct")
	public String addProductGet() {
		return "addProduct";
	}
	
	@PostMapping("/addProduct")
	public String addProductPost(HttpServletRequest request) {
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String sport = request.getParameter("sport");
		String sex = request.getParameter("sex");
		
		if (name==null || name.isBlank() || price.isBlank()) {
			return "redirect:addProduct";
		}
		
		Product p = new Product(name, Integer.parseInt(price), sport, sex, "active");
		try {
			productService.insertProduct(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:products";
	}
	
	@GetMapping("/deleteProduct")
	public String deleteProductGet(HttpServletRequest request) {
		String pid = request.getParameter("pid");
		System.out.println("Pid: "+pid);
		
		Product p = productService.getProductById(pid);
		p.setStatus("archived");
		try {
			productService.updateProduct(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:products";
	}
	
	@GetMapping("/editProduct")
	public String editProductGet(HttpServletRequest request, Model model) {
		String pid = request.getParameter("pid");
		
		Product p = productService.getProductById(pid);
		model.addAttribute("product", p);
		
		return "editProduct";
	}
	
	@PostMapping("/editProduct")
	public String editProductPost(HttpServletRequest request) {
		String pid = request.getParameter("pid");
		int price = Integer.parseInt(request.getParameter("price"));
		String sport = request.getParameter("sport");
		String sex = request.getParameter("sex");
		
		Product p = productService.getProductById(pid);
		p.setPrice(price);
		p.setSport(sport);
		p.setSex(sex);
		
		try {
			productService.updateProduct(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:products";
	}

}
