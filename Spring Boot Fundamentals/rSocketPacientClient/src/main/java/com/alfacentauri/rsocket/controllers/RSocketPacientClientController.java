package com.alfacentauri.rsocket.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alfacentauri.rsocket.model.Claim;
import com.alfacentauri.rsocket.model.ClinicalData;
import com.alfacentauri.rsocket.model.Pacient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class RSocketPacientClientController {
	
	private final RSocketRequester rSocketRequester;
	
	Logger logger = LoggerFactory.getLogger(RSocketPacientClientController.class);
	
	public RSocketPacientClientController(@Autowired RSocketRequester.Builder builder) {
		this.rSocketRequester = builder.tcp("localhost", 7000);
	}
	
	@GetMapping("/request-response")
	public Mono<ClinicalData> requestResponse(@RequestBody Pacient pacient) {
		logger.info("Sending the rsocket request for pacient => " + pacient);
		return rSocketRequester.route("get-pacient-data")
			.data(pacient)
			.retrieveMono(ClinicalData.class);
	}
	
	
	@PostMapping("/fire-and-forget")
	public Mono<Void> fireAndForget(@RequestBody Pacient pacient) {
		logger.info("Pacient being check out => " + pacient);
		return rSocketRequester.route("pacient-checkout").data(pacient).retrieveMono(Void.class);
	}
	
	@GetMapping("/request-stream")
	public ResponseEntity<Flux<Claim>> requestStream() {
		Flux<Claim> data = rSocketRequester.route("claim-stream").retrieveFlux(Claim.class);
		return ResponseEntity.ok()
				.contentType(MediaType.TEXT_EVENT_STREAM)
				.body(data);
	}
}
