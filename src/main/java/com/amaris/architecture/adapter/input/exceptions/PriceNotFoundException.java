package com.amaris.architecture.adapter.input.exceptions;

public class PriceNotFoundException extends Exception{
	
	private static final long serialVersionUID = 2517902671722705230L;

	public PriceNotFoundException() {
	        super();
	    }
	
	public PriceNotFoundException(String message) {
        super(message);
    }

}
