package net.shakaihatsu.training.testing.it;

import javax.inject.Inject;

import net.shakaihatsu.training.testing.impl.DummyMessageProviderImpl;
import net.shakaihatsu.training.testing.util.Dummy;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/spring/applicationContext-it.xml")
public class DummyMessageProviderImplIT {
	@Inject @Dummy
	private DummyMessageProviderImpl testSubject;
	
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
}
