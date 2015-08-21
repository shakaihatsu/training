package net.shakaihatsu.training.testing.it;

import javax.inject.Inject;

import net.shakaihatsu.training.testing.service.LuckyCharmFacade;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/spring/applicationContext-it.xml")
public class LuckyCharmIT {
	@Inject
	private LuckyCharmFacade testSubject;
	
	@Test(expected = NullPointerException.class)
	public void shouldThrowRuntimeExceptionWhenBaseIsNull() {
		// GIVEN
		Integer base = null;
		String expected = "";
		
		// WHEN
		// THEN
		test(base, expected);
	}
	
	@Test
	public void shouldReturnLuckyCharmWhenBaseIs0() {
		// GIVEN
		Integer base = 0;
		String expected = "Your lucky charm is:\n*** 0 ***";
		
		// WHEN
		// THEN
		test(base, expected);
	}
	
	@Test
	public void shouldReturnLuckyCharmWhenBaseIs9() {
		// GIVEN
		Integer base = 9;
		String expected = "Your lucky charm is:\n*** 818181 ***";
		
		// WHEN
		// THEN
		test(base, expected);
	}

	private void test(Integer base, String expected) {
		// GIVEN
		
		// WHEN
		String actual = testSubject.getLuckCharm(base);
		
		// THEN
		Assert.assertEquals(expected, actual);
	}
}
