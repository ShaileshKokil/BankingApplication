package com.capgemini.exception;

public class BankingApplicationException extends RuntimeException {

	public BankingApplicationException() {		
	}	
	
	public BankingApplicationException(String message){
		super(message);
	}
	
	public BankingApplicationException(String message, Throwable t){
		super(message, t);
	}
}
