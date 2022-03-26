package com.amaris.architecture.port.output;

import java.time.LocalDateTime;
import java.util.List;

import com.amaris.application.domain.Price;

public interface PricePort {
	List<Price> findPrice(Integer productId, Integer brandId, LocalDateTime date);
}
