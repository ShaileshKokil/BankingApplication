package com.capgemini.service;

import java.math.BigDecimal;

import com.capgemini.exception.BankingApplicationException;
import com.capgemini.model.Account;
import com.capgemini.repository.BankingRepository;

public class AccountServiceImpl implements AccountService {

	private BankingRepository bankingRepository;
	
	public AccountServiceImpl(BankingRepository bankingRepository) {
		this.bankingRepository = bankingRepository;
	}
	
	@Override
	public BigDecimal retrieveBalance(String accountNumber) {		
		Account account = getAccount(accountNumber);
		synchronized (account) {
			return account.getBalance();
		}
	}

	@Override
	public BigDecimal deposit(String accountNumber, BigDecimal amount) {
		Account account = getAccount(accountNumber);
		synchronized (account) {
			account.setBalance(account.getBalance().add(amount.setScale(2)));
			return account.getBalance();
		}
	}

	@Override
	public BigDecimal withdraw(String accountNumber, BigDecimal amount) {
		Account account = getAccount(accountNumber);
		synchronized (account) {
			BigDecimal balance = account.getBalance().setScale(2); 
			if(0 <= balance.subtract(amount).compareTo(new BigDecimal(0))){
				account.setBalance(account.getBalance().subtract(amount.setScale(2)));
				return account.getBalance();
			}else{
				throw new BankingApplicationException("Account withdraw failed as the amount to be withdrawn exceeds account balance.");
			}			
		}
	}

	@Override
	public boolean transfer(String fromAccountNumber, String toAccountNumber, BigDecimal amount) {
		Account fromAccount = getAccount(fromAccountNumber);
		Account toAccount = getAccount(toAccountNumber);
		if(null == fromAccount || null == toAccount){
			throw new BankingApplicationException("Please provide valid account numbers to initiate funds transfer.");
		}
		withdraw(fromAccountNumber, amount);
		deposit(toAccountNumber, amount);
		return true;
	}
	
	@Override
	public Account getAccount(String accountNumber) {		
		return this.bankingRepository.getAccount(accountNumber);		
	}
	
}
