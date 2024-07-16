package com.alfacentauri;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import com.alfacentauri.entities.Product;
import com.alfacentauri.repositories.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@WebMvcTest
class ProductRestControllerMvcTest {
	
	private static final String PRODUCTS_URL = "/productapi/products/";

	private static final String CONTEXT_PATH = "/productapi";

	private static final int PRICE = 1000;

	private static final String DESCRIPTION = "Its awesome";

	private static final String NAME = "MAC";

	private static final int ID = 1;

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean // Un objeto mock
	private ProductRepository repository;
	
	// Convertir un objeto a JSON
	private ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter(); 
	
	@Test
	void testFindAll() throws Exception {
		List<Product> products = Arrays.asList(buildProduct());
		
		when(repository.findAll()).thenReturn(products); // Cambiar el return del respositorio solo en el test
		
		// Test de una ruta con el estatus
		mockMvc.perform(get(PRODUCTS_URL).contextPath(CONTEXT_PATH))
		.andExpect(status().isOk())
		.andExpect(content().json(objectWriter.writeValueAsString(products)));
	}
	
	@Test
	public void testCreateProduct() throws Exception {
		Product product = buildProduct();
		
		when(repository.save(any())).thenReturn(product);
		
		MockHttpServletRequestBuilder request = post(PRODUCTS_URL)
				.contextPath(CONTEXT_PATH)
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectWriter.writeValueAsString(product));
		
		mockMvc.perform(request).andExpect(status().isOk()).andExpect(content().json(objectWriter.writeValueAsString(product)));
	}
	
	@Test
	public void testUpdateProduct() throws Exception {
		Product product = buildProduct();
		product.setPrice(1200);
		
		when(repository.save(any())).thenReturn(product);
		
		MockHttpServletRequestBuilder request = put(PRODUCTS_URL)
				.contextPath(CONTEXT_PATH)
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectWriter.writeValueAsString(product));
		
		mockMvc.perform(request).andExpect(status().isOk()).andExpect(content().json(objectWriter.writeValueAsString(product)));
	}
	
	@Test
	public void deleteProduct() throws Exception {
		doNothing().when(repository).deleteById(ID);
		mockMvc.perform(delete(PRODUCTS_URL+ID).contextPath(CONTEXT_PATH)).andExpect(status().isOk());
	}
	
	private Product buildProduct() {
		Product product = new Product();
		product.setId(ID);
		product.setName(NAME);
		product.setDescription(DESCRIPTION);
		product.setPrice(PRICE);
		return product;
	}

}
