package com.amaris.architecture.adapter.input;

import org.springframework.stereotype.Component;

import com.amaris.application.domain.Price;

@Component
public class PriceResponseMapper {	

	public PriceResponse toWeb(Price p) {
		
		PriceResponse price = new PriceResponse();
			
		price.setBrandId(p.getBrandId());
		price.setStartDate(p.getStartDate());
		price.setEndDate(p.getEndDate());
		price.setPriceList(p.getPriceList());
		price.setProductId(p.getProductId());
		price.setPrice(p.getPrice());
		price.setCurr(p.getCurr());
		
		return price;
	}

}
