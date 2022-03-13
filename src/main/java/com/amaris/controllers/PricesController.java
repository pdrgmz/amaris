package com.amaris.controllers;

import java.text.ParseException;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amaris.responses.PriceResponse;
import com.amaris.services.PriceService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Prices")
@RestController
@RequestMapping("products")
@CrossOrigin
public class PricesController {
	
	@Autowired
	PriceService priceBussines;
	
	
	@ApiOperation(value = "Get prices")
	@GetMapping(path = "/{product_id}/prices")
	public ResponseEntity<PriceResponse> getPrices(
			
			@Valid @NotBlank @PathVariable("product_id") Integer productId,		
			
			@Valid @NotBlank @RequestParam String date,
			@Valid @NotBlank @RequestParam Integer brandId		
			) throws ParseException{
				
		return  new ResponseEntity<>(priceBussines.getPrice(productId, brandId, date), HttpStatus.OK) ;
	}
	
}
