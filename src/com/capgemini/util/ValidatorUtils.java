package com.capgemini.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorUtils {
	private ValidatorUtils() {
	}

	public static boolean isValidNumber(long numberOfDigits, String number) {		
		Pattern p = Pattern.compile("[0-9]{"+ numberOfDigits +"}");
		Matcher m = p.matcher(number);
		return m.matches();
	}
}
