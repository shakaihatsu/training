package net.shakaihatsu.training.persistence.service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.shakaihatsu.training.persistence.api.PersonDao;
import net.shakaihatsu.training.persistence.domain.Person;

@Stateless
public class PersonDaoJpaImpl implements PersonDao {
	private static final AtomicLong ID_SEQUENCE = new AtomicLong(1L);
	
	@PersistenceContext(unitName = "basic")
    private EntityManager entityManager;

	@Override
	public List<Person> findAllPersons() {
		List<Person> persons = entityManager.createNamedQuery(Person.FIND_ALL, Person.class).getResultList();
		
		return persons;
	}

	@Override
	public Person findPersonById(Long id) {
		Person person = entityManager.find(Person.class, id);
		
		return person;
	}

	@Override
	public void savePerson(Person person) {
		person.setId(ID_SEQUENCE.getAndIncrement());
		
		entityManager.persist(person);
	}

	@Override
	public void updatePerson(Person person) {
		entityManager.merge(person);
	}

	@Override
	public void deletePerson(Long id) {
		entityManager.remove(findPersonById(id));
	}
}
