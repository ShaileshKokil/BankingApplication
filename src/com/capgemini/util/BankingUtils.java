package com.capgemini.util;

import org.apache.commons.lang3.StringUtils;

public class BankingUtils {

	private static Long accountNumber = 0L;
	private static Long customerId = 0L;
	
	private BankingUtils(){
		
	}	
	
	public static String generateCustomerId(){
		customerId = BankingUtils.customerId + 1L;
		return StringUtils.leftPad(String.valueOf(customerId), 6, "0");
	}
	
	public static String generateAccountNumber(){		
		accountNumber = BankingUtils.accountNumber + 1L;
		return StringUtils.leftPad(String.valueOf(accountNumber), 10, "0");
	}
}
