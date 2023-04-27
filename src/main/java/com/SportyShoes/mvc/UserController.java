package com.SportyShoes.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.SportyShoes.dto.UserDTO;
import com.SportyShoes.service.UserDTOService;

@Controller
public class UserController {
	
	@Autowired
	private UserDTOService userService;
	
	public UserController() {
		System.out.println("user controller constructor");
	}
	
	@GetMapping("/users")
	public String listUsers(Model model) {
		System.out.println("users page");
		
		List<UserDTO> userList = userService.getAllUserDTOs();
		model.addAttribute("userList", userList);
		
		for(UserDTO u: userList) {
			System.out.println(u.getLname());
			System.out.println(u.getPurchases());
		}
		
		return "users";
	}

}
