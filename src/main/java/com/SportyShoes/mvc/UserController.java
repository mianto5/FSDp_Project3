package com.SportyShoes.mvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.SportyShoes.dto.UserDTO;
import com.SportyShoes.service.UserDTOService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UserController {
	
	@Autowired
	private UserDTOService userService;
	
	public UserController() {
		System.out.println("user controller constructor");
	}
	
	@GetMapping("/users")
	public String listUsers(HttpServletRequest request, Model model) {
		System.out.println("users page");
		
		String email = request.getParameter("email");
		String lname = request.getParameter("lname");
		
		List<UserDTO> userList = new ArrayList<UserDTO>();
		
		if(email==null && lname==null)
			userList = userService.getAllUserDTOs();
		else if (email!=null && lname==null)
			userList.add(userService.getUserByEmail(email));
		else if (email==null && lname!=null)
			userList = userService.getUserByLname(lname);
		
		model.addAttribute("userList", userList);
		
		return "users";
	}

}
