package net.shakaihatsu.training.testing.impl;

import net.shakaihatsu.training.testing.impl.LuckyCharmCreatorImpl;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LuckyCharmCreatorImplTest {
	private LuckyCharmCreatorImpl testSubject;
	
	@Test
	public void shouldReturnLuckyCharmForNull() {
		// GIVEN
		Number luckyNumber = null;
		String expected = "*** null ***";
		
		// WHEN
		// THEN
		test(luckyNumber, expected);
	}
	
	@Test
	public void shouldReturnLuckyCharmFor6L() {
		// GIVEN
		Number luckyNumber = 6L;
		String expected = "*** 6 ***";
		
		// WHEN
		// THEN
		test(luckyNumber, expected);
	}
	
	@Test
	public void shouldReturnLuckyCharmFor145() {
		// GIVEN
		Number luckyNumber = 145;
		String expected = "*** 145 ***";
		
		// WHEN
		// THEN
		test(luckyNumber, expected);
	}
	
	@Test
	public void shouldReturnLuckyCharmForMinus109_37() {
		// GIVEN
		Number luckyNumber = -109.37;
		String expected = "*** -109.37 ***";
		
		// WHEN
		// THEN
		test(luckyNumber, expected);
	}

	private void test(Number luckyNumber, String expected) {
		// GIVEN
		
		// WHEN
		String actual = testSubject.createLuckyCharm(luckyNumber);
		
		// THEN
		Assert.assertEquals(expected, actual);
	}
	
	@Before
	public void setUp() {
		testSubject = new LuckyCharmCreatorImpl();
	}
	
	@After
	public void tearDown() {
		testSubject = null;
	}
}
