package com.mta.javacourse.michal.izraitel.exception;

public class QuantityException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public QuantityException (String symbol) {
		super("Sorry, there are not enough " + symbol + " stocks in the portfolio.");
	}
	
	

}
