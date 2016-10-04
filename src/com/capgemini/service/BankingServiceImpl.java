package com.capgemini.service;

import com.capgemini.model.Account;
import com.capgemini.model.Customer;
import com.capgemini.repository.BankingRepository;
import com.capgemini.repository.BankingRepositoryImpl;

public class BankingServiceImpl implements BankingService {

	@Override
	public Customer getCustomer(String customerId) {
		BankingRepository bankingRepository = new BankingRepositoryImpl();
		return bankingRepository.getCustomer(customerId);
	}	

	@Override
	public String createAccount(Account account, Customer customer) {
		BankingRepository bankingRepository = new BankingRepositoryImpl();
		return bankingRepository.createAccount(account, customer);
	}

	@Override
	public String createCustomer(Customer customer) {
		BankingRepository bankingRepository = new BankingRepositoryImpl();
		return bankingRepository.createCustomer(customer);
	}

}
