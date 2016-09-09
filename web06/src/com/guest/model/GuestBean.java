package com.guest.model;

import java.sql.Timestamp;

public class GuestBean {
	private int sabun;
	private String name;
	private Timestamp nalja;
	private int pay;
	
	
	public GuestBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getSabun() {
		return sabun;
	}
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Timestamp getNalja() {
		return nalja;
	}
	public void setNalja(Timestamp nalja) {
		this.nalja = nalja;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}
	
	
}
