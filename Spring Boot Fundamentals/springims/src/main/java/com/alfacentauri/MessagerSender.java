package com.alfacentauri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessagerSender {
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Value(value = "${springjms.myQueue}")
	private String queue;
	
	
	public void send(String message) {
		jmsTemplate.convertAndSend(queue, message);
	}
}
