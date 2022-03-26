package com.amaris.architecture.port.input;

import java.time.LocalDateTime;

import com.amaris.architecture.adapter.input.PriceResponse;
import com.amaris.architecture.adapter.input.exceptions.PriceNotFoundException;

public interface PriceUseCase {	
	PriceResponse findPrice(Integer productId, Integer brandId, LocalDateTime date) throws PriceNotFoundException;
}
