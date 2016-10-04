package com.capgemini.repository;

import java.util.List;

import com.capgemini.model.Account;
import com.capgemini.model.Customer;

public interface BankingRepository {
	
	Customer getCustomer(String customerId);

	Account getAccount(String accountNumber);	

	String createCustomer(Customer customer);

	String createAccount(Account account, Customer customer);

	List<String> getCustomerIds();

	Customer getExistingCustomer(String customerId);
}
