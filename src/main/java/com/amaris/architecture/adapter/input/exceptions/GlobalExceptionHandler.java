package com.amaris.architecture.adapter.input.exceptions;

import java.text.ParseException;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
@Component
public class GlobalExceptionHandler {
	
	private static final String ERROR = "error";
	private static final String THE_PARAMETER = "The parameter '";
	
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ResponseEntity<Object> handleMissingParams(MissingServletRequestParameterException ex) {
		
		Map<String, String> body = new HashMap<>();  

	    body.put(ERROR, THE_PARAMETER + ex.getParameterName() + "' is missing");

	    return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<Object> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
		
		Map<String, String> body = new HashMap<>();  

	    body.put(ERROR, THE_PARAMETER + ex.getName() + "' with value: '"  + ex.getValue() + "', should be " + ex.getRequiredType());

	    return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
	}
		
	@ExceptionHandler(ParseException.class)
	public ResponseEntity<Object> handleParseException(ParseException ex) {
		
		Map<String, String> body = new HashMap<>();  

	    body.put(ERROR, THE_PARAMETER + ex.getLocalizedMessage() + "'  has wrong format");

	    return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(HttpClientErrorException.class)
	public ResponseEntity<Object> handleHttpClientErrorException(HttpClientErrorException ex) {
		
		Map<String, String> body = new HashMap<>();  

	    body.put(ERROR, ex.getStatusText());

	    return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DateTimeParseException.class)
	public ResponseEntity<Object> handleDateTimeParseException(DateTimeParseException ex) {
		
		Map<String, String> body = new HashMap<>();  

	    body.put(ERROR, THE_PARAMETER + "date' with value '" + ex.getParsedString() + "' could not be parsed at index " + ex.getErrorIndex());

	    return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(PriceNotFoundException.class)
	public ResponseEntity<Object> handlePriceNotFoundException(PriceNotFoundException ex) {
		
		Map<String, String> body = new HashMap<>();  

	    body.put(ERROR, ex.getMessage());

	    return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}	

	
}
