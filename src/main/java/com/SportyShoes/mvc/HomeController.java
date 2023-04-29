package com.SportyShoes.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.SportyShoes.service.AdminLoginService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
	public String changePassword(HttpServletRequest request, Model model){
		String old = request.getParameter("old");
		String new1 = request.getParameter("new1");
		String new2 = request.getParameter("new2");
		
		String message = adminService.changePassword(old, new1, new2);
		model.addAttribute("message", message);
		
		System.out.println("index page POST");
		
		return "index";
	}
	
	@GetMapping("/login")
	public String loginPage() {
		System.out.println("login page");
		return "login";
	}
	
	@PostMapping("/login")
	public String loginP(HttpServletRequest request, HttpServletResponse response, HttpSession session){
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");//http1.0
		response.setHeader("Pragma", "0");//proxies
		
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
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		System.out.println("logout page");
		session.removeAttribute("id");
		session.invalidate();
		return "redirect:index";
	}

}
