package com.amaris.services;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amaris.exceptions.PriceNotFoundException;
import com.amaris.models.TblPrice;
import com.amaris.repositories.PricesRepository;
import com.amaris.responses.PriceResponse;

@Service
public class PriceService {
	
	@Autowired
	private PricesRepository pricesRepository;	
	
	public PriceResponse getPrice(Integer productId, Integer brandId, LocalDateTime date) throws PriceNotFoundException{	
		
		List<TblPrice> prices = pricesRepository.findPrice(productId, brandId, date );
		
		TblPrice price = prices.stream().max(Comparator.comparing(TblPrice::getPriority)).orElseThrow(() -> new PriceNotFoundException("Price not found"));
			
		return new PriceResponse(price);
		
	}
	
}
