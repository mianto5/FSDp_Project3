package com.SportyShoes.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SportyShoes.dto.UserDTO;
import com.SportyShoes.repo.UserDTORepo;

@Service
public class UserDTOService {
	
	@Autowired
	private UserDTORepo userDTORepo;
	
	public List<UserDTO> getAllUserDTOs() {
		List<UserDTO> users = new ArrayList<>();
		this.userDTORepo.findAll().forEach(user -> {
			UserDTO u = new UserDTO();
			u.setEmail(user.getEmail());
			u.setLname(user.getLname());
			u.setFname(user.getFname());
			u.setCity(user.getCity());
			u.setPurchases(user.getPurchases());
			users.add(u);
		});
		return users;
	}
	
	public UserDTO getUserByEmail(String email){
		return this.userDTORepo.findByEmail(email);
	}
	
	public List<UserDTO> getUserByLname(String lname){
		return this.userDTORepo.findByLname(lname);
	}

}
