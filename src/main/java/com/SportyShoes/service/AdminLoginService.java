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
	
	// change password

}
