package com.capgemini.model;

import java.math.BigDecimal;

import com.capgemini.util.ValidatorUtils;

public class Account {

	private String type;
	private String accountNumber;
	private String customerId;
	BigDecimal balance;

	public static class AccountBuilder{	
		private String customerId;
		private String type;
		
		private String accountNumber;
		BigDecimal balance = new BigDecimal(0);
		
		public AccountBuilder(String type, String customerId){			
			if(null == type || type.trim().isEmpty() || !ValidatorUtils.isValidNumber(6, customerId)){
				throw new IllegalArgumentException("Account type cannot be null/empty and customer Id must be a 6 digit number");
			}
			this.type = type;
			this.customerId = customerId;
		}
		
		public AccountBuilder setAccountNumber(String accountNumber){
			if(!ValidatorUtils.isValidNumber(10, accountNumber)){
				throw new IllegalArgumentException("Account number must be a 10 digit number");
			}
			this.accountNumber = accountNumber;
			return this;
		}
		
		public Account build(){
			return new Account(this);
		}
	}	
	
	private Account(AccountBuilder builder){
		this.type = builder.type;
		this.customerId = builder.customerId;
		this.accountNumber = builder.accountNumber;
		this.balance = builder.balance;
	}	
	
	
	public String getType() {
		return type;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public String getCustomerId() {
		return customerId;
	}
	
	public BigDecimal getBalance(){
		return balance.setScale(2);
	}


	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}


	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}	
	
}
