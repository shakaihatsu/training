package net.shakaihatsu.training.persistence.rest.endpoint.person;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import net.shakaihatsu.training.persistence.api.Dao;
import net.shakaihatsu.training.persistence.api.PersonDao;
import net.shakaihatsu.training.persistence.domain.person.Address;
import net.shakaihatsu.training.persistence.domain.person.Credential;
import net.shakaihatsu.training.persistence.domain.person.Job;
import net.shakaihatsu.training.persistence.domain.person.Person;

@Path("/")
@RequestScoped
public class Endpoint {
	@Inject
	private PersonDao personDao;
	@Inject
	private Dao<Address> addressDao;
	@Inject
	private Dao<Credential> credentialDao;
	@Inject
	private Dao<Job> jobDao;

	@GET
	@Path("/findAll")
	@Produces("application/json")
	public List<Person> findAllPersons() {
		List<Person> persons = personDao.findAllPersons();

		return persons;
	}

	@GET
	@Path("/find/{id}")
	@Produces("application/json")
	public Person findPersonById(@PathParam("id") Long id) {
		Person person = personDao.findPersonById(id);

		return person;
	}

	@GET
	@Path("/save/{firstName}/{lastName}/{country1}/{city2}/{personalId}")
	@Produces("application/json")
	public Long savePerson(@PathParam("firstName") String firstName,
			@PathParam("lastName") String lastName,
			@PathParam("country1") String country1,
			@PathParam("city2") String city2,
			@PathParam("personalId") String personalId,
			@QueryParam("jobId") List<Long> jobIds) {
		
		Long id;
		
		Address address1 = new Address();
		address1.setCountry(country1);

		Address address2 = new Address();
		address2.setCity(city2);

		Credential credential = new Credential();
		credential.setPersonalId(personalId);

		Set<Address> addresses = new HashSet<>();
		addresses.add(address1);
		addresses.add(address2);

		Set<Job> jobs = new HashSet<>();
		for (Long jobId : jobIds) {
			Job job = jobDao.findById(jobId);
			jobs.add(job);
		}
		
		Person person = new Person();
		person.setFirstName(firstName);
		person.setLastName(lastName);
		person.setAddresses(addresses);
		person.setCredential(credential);
		person.setJobs(jobs);

		personDao.savePerson(person);

		id = person.getId();
		
		return id;
	}
	
	@GET
	@Path("/save/{firstName}/{lastName}/{credentialId}")
	@Produces("application/json")
	public Long savePerson(@PathParam("firstName") String firstName,
			@PathParam("lastName") String lastName,
			@PathParam("credentialId") Long credentialId,
			@QueryParam("addressId") List<Long> addressIds,
			@QueryParam("jobId") List<Long> jobIds) {

		Long id;
		
		Set<Address> addresses = new HashSet<>();
		for (Long addressId : addressIds) {
			Address address = addressDao.findById(addressId);
			addresses.add(address);
		}
		
		Credential credential = credentialDao.findById(credentialId);
		
		Set<Job> jobs = new HashSet<>();
		for (Long jobId : jobIds) {
			Job job = jobDao.findById(jobId);
			jobs.add(job);
		}
		
		Person person = new Person();
		person.setFirstName(firstName);
		person.setLastName(lastName);
		person.setAddresses(addresses);
		person.setCredential(credential);
		person.setJobs(jobs);

		personDao.savePerson(person);

		id = person.getId();
		
		return id;
	}

	@GET
	@Path("/update/{id}/{firstName}/{lastName}/{country1}/{city2}/{personalId}")
	@Produces("application/json")
	public boolean updatePerson(@PathParam("id") Long id,
			@PathParam("firstName") String firstName,
			@PathParam("lastName") String lastName,
			@PathParam("country1") String country1,
			@PathParam("city2") String city2,
			@PathParam("personalId") String personalId,
			@QueryParam("addressId") List<Long> addressIds,
			@QueryParam("jobId") List<Long> jobIds) {
		
		Address address1 = new Address();
		address1.setCountry(country1);

		Address address2 = new Address();
		address2.setCity(city2);

		Credential credential = new Credential();
		credential.setPersonalId(personalId);

		Set<Address> addresses = new HashSet<>();
		addresses.add(address1);
		addresses.add(address2);

		Set<Job> jobs = new HashSet<>();
		for (Long jobId : jobIds) {
			Job job = jobDao.findById(jobId);
			jobs.add(job);
		}
		
		Person person = new Person();
		person.setId(id);
		person.setFirstName(firstName);
		person.setLastName(lastName);
		person.setAddresses(addresses);
		person.setCredential(credential);
		person.setJobs(jobs);

		personDao.updatePerson(person, addressIds, jobIds);

		return true;
	}

	@GET
	@Path("/delete/{id}")
	@Produces("application/json")
	public boolean deletePerson(@PathParam("id") Long id) {
		personDao.deletePerson(id);

		return true;
	}
}
