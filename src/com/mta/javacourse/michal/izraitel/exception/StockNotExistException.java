package com.mta.javacourse.michal.izraitel.exception;

public class StockNotExistException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public StockNotExistException(String symbol) {
		super ("Sorry, stock " + symbol + "doesn't exist in the portfolio.");
	}

}
