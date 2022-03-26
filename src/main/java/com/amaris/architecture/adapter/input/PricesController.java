package com.amaris.architecture.adapter.input;

import java.time.LocalDateTime;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amaris.application.service.PriceService;
import com.amaris.architecture.adapter.input.exceptions.PriceNotFoundException;
import com.amaris.architecture.port.input.PriceUseCase;
import com.amaris.utils.Constants;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Prices")
@RestController
@RequestMapping("products")
@CrossOrigin
public class PricesController {
	
	@Autowired
	PriceUseCase priceUseCase;	
	
	@ApiOperation(value = "Get prices")
	@GetMapping(path = "/{product_id}/prices")
	public ResponseEntity<PriceResponse> getPrices(
			
			@Valid @NotBlank @PathVariable("product_id") Integer productId,		
																		
			@Valid @NotBlank @RequestParam @DateTimeFormat(pattern = Constants.DATE_FORMAT) LocalDateTime date,
			@Valid @NotBlank @RequestParam Integer brandId		
			) throws PriceNotFoundException{
				
		return  new ResponseEntity<>(priceUseCase.findPrice(productId, brandId, date), HttpStatus.OK) ;
	}
	
}
