package com.capgemini.util;

import org.junit.Assert;
import org.junit.Test;

public class ValidatorUtilsTest {

	@Test
	public void testIsValidNumber() {
		Assert.assertTrue(ValidatorUtils.isValidNumber(1, "9"));
		Assert.assertTrue(ValidatorUtils.isValidNumber(10, "1234567890"));
		Assert.assertFalse(ValidatorUtils.isValidNumber(10, "123456789"));
		Assert.assertFalse(ValidatorUtils.isValidNumber(10, "123456789A"));
		Assert.assertFalse(ValidatorUtils.isValidNumber(10, "123456789$"));
	}
}
