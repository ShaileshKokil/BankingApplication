package com.capgemini.service;

import java.math.BigDecimal;

import com.capgemini.model.Account;

public interface AccountService {
	BigDecimal retrieveBalance(String accountNumber);

	BigDecimal deposit(String accountNumber, BigDecimal amount);

	BigDecimal withdraw(String accountNumber, BigDecimal amount);

	boolean transfer(String fromAccountNumber, String toAccountNumber, BigDecimal amount);

	Account getAccount(String accountNumber);
}
