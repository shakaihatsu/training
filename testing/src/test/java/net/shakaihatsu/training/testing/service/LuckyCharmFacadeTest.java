package net.shakaihatsu.training.testing.service;

import net.shakaihatsu.training.testing.api.LuckyCharmCreator;
import net.shakaihatsu.training.testing.api.LuckyNumberCalculator;
import net.shakaihatsu.training.testing.api.MessageProvider;
import net.shakaihatsu.training.testing.service.LuckyCharmFacade;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class LuckyCharmFacadeTest {
	private LuckyCharmFacade testSubject;
	
	@Mock
	private LuckyNumberCalculator luckyNumberCalculator;
	@Mock
	private LuckyCharmCreator luckyCharmCreator;
	@Mock
	private MessageProvider messageProvider;
	
	@Test
	public void shouldCallServices() {
		// GIVEN
		Integer base = 13;
		String expected = "hocuspocus";
		
		// WHEN
		// THEN
		test(base, expected);
	}

	private void test(Integer base, String expected) {
		// GIVEN
		Double luckyNumber = 65.4;
		String luckyCharm = "blablabla";
		
		Mockito.when(luckyNumberCalculator.calculateLuckyNumber(base)).thenReturn(luckyNumber);
		Mockito.when(luckyCharmCreator.createLuckyCharm(luckyNumber)).thenReturn(luckyCharm);
		Mockito.when(messageProvider.provideLuckyCharmMessage(luckyCharm)).thenReturn(expected);
		
		// WHEN
		String actual = testSubject.getLuckCharm(base);
		
		// THEN
		Assert.assertEquals(expected, actual);
	}

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		
		testSubject = new LuckyCharmFacade();
		
		setTestSubjectProperties();
	}

	@After
	public void tearDown() {
		testSubject = null;
	}
	
	private void setTestSubjectProperties() {
		testSubject.setLuckyNumberCalculator(luckyNumberCalculator);
		testSubject.setLuckyCharmCreator(luckyCharmCreator);
		testSubject.setMessageProvider(messageProvider);
	}
}
