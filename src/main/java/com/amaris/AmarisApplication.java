package com.amaris;

import java.text.ParseException;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.amaris.models.TblPrice;
import com.amaris.repositories.PricesRepository;
import com.amaris.utils.Utils;

@SpringBootApplication
public class AmarisApplication {
	
	@Autowired
	private PricesRepository pricesRepository;

	public static void main(String[] args) {
		SpringApplication.run(AmarisApplication.class, args);
	}
	
	@PostConstruct
	public void init() throws NumberFormatException, ParseException{
		
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		
	/*
	
	BRAND_ID         START_DATE                                    END_DATE                        PRICE_LIST                   PRODUCT_ID  PRIORITY                 PRICE           CURR
	
	------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	1         2020-06-14-00.00.00                        2020-12-31-23.59.59                        1                        35455                0                        35.50            EUR
	
	1         2020-06-14-15.00.00                        2020-06-14-18.30.00                        2                        35455                1                        25.45            EUR
	
	1         2020-06-15-00.00.00                        2020-06-15-11.00.00                        3                        35455                1                        30.50            EUR
	
	1         2020-06-15-16.00.00                        2020-12-31-23.59.59                        4                        35455                1                        38.95            EUR
	
	
	*/
		
		List<TblPrice> prices = Stream.of(
				new TblPrice(null, 1 , Utils.newDate("2020-06-14-00.00.00") , Utils.newDate("2020-12-31-23.59.59") , 1 ,  35455 , 0 , Float.parseFloat("35.50") , "EUR"),
				new TblPrice(null, 1 , Utils.newDate("2020-06-14-15.00.00") , Utils.newDate("2020-06-14-18.30.00") , 2 ,  35455 , 1 , Float.parseFloat("25.45") , "EUR"),
				new TblPrice(null, 1 , Utils.newDate("2020-06-15-00.00.00") , Utils.newDate("2020-06-15-11.00.00") , 3 ,  35455 , 1 , Float.parseFloat("30.50") , "EUR"),
				new TblPrice(null, 1 , Utils.newDate("2020-06-15-16.00.00") , Utils.newDate("2020-12-31-23.59.59") , 4 ,  35455 , 1 , Float.parseFloat("29.95") , "EUR")				
				).collect(Collectors.toList());
		
		
		
		pricesRepository.saveAll(prices);
		
		
	}
	
	

}
