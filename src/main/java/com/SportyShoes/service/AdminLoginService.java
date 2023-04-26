package com.SportyShoes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SportyShoes.entity.AdminLogin;
import com.SportyShoes.repo.AdminLoginRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AdminLoginService {
	
	@Autowired
	private AdminLoginRepo adminRepo;
	
	public AdminLogin getAdminLoginByUsername(String username) {
		return adminRepo.findById(username)
				.orElseThrow(()-> new EntityNotFoundException(username+" not found"));
	}
	
	public AdminLogin updateAdminLogin(AdminLogin adminLogin) {
		return this.adminRepo.save(adminLogin);
	}
	
	// validate login
	
	
	public String changePassword(String old, String new1, String new2) {
		String oldDB = getAdminLoginByUsername("admin").getPassword();
		if(old.isBlank() || new1.isBlank() || new2.isBlank())
			return "No box should stay empty.";
		if(!new1.equals(new2))
			return "New passwords are not the same.";
		if(!old.equals(oldDB))
			return "Old password is incorrect.";
		else {
			updateAdminLogin(new AdminLogin("admin", new1));
			return "Password changed successfully.";
		}
	}

}
