package net.shakaihatsu.training.testing.ft;

import javax.inject.Inject;

import net.shakaihatsu.training.testing.domain.LuckyCharmData;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/spring/applicationContext-ft.xml")
public class LuckyCharmFT {
	@Inject
	protected RestTemplate restTemplate;

	@Test(expected = HttpClientErrorException.class)
	public void shouldThrowRuntimeExceptionWhenBaseIsNull() {
		// GIVEN
		Integer base = null;
		String expected = "null";

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

	private void test(Integer base, String expectedLuckyCharm) {
		// GIVEN
		LuckyCharmData expected = new LuckyCharmData();
		expected.setLuckyCharm(expectedLuckyCharm);

		// WHEN
		LuckyCharmData actual = restTemplate.getForObject(
				"http://localhost:8080/testing/rest/luckyCharm?base=" + base,
				LuckyCharmData.class);

		// THEN
		Assert.assertEquals(expected, actual);
	}
}
