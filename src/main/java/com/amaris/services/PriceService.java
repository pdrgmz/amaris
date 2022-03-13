package com.amaris.services;

import java.text.ParseException;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amaris.models.TblPrice;
import com.amaris.repositories.PricesRepository;
import com.amaris.responses.PriceResponse;
import com.amaris.utils.Utils;

@Service
public class PriceService {
	
	@Autowired
	private PricesRepository pricesRepository;
	
	
	public PriceResponse getPrice(Integer productId, Integer brandId, String date) throws ParseException{	
		
		List<TblPrice> prices = pricesRepository.findPrice(productId, brandId, Utils.newDate(date));
		
		TblPrice price = prices.stream().max(Comparator.comparing(TblPrice::getPriority)).orElse(null);		
		
		if(price == null) {
			return null;
		}		
			
		return new PriceResponse(price);
		
	}
	
}
