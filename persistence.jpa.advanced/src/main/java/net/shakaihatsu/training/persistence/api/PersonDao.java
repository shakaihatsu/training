package net.shakaihatsu.training.persistence.api;

import java.util.List;

import net.shakaihatsu.training.persistence.domain.person.Person;

public interface PersonDao {
	public List<Person> findAllPersons();

	public Person findPersonById(Long id);

	public Long savePerson(Person person);

	public void updatePerson(Person person);

	public void updatePerson(Person person, List<Long> addressIds,
			List<Long> jobIds);

	public void deletePerson(Long id);
}
