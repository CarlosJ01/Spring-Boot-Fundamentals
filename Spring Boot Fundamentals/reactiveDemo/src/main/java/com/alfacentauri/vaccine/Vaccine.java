package com.alfacentauri.vaccine;

import java.util.Objects;

public class Vaccine {
	private String name;
	private boolean delivered;
	
	public Vaccine(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isDelivered() {
		return delivered;
	}
	public void setDelivered(boolean delivered) {
		this.delivered = delivered;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(delivered, name);
	}
	
	@Override
	public boolean equals(Object obj) {
		Vaccine vaccine = null;
		if (obj instanceof Vaccine) {
			vaccine = (Vaccine) obj;
		}
		return this.name.equals(vaccine.name);
	}
}
