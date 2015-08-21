package net.shakaihatsu.training.persistence.rest.endpoint;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import net.shakaihatsu.training.persistence.api.PersonDao;
import net.shakaihatsu.training.persistence.domain.Person;

@Path("/")
@RequestScoped
public class Endpoint {
	@Inject
	private PersonDao personDao;

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
	@Path("/save/{firstName}/{lastName}")
	@Produces("application/json")
	public boolean savePerson(@PathParam("firstName") String firstName, @PathParam("lastName") String lastName) {
		Person person = new Person();
		person.setFirstName(firstName);
		person.setLastName(lastName);
		
		personDao.savePerson(person);
		
		return true;
	}

	@GET
	@Path("/update/{id}/{firstName}/{lastName}")
	@Produces("application/json")
	public boolean updatePerson(@PathParam("id") Long id, @PathParam("firstName") String firstName, @PathParam("lastName") String lastName) {
		Person person = new Person();
		person.setId(id);
		person.setFirstName(firstName);
		person.setLastName(lastName);
		
		personDao.updatePerson(person);
		
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
