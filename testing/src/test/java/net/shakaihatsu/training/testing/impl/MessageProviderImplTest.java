package net.shakaihatsu.training.testing.impl;

import net.shakaihatsu.training.testing.impl.MessageProviderImpl;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MessageProviderImplTest {
	private MessageProviderImpl testSubject;
	
	@Test
	public void shouldReturnLuckyCharmMessageWhenLuckCharmIsNull() {
		// GIVEN
		String luckyCharm = "null";
		String expected = "Your lucky charm is:\nnull";
		
		// WHEN
		// THEN
		test(luckyCharm, expected);
	}
	
	@Test
	public void shouldReturnLuckyCharmMessageWhenLuckCharmIsEmptyString() {
		// GIVEN
		String luckyCharm = "";
		String expected = "Your lucky charm is:\n";
		
		// WHEN
		// THEN
		test(luckyCharm, expected);
	}
	
	@Test
	public void shouldReturnLuckyCharmMessageWhenLuckCharmIsRegularString() {
		// GIVEN
		String luckyCharm = "abrakadabra!";
		String expected = "Your lucky charm is:\nabrakadabra!";
		
		// WHEN
		// THEN
		test(luckyCharm, expected);
	}
	
	@Test
	public void shouldReturnLuckyCharmMessageWhenLuckCharmIsNumberAsString() {
		// GIVEN
		String luckyCharm = "17462";
		String expected = "Your lucky charm is:\n17462";
		
		// WHEN
		// THEN
		test(luckyCharm, expected);
	}

	private void test(String luckyCharm, String expected) {
		// GIVEN
		
		// WHEN
		String actual = testSubject.provideLuckyCharmMessage(luckyCharm);
		
		// THEN
		Assert.assertEquals(expected, actual);
	}
	
	@Before
	public void setUp() {
		testSubject = new MessageProviderImpl();
	}
	
	@After
	public void tearDown() {
		testSubject = null;
	}
}
