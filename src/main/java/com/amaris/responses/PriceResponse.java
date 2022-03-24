package com.amaris.responses;

import java.time.LocalDateTime;

import com.amaris.models.TblPrice;
import com.amaris.utils.Constants;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PriceResponse {
	
	@JsonProperty("brand_id")
	private Integer brandId;
	
	@JsonProperty("start_date")
	@JsonFormat(pattern=Constants.DATE_FORMAT)
	private LocalDateTime startDate;
	
	@JsonProperty("end_date")
	@JsonFormat(pattern=Constants.DATE_FORMAT)
	private LocalDateTime endDate;
	
	@JsonProperty("price_list")
	private Integer priceList;
	
	@JsonProperty("producto_id")
	private Integer productId;
	
	@JsonProperty("price")
	private Float price;
	
	@JsonProperty("curr")
	private String curr;	
	
	public PriceResponse( TblPrice p ){		
		this.brandId = p.getBrandId();
		this.startDate = p.getStartDate();
		this.endDate = p.getEndDate();
		this.priceList = p.getPriceList();
		this.productId = p.getProductId();
		this.price = p.getPrice();
		this.curr = p.getCurr();
	}

}
