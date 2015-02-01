package com.mta.javacourse.michal.izraitel.exception;

public class BalanceException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public BalanceException() {
		super ("Your portfolio balance is negative!");
	}
	
	public BalanceException(String message) {
		super(message);
	}

}
