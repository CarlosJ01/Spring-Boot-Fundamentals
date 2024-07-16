package com.alfacentauri;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringimsApplicationTests {
	
	@Autowired
	MessagerSender sender;
	
	@Test
	void testSendAndRecive() {
		System.out.println("Message send");
		sender.send("Hello World JMS");
	}

}
