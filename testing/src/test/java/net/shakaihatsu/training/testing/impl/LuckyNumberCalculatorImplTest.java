package net.shakaihatsu.training.testing.impl;

import net.shakaihatsu.training.testing.impl.LuckyNumberCalculatorImpl;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LuckyNumberCalculatorImplTest {
	private LuckyNumberCalculatorImpl testSubject;
	
	@Test(expected = NullPointerException.class)
	public void shouldThrowRuntimeExceptionWhenBaseIsNull() {
		// GIVEN
		Integer base = null;
		Number expected = 0;
		
		// WHEN
		// THEN
		test(base, expected);
	}
	
	@Test
	public void shouldReturn0WhenBaseIs0() {
		// GIVEN
		Integer base = 0;
		Number expected = 0;
		
		// WHEN
		// THEN
		test(base, expected);
	}
	
	@Test
	public void shouldReturn2272725WhenBaseIs15() {
		// GIVEN
		Integer base = 15;
		Number expected = 2272725;
		
		// WHEN
		// THEN
		test(base, expected);
	}
	
	@Test
	public void shouldReturn2272725WhenBaseIsMinus15() {
		// GIVEN
		Integer base = -15;
		Number expected = 2272725;
		
		// WHEN
		// THEN
		test(base, expected);
	}

	private void test(Integer base, Number expected) {
		// GIVEN
		
		// WHEN
		Number actual = testSubject.calculateLuckyNumber(base);
		
		// THEN
		Assert.assertEquals(expected, actual);
	}
	
	@Before
	public void setUp() {
		testSubject = new LuckyNumberCalculatorImpl();
	}
	
	@After
	public void tearDown() {
		testSubject = null;
	}
}
