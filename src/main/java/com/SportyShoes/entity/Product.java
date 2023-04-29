package com.SportyShoes.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	private String name;
	private int price;
	private String sport;
	private String sex;
	private String status;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "pid")	
	private List<PurchasedItems> items;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String name, int price, String sport, String sex, String status) {
		super();
		this.name = name;
		this.price = price;
		this.sport = sport;
		this.sex = sex;
		this.status = status;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<PurchasedItems> getItems() {
		return items;
	}

	public void setItems(List<PurchasedItems> items) {
		this.items = items;
	}
	
}
