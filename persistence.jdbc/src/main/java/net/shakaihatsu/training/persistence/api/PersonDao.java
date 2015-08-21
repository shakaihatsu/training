package net.shakaihatsu.training.persistence.api;

import java.util.List;

import net.shakaihatsu.training.persistence.domain.Person;

public interface PersonDao {
	public List<Person> findAllPersons();
	
	public Person findPersonById(Long id);
	
	public void savePerson(Person person);
	
	public void updatePerson(Person person);
	
	public void deletePerson(Long id);
}
