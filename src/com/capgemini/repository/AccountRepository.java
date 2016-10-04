package com.capgemini.repository;

import java.math.BigDecimal;

public interface AccountRepository {
	BigDecimal retrieveBalance(long accountNumber);

	BigDecimal deposit(long accountNumber, BigDecimal amount);

	BigDecimal withdraw(long accountNumber, BigDecimal amount);

	BigDecimal transfer(long fromAccountNumber, long toAccountNumber, BigDecimal amount);
}
