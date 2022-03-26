package com.amaris.architecture.port.output;

import java.time.LocalDateTime;
import java.util.List;

import com.amaris.application.domain.PriceDTO;

public interface PricePort {
	List<PriceDTO> findPrice(Integer productId, Integer brandId, LocalDateTime date);
}
