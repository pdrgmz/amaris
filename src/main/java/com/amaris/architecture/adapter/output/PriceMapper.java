package com.amaris.architecture.adapter.output;

import org.springframework.stereotype.Component;

import com.amaris.application.domain.PriceDTO;

@Component
public class PriceMapper {
	
	public PriceDTO toDomain(TblPrice p) {
		
		PriceDTO price = new PriceDTO();
		
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
