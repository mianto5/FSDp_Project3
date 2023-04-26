package com.SportyShoes.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.SportyShoes.service.AdminLoginService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	@Autowired
	private AdminLoginService adminService;
	
	public HomeController() {
		System.out.println("home controller constructor");
	}
	
	@GetMapping("/index")
	public String homePage() {
		System.out.println("index page GET");
		return "index";
	}
	
	@PostMapping("/index")
	public String changePassword(HttpServletRequest request, HttpSession session){
		String old = request.getParameter("old");
		String new1 = request.getParameter("new1");
		String new2 = request.getParameter("new2");
		
		String message = adminService.changePassword(old, new1, new2);
		session.setAttribute("message", message);
		
		System.out.println("index page POST");
		System.out.println(message);
		
		return "index";
	}
	
	@GetMapping("/login")
	public String loginPage() {
		System.out.println("login page");
		return "login";
	}
	
	@PostMapping("/login")
	public String loginP(HttpServletRequest request, HttpSession session){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			if(this.adminService.getAdminLoginByUsername(username).getPassword().equals(password)) {
				session.setAttribute("id", username);
				return "redirect:index";
			}
		} catch (Exception e) {
			System.out.println("error");
			return "login";
		} 
		return "login";
	}
	
	

}
