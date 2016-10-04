package com.capgemini.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.capgemini.exception.BankingApplicationException;
import com.capgemini.model.Account;
import com.capgemini.model.Customer;
import com.capgemini.util.BankingUtils;

public class BankingRepositoryImpl implements BankingRepository {

	private static Map<String, String> customerAccount = new HashMap<String, String>();
	private static Map<String, String> accountCustomer = new HashMap<String, String>();
	private static Map<String, Customer> customerMap = new HashMap<String, Customer>();
	private static Map<String, Account> accountMap = new HashMap<String, Account>();

	@Override
	public Customer getCustomer(String customerId) {
		Customer customer = BankingRepositoryImpl.customerMap.get(customerId);
		if (null == customer) {
			throw new BankingApplicationException("Customer does not exist for the specified customer id");
		}
		return customer;
	}

	@Override
	public Account getAccount(String accountNumber) {
		Account account = BankingRepositoryImpl.accountMap.get(accountNumber);
		if (null == account) {
			throw new BankingApplicationException("Account does not exist for the specified account number");
		}
		return account;
	}

	@Override
	public String createAccount(Account account, Customer customer) {
		String accountNumber = BankingUtils.generateAccountNumber();
		if (null == customer.getCustomerId() || customer.getCustomerId().trim().isEmpty()) {
			throw new BankingApplicationException(
					"Customer ID not yet generated. Kindly create Customer using customer details first.");
		}
		BankingRepositoryImpl.accountCustomer.put(accountNumber, customer.getCustomerId());
		BankingRepositoryImpl.customerAccount.put(customer.getCustomerId(), accountNumber);
		BankingRepositoryImpl.accountMap.put(accountNumber, account);
		return accountNumber;
	}

	@Override
	public String createCustomer(Customer customer) {
		String customerId = BankingUtils.generateCustomerId();		
		customer.setCustomerId(customerId);
		BankingRepositoryImpl.customerMap.put(customerId, customer);		
		return customerId;
	}

	@Override
	public List<String> getCustomerIds() {
		List<String> customerIds = new ArrayList<String>();
		customerIds.addAll(BankingRepositoryImpl.customerAccount.keySet());
		return customerIds;
	}

	@Override
	public Customer getExistingCustomer(String customerId) {
		return customerMap.get(customerId);
	}

}
