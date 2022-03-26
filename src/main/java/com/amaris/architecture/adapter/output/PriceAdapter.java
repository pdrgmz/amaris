package com.amaris.architecture.adapter.output;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amaris.application.domain.Price;
import com.amaris.architecture.port.output.PricePort;

import lombok.NoArgsConstructor;


@NoArgsConstructor
@Component
public class PriceAdapter implements PricePort{
	
	
	@Autowired
	private PricesRepository priceRepository;
	
	@Autowired
	private PriceMapper priceMapper;

	@Override
	public List<Price> findPrice(Integer productId, Integer brandId, LocalDateTime date) {	
		List<TblPrice> tblPrices = priceRepository.findPrice(productId, brandId, date);
		
		List<Price> prices = new ArrayList<>();
		for (TblPrice tblPrice : tblPrices) {			
			prices.add(priceMapper.toDomain(tblPrice));			
		}		

		return  prices ;
	}

}
