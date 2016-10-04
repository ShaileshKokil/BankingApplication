package com.capgemini.service;

import java.math.BigDecimal;

import org.junit.Test;
import org.mockito.Mockito;

import com.capgemini.model.Account;
import com.capgemini.repository.BankingRepository;

public class AccountServiceTest {

	@Test
	public void testRetrieveBalance(){
		Account account = new Account.AccountBuilder("Saving", "000001").setAccountNumber("0000000001").build();
		account.setBalance(new BigDecimal("10000"));
		BankingRepository bankingRepository = Mockito.mock(BankingRepository.class);		
		Mockito.when(bankingRepository.getAccount("0000000001")).thenReturn(account);
		Assert.
		
	}
}
