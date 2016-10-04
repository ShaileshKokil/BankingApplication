package com.capgemini.model;

public class Customer {
	private String firstName;
	private String lastName;
	
	private String customerId;
	private String accountNumber;
	private boolean employed;
	private boolean married;

	public static class CustomerBuilder{
		private String firstName;
		private String lastName;
		
		private String customerId;
		private String accountNumber;
		private boolean employed;
		private boolean married;
		
		public CustomerBuilder(String firstName, String lastName){
			if(null == firstName || firstName.trim().isEmpty() || null == lastName || lastName.trim().isEmpty()){
				throw new IllegalArgumentException("First name and last name cannot be null or empty");
			}
			this.firstName = firstName;
			this.lastName = lastName;
		}
		
		public CustomerBuilder(Customer customer){
			this.firstName = customer.firstName;
			this.lastName = customer.lastName;
			this.accountNumber = customer.accountNumber;
			this.customerId = customer.customerId;
			this.employed = customer.employed;
			this.married = customer.married;			
		}
		
		public CustomerBuilder setCustomerId(String customerId){
			this.customerId = customerId;
			return this;
		}
		
		public CustomerBuilder setAccountNumber(String accountNumber){
			this.accountNumber = accountNumber;
			return this;
		}
		
		public CustomerBuilder setEmployed(boolean employed){
			this.employed = employed;
			return this;
		}
		
		public CustomerBuilder setMarried(boolean married){
			this.married = married;
			return this;
		}
		
		public Customer build(){
			return new Customer(this);
		}
	}
	
	private Customer(CustomerBuilder builder){
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.accountNumber = builder.accountNumber;
		this.customerId = builder.customerId;
		this.employed = builder.employed;
		this.married = builder.married;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	} 
	
	public String getCustomerId() {
		return customerId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public boolean isEmployed() {
		return employed;
	}

	public boolean isMarried() {
		return married;
	}	
	
}
