package com.SportyShoes.dto;

import java.util.List;

import com.SportyShoes.entity.Purchase;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class UserDTO {
	
	@Id
	private String email;
	private String lname;
	private String fname;
	private String city;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "pcemail")	
	private List<Purchase> purchases;

	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDTO(String email, String lname, String fname, String city, List<Purchase> purchases) {
		super();
		this.email = email;
		this.lname = lname;
		this.fname = fname;
		this.city = city;
		this.purchases = purchases;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<Purchase> getPurchases() {
		return purchases;
	}

	public void setPurchases(List<Purchase> purchases) {
		this.purchases = purchases;
	}

}
