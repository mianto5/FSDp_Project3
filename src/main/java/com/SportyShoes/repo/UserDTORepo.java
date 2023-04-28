package com.SportyShoes.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.SportyShoes.dto.UserDTO;

public interface UserDTORepo extends CrudRepository<UserDTO, String>{
	
	public UserDTO findByEmail(String email);
	
	public List<UserDTO> findByLname(String lname);

}
