package com.alfacentauri.rsocket.model;

public class Claim {
	
	private float amount;
	private String service;
	
	public Claim(float amount, String service) {
		super();
		this.amount = amount;
		this.service = service;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	@Override
	public String toString() {
		return "Claim [amount=" + amount + ", service=" + service + "]";
	}
	
}
