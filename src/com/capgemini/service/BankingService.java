package com.capgemini.service;

import com.capgemini.model.Account;
import com.capgemini.model.Customer;

public interface BankingService {

	Customer getCustomer(String customerId);

	String createCustomer(Customer customer);

	String createAccount(Account account, Customer customer);
}
