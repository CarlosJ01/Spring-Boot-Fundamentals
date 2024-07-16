package com.alfacentauri;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.alfacentauri.entities.Product;

@SpringBootTest
class ProductRestApiApplicationTests {

	@Value("${productrestapi.services.url}") // Usar un a variable de propietes
	private String baseURL;
	
	@Test
	void testGetProduct() {
		RestTemplate restTemplate = new RestTemplate();
		Product product = restTemplate.getForObject(baseURL+"4", Product.class);
		
		assertNotNull(product);
		assertEquals("Nintendo 2DS", product.getName());
	}
	
	@Test
	void testCreateProduct() {
		RestTemplate restTemplate = new RestTemplate();
		Product product = new Product();
		product.setName("Nuevo Producto");
		
		Product newProduct = restTemplate.postForObject(baseURL, product, Product.class);
		assertNotNull(newProduct);
		assertNotNull(newProduct.getId());
		assertEquals("Nuevo Producto" ,newProduct.getName());
	}
	
	@Test
	public void testUpdateProduct() {
		RestTemplate restTemplate = new RestTemplate();
		Product product = restTemplate.getForObject(baseURL+"6", Product.class);
		product.setPrice(6000);
		restTemplate.put("http://localhost:8080/productapi/products/", product);
	}

}
