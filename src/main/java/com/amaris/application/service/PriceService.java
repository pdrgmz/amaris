package com.amaris.application.service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.amaris.application.domain.Price;
import com.amaris.architecture.adapter.input.PriceResponse;
import com.amaris.architecture.adapter.input.PriceResponseMapper;
import com.amaris.architecture.adapter.input.exceptions.PriceNotFoundException;
import com.amaris.architecture.port.input.PriceUseCase;
import com.amaris.architecture.port.output.PricePort;

public class PriceService implements PriceUseCase{
	

	private PricePort pricePort;	
	@Autowired
	private PriceResponseMapper priceResponseMapper;
	
	
	public PriceService (PricePort pricePort) {
		this.pricePort = pricePort;
	}


	@Override
	public PriceResponse findPrice(Integer productId, Integer brandId, LocalDateTime date) throws PriceNotFoundException {
		
		List<Price> prices = pricePort.findPrice(productId, brandId, date);
		
		Price price = prices.stream().max(Comparator.comparing(Price::getPriority))
			.orElseThrow(() -> new PriceNotFoundException("Price not found"));
		
		return priceResponseMapper.toWeb(price);	
		
	}


	
}
