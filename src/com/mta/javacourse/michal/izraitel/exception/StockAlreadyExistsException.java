package com.mta.javacourse.michal.izraitel.exception;

public class StockAlreadyExistsException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public StockAlreadyExistsException(String symbol) {
		super("Can't add stock " + symbol + " because it already exists in the array.");
	}
}
