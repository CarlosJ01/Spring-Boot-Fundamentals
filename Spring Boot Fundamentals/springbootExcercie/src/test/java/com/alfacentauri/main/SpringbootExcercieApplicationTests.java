package com.alfacentauri.main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootExcercieApplicationTests {
	
	@Autowired
	SumOfTwoNumbers object;
	
	@Test
	void contextLoads() {
		assertNotNull(object);
		int sum = object.sum(10, 10);
		assertInstanceOf(Integer.class, sum);
		assertEquals(20, sum);
	}

}
