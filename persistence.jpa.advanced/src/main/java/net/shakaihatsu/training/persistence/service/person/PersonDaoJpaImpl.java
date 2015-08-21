package net.shakaihatsu.training.persistence.service.person;

import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.shakaihatsu.training.persistence.api.Dao;
import net.shakaihatsu.training.persistence.api.PersonDao;
import net.shakaihatsu.training.persistence.domain.person.Address;
import net.shakaihatsu.training.persistence.domain.person.Credential;
import net.shakaihatsu.training.persistence.domain.person.Job;
import net.shakaihatsu.training.persistence.domain.person.Person;
import net.shakaihatsu.training.persistence.meta.POI;
import net.shakaihatsu.training.persistence.service.IdSequencer;

@Named
@Stateless
public class PersonDaoJpaImpl implements PersonDao {
	@PersistenceContext(unitName = "basic")
	private EntityManager entityManager;
	@Inject
	private Dao<Address> addressDao;
	@Inject
	private Dao<Credential> credentialDao;
	@Inject
	private Dao<Job> jobDao;

	@Override
	public List<Person> findAllPersons() {
		List<Person> persons = entityManager.createNamedQuery(Person.FIND_ALL,
				Person.class).getResultList();

		return persons;
	}

	@Override
	@POI("Need to load lazy relations!")
	public Person findPersonById(Long id) {
		Person person = entityManager.find(Person.class, id);
		person.getAddresses().size();

		return person;
	}

	@Override
	public Long savePerson(Person person) {
		Long id;
		
		person.setId(IdSequencer.ID_SEQUENCE.getAndIncrement());

		entityManager.persist(person);

		saveAddresses(person);
		saveCredential(person);
		
		id = person.getId();
		
		return id;
	}

	@Override
	public void updatePerson(Person person) {
		entityManager.merge(person);
	}

	@Override
	public void updatePerson(Person person, List<Long> addressIds,
			List<Long> jobIds) {

		Person persistentPerson = findPersonById(person.getId());
		
		clearDependencies(persistentPerson);
		
		persistentPerson.setFirstName(person.getFirstName());
		persistentPerson.setLastName(person.getLastName());
		persistentPerson.setAddresses(person.getAddresses());
		persistentPerson.setCredential(person.getCredential());
		
		saveAddresses(persistentPerson);
		saveCredential(persistentPerson);

		addAddresses(persistentPerson, addressIds);
		addJobs(persistentPerson, jobIds);
	}

	private void clearDependencies(Person person) {
		clearAddresses(person);
		clearCredential(person);
		clearJobs(person);
	}

	private void clearAddresses(Person person) {
		Set<Address> addresses = person.getAddresses();
		if (addresses != null) {
			for (Address address : addresses) {
				// address.setOwner(null);
				addressDao.delete(address.getId());
			}
		}
		person.getAddresses().clear();
	}

	private void clearCredential(Person person) {
		Credential credential = person.getCredential();
		if (credential != null) {
			credentialDao.delete(credential.getId());
		}
		person.setCredential(null);
	}

	private void clearJobs(Person person) {
		Set<Job> jobs = person.getJobs();
		if (jobs != null) {
			jobs.clear();
		}
	}

	private void addAddresses(Person person, List<Long> addressIds) {
		for (Long addressId : addressIds) {
			Address address = addressDao.findById(addressId);
			address.setOwner(person);
		}
	}

	private void addJobs(Person person, List<Long> jobIds) {
		for (Long jobId : jobIds) {
			Job job = jobDao.findById(jobId);
			person.getJobs().add(job);
		}
	}

	@Override
	public void deletePerson(Long id) {
		entityManager.remove(findPersonById(id));
	}

	private void saveAddresses(Person person) {
		Set<Address> addresses = person.getAddresses();
		for (Address address : addresses) {
			address.setOwner(person);

			if (address.getId() == null) {
				address.setId(IdSequencer.ID_SEQUENCE.getAndIncrement());

				entityManager.persist(address);
			} else {
				entityManager.merge(address);
			}
		}
	}

	private void saveCredential(Person person) {
		Credential credential = person.getCredential();
		credential.setOwner(person);

		if (credential.getId() == null) {
			credential.setId(IdSequencer.ID_SEQUENCE.getAndIncrement());
			entityManager.persist(credential);
		} else {
			entityManager.merge(credential);
		}
	}
}
