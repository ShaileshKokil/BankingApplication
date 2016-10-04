package com.capgemini.main;

import java.math.BigDecimal;

import com.capgemini.model.Account;
import com.capgemini.model.Customer;
import com.capgemini.repository.BankingRepositoryImpl;
import com.capgemini.service.AccountService;
import com.capgemini.service.AccountServiceImpl;
import com.capgemini.service.BankingService;
import com.capgemini.service.BankingServiceImpl;

public class BankingApplication {

	public static void main(String[] args) {
		BankingService bankingService = new BankingServiceImpl();
		
		String customerId = bankingService.createCustomer(new Customer.CustomerBuilder("Asif", "Pathan").build());			
		String accountNumber = bankingService.createAccount(new Account.AccountBuilder("Saving", customerId).build(), bankingService.getCustomer(customerId));
		
		System.out.println(accountNumber);
		
		String secondCustomerId = bankingService.createCustomer(new Customer.CustomerBuilder("Richie", "Rich").build());
		String secondAccountNumber = bankingService.createAccount(new Account.AccountBuilder("Saving", secondCustomerId).build(), bankingService.getCustomer(secondCustomerId));
		
		System.out.println(secondAccountNumber);
		
		AccountService accountService = new AccountServiceImpl(new BankingRepositoryImpl());
		
		System.out.println(accountService.getAccount(accountNumber).getBalance());
		
		accountService.deposit(accountNumber, new BigDecimal("100000000000"));
		
		System.out.println(accountService.getAccount(accountNumber).getBalance());
		
		accountService.withdraw(accountNumber, new BigDecimal("1000"));
		
		System.out.println(accountService.getAccount(accountNumber).getBalance());
		
		accountService.deposit(secondAccountNumber, new BigDecimal("9999"));
		
		System.out.println(accountService.getAccount(secondAccountNumber).getBalance());
		
		accountService.transfer(secondAccountNumber, accountNumber, new BigDecimal("999"));
		
		System.out.println(accountService.getAccount(accountNumber).getBalance());
		
		System.out.println(accountService.getAccount(secondAccountNumber).getBalance());
	}

}
