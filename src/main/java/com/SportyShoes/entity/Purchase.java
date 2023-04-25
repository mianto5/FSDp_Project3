package com.SportyShoes.entity;

import java.time.LocalDate;
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
@Table(name="purchase")
public class Purchase {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pcid;
	private String pcemail;
	private LocalDate pcdate;
	private int totalprice;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "pcid")	
	private List<PurchasedItems> items;
	
	public Purchase() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Purchase(int pcid, String email, LocalDate pcdate, List<PurchasedItems> items, int totalprice) {
		super();
		this.pcid = pcid;
		this.pcemail = email;
		this.pcdate = pcdate;
		this.items = items;
		this.totalprice = totalprice;
	}
	
	public int getPcid() {
		return pcid;
	}
	
	public void setPcid(int pcid) {
		this.pcid = pcid;
	}
	
	public String getEmail() {
		return pcemail;
	}
	
	public void setEmail(String email) {
		this.pcemail = email;
	}
	
	public LocalDate getPcdate() {
		return pcdate;
	}
	
	public void setPcdate(LocalDate pcdate) {
		this.pcdate = pcdate;
	}
	
	public List<PurchasedItems> getItems() {
		return items;
	}
	
	public void setItems(List<PurchasedItems> items) {
		this.items = items;
	}
	
	public int getTotalprice() {
		return totalprice;
	}
	
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

}
