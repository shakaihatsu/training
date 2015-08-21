package net.shakaihatsu.training.persistence;

import java.util.Set;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.shakaihatsu.training.persistence.api.PersonDao;
import net.shakaihatsu.training.persistence.domain.person.Address;
import net.shakaihatsu.training.persistence.domain.person.Credential;
import net.shakaihatsu.training.persistence.domain.person.Job;
import net.shakaihatsu.training.persistence.domain.person.Person;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/spring/applicationContext-ft.xml")
@TransactionConfiguration
@Transactional
public class PersonRestFT extends AbstractTransactionalJUnit4SpringContextTests {
	@PersistenceContext
	private EntityManager entityManager;
	@Inject
	private PersonDao personDao;

	@Inject
	private RestTemplate restTemplate;

	@Before
	public void setUp() {
		Assert.assertNotNull(entityManager);
		Assert.assertNotNull(personDao);
		Assert.assertNotNull(restTemplate);
	}

	@Test
	public void testPersonRestServices() {
		// GIVEN

		// WHEN
		Long id1 = callRestSave("http://localhost:8080/persistence.jpa.advanced/rest/address/save/Hungary/Budapest/Molnar/20");
		Long id2 = callRestSave("http://localhost:8080/persistence.jpa.advanced/rest/address/save/Hungary/Budapest/Molnar/21");
		Long id3 = callRestSave("http://localhost:8080/persistence.jpa.advanced/rest/credential/save/111222");
		Long id4 = callRestSave("http://localhost:8080/persistence.jpa.advanced/rest/job/save/programmer");
		Long id5 = callRestSave("http://localhost:8080/persistence.jpa.advanced/rest/job/save/teacher");
		Long id6 = callRestSave("http://localhost:8080/persistence.jpa.advanced/rest/save/johnny/walker/"
				+ id3
				+ "?addressId="
				+ id1
				+ "&addressId="
				+ id2
				+ "&jobId="
				+ id4 + "&jobId=" + id5);
		Long id7 = callRestSave("http://localhost:8080/persistence.jpa.advanced/rest/address/save/Hungary/Budapest/Molnar/22");
		Long id8 = callRestSave("http://localhost:8080/persistence.jpa.advanced/rest/address/save/Hungary/Budapest/Molnar/23");
		Long id9 = callRestSave("http://localhost:8080/persistence.jpa.advanced/rest/job/save/taxidriver");
		callRestUpdate("http://localhost:8080/persistence.jpa.advanced/rest/update/"
				+ id6
				+ "/jane/dove/UK/Madrid/222?addressId="
				+ id7
				+ "&addressId=" + id8 + "&jobId=" + id9);

		// THEN
		Person person = personDao.findPersonById(6L);
		String firstName = person.getFirstName();
		String lastName = person.getLastName();

		Set<Address> addresses = person.getAddresses();

		Credential credential = person.getCredential();
		String personalId = credential.getPersonalId();

		Set<Job> jobs = person.getJobs();
		Job job = jobs.iterator().next();
		String jobName = job.getName();

		Assert.assertEquals("jane", firstName);
		Assert.assertEquals("dove", lastName);

		Assert.assertEquals(4, addresses.size());

		Assert.assertEquals("222", personalId);

		Assert.assertEquals(1, jobs.size());
		Assert.assertEquals("taxidriver", jobName);
	}

	public Long callRestSave(String url) {
		Long response = restTemplate.getForObject(url, Long.class);
		Assert.assertNotNull(response);

		return response;
	}

	public void callRestUpdate(String url) {
		Boolean response = restTemplate.getForObject(url, Boolean.class);
		Assert.assertEquals(true, response);
	}
}
