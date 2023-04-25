package com.SportyShoes.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="purchasedItems")
public class PurchasedItems {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int piid; // purchased item record id
	private int pcid; // purchase id
	private int pid;  // product id
	
	public PurchasedItems() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PurchasedItems(int piid, int pcid, int pid) {
		super();
		this.piid = piid;
		this.pcid = pcid;
		this.pid = pid;
	}
	
	public int getPiid() {
		return piid;
	}
	
	public void setPiid(int piid) {
		this.piid = piid;
	}
	
	public int getPcid() {
		return pcid;
	}
	
	public void setPcid(int pcid) {
		this.pcid = pcid;
	}
	
	public int getPid() {
		return pid;
	}
	
	public void setPid(int pid) {
		this.pid = pid;
	}

}
