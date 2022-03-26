package com.amaris.architecture.adapter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.amaris.AmarisApplication;
import com.amaris.application.service.PriceService;
import com.amaris.architecture.adapter.output.PriceAdapter;


@Configuration
@ComponentScan(basePackageClasses = AmarisApplication.class)
public class BeanConfiguration {
	
	@Bean
	PriceService priceService(PriceAdapter adapter) {
		return new PriceService(adapter);
	}

}
