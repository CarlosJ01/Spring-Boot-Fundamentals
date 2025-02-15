package com.alfacentauri;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MyListener {
	
	@JmsListener(destination = "${springjms.myQueue}")
	public void receive(String message) {
		System.out.println("MR => " + message);
	}
	
}
