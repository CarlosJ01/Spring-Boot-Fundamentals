package com.alfacentauri;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class RestFileProcessingApplicationTests {

	@Autowired
	RestTemplate restTemplate;
	
	@Test
	void testUpload() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		
		MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
		body.add("file", new ClassPathResource("C:\\Users\\103412781\\Pictures\\test.png"));
		
		HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(body, headers);
		
		ResponseEntity<Boolean> response = restTemplate.postForEntity("http://localhost:8080/upload", request, Boolean.class);
		
		System.out.println(response.getBody());
	}
	
	@Test
	void testDownload() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		
		HttpEntity<Object> request = new HttpEntity<>(headers);
		
		ResponseEntity<byte[]> response = restTemplate.exchange("http://localhost:8080/download/test.png", HttpMethod.GET, request, byte[].class);
		Files.write(Paths.get("C:\\Users\\103412781\\Pictures\\test2.png"), (byte[]) request.getBody(), null);
	}

}
