package com.alfacentauri.rsocket.controller;

import java.time.Duration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import com.alfacentauri.rsocket.model.Claim;
import com.alfacentauri.rsocket.model.ClinicalData;
import com.alfacentauri.rsocket.model.Pacient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class RSocketPacientController {
	
	Logger logger = LoggerFactory.getLogger(RSocketPacientController.class);
	
	@MessageMapping("get-pacient-data")
	public Mono<ClinicalData> requestResponse(@RequestBody Pacient pacient) {
		logger.info("Recive pacient => " + pacient);
		return Mono.just(new ClinicalData(90, "80/120"));
	}
	
	@MessageMapping("pacient-checkout")
	public Mono<Void> fireAndForget(@RequestBody Pacient pacient) {
		logger.info("Pacient checking out => " + pacient);
		logger.info("Billing Initiated");
		return Mono.empty().then();
	}
	
	@MessageMapping("claim-stream")
	public Flux<Claim> requestStream() {
		return Flux.just(new Claim(1000f, "MRI Scan"), new Claim(2000f, "Surgery"), new Claim(500f, "Food")).delayElements(Duration.ofSeconds(2));
	}
}
