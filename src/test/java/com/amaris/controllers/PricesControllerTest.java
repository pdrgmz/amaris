package com.amaris.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest
@AutoConfigureMockMvc
class PricesControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void test1GetPrices() throws Exception {		
		
		String productId = "35455";
		String brandId = "1";
		String date = "2020-06-14-10.00.00";
		
		String URI ="/products/" + productId + "/prices?brandId=" + brandId + "&date=" + date;
		
		System.out.println(URI);
		
		String expected = "{\r\n"
				+ "  \"brand_id\": 1,\r\n"
				+ "  \"start_date\": \"2020-06-14-00.00.00\",\r\n"
				+ "  \"end_date\": \"2020-12-31-23.59.59\",\r\n"
				+ "  \"price_list\": 1,\r\n"
				+ "  \"producto_id\": 35455,\r\n"
				+ "  \"price\": 35.50,\r\n"
				+ "  \"curr\": \"EUR\"\r\n"
				+ "}";
		
		mockMvc.perform(get(URI))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(
				content().json(expected)
				);	
		
	}
	
	@Test
	void test2GetPrices() throws Exception {		
		
		String productId = "35455";
		String brandId = "1";
		String date = "2020-06-14-16.00.00";
		
		String URI ="/products/" + productId + "/prices?brandId=" + brandId + "&date=" + date;
		
		System.out.println(URI);
		
		String expected = "{\r\n"
				+ "  \"brand_id\": 1,\r\n"
				+ "  \"start_date\": \"2020-06-14-15.00.00\",\r\n"
				+ "  \"end_date\": \"2020-06-14-18.30.00\",\r\n"
				+ "  \"price_list\": 2,\r\n"
				+ "  \"producto_id\": 35455,\r\n"
				+ "  \"price\": 25.45,\r\n"
				+ "  \"curr\": \"EUR\"\r\n"
				+ "}";
		
		mockMvc.perform(get(URI))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(
				content().json(expected)
				);	
		
	}
	
	@Test
	void test3GetPrices() throws Exception {		
		
		String productId = "35455";
		String brandId = "1";
		String date = "2020-06-14-21.00.00";
		
		String URI ="/products/" + productId + "/prices?brandId=" + brandId + "&date=" + date;
		
		System.out.println(URI);
		
		String expected = "{\r\n"
				+ "  \"brand_id\": 1,\r\n"
				+ "  \"start_date\": \"2020-06-14-00.00.00\",\r\n"
				+ "  \"end_date\": \"2020-12-31-23.59.59\",\r\n"
				+ "  \"price_list\": 1,\r\n"
				+ "  \"producto_id\": 35455,\r\n"
				+ "  \"price\": 35.5,\r\n"
				+ "  \"curr\": \"EUR\"\r\n"
				+ "}";
		
		mockMvc.perform(get(URI))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(
				content().json(expected)
				);	
		
	}
	
	@Test
	void test4GetPrices() throws Exception {		
		
		String productId = "35455";
		String brandId = "1";
		String date = "2020-06-15-10.00.00";
		
		String URI ="/products/" + productId + "/prices?brandId=" + brandId + "&date=" + date;
		
		System.out.println(URI);
		
		String expected = "{\r\n"
				+ "  \"brand_id\": 1,\r\n"
				+ "  \"start_date\": \"2020-06-15-00.00.00\",\r\n"
				+ "  \"end_date\": \"2020-06-15-11.00.00\",\r\n"
				+ "  \"price_list\": 3,\r\n"
				+ "  \"producto_id\": 35455,\r\n"
				+ "  \"price\": 30.5,\r\n"
				+ "  \"curr\": \"EUR\"\r\n"
				+ "}";
		
		mockMvc.perform(get(URI))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(
				content().json(expected)
				);	
		
	}
	
	@Test
	void test5GetPrices() throws Exception {		
		
		String productId = "35455";
		String brandId = "1";
		String date = "2020-06-16-21.00.00";
		
		String URI ="/products/" + productId + "/prices?brandId=" + brandId + "&date=" + date;
		
		System.out.println(URI);
		
		String expected = "{\r\n"
				+ "  \"brand_id\": 1,\r\n"
				+ "  \"start_date\": \"2020-06-15-16.00.00\",\r\n"
				+ "  \"end_date\": \"2020-12-31-23.59.59\",\r\n"
				+ "  \"price_list\": 4,\r\n"
				+ "  \"producto_id\": 35455,\r\n"
				+ "  \"price\": 29.95,\r\n"
				+ "  \"curr\": \"EUR\"\r\n"
				+ "}";
		
		mockMvc.perform(get(URI))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(
				content().json(expected)
				);	
		
	}

}
