package com.amaris.architecture.adapter.output;

import org.springframework.stereotype.Component;

import com.amaris.application.domain.Price;

@Component
public class PriceMapper {
	
	public Price toDomain(TblPrice p) {
		
		Price price = new Price();
		
		price.setBrandId(p.getBrandId());
		price.setStartDate(p.getStartDate());
		price.setEndDate(p.getEndDate());
		price.setPriceList(p.getPriceList());
		price.setProductId(p.getProductId());
		price.setPriority(p.getPriority());
		price.setPrice(p.getPrice());
		price.setCurr(p.getCurr());
		
		return price;
	}

}
