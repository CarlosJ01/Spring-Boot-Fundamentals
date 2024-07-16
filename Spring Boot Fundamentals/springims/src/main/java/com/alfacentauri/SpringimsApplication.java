package com.alfacentauri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class SpringimsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringimsApplication.class, args);
	}

}
