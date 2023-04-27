package com.SportyShoes.repo;

import org.springframework.data.repository.CrudRepository;

import com.SportyShoes.dto.UserDTO;

public interface UserDTORepo extends CrudRepository<UserDTO, String>{

}
