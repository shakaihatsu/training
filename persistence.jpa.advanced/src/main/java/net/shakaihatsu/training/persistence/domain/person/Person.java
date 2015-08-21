package net.shakaihatsu.training.persistence.domain.person;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

import net.shakaihatsu.training.persistence.domain.common.PersistentEntity;
import net.shakaihatsu.training.persistence.meta.POI;

@XmlRootElement
@POI("Need to load lazy relations, hence the FETCH joins. Need DISTINCT, otherwise, same Person is retrieved multiple times!")
@NamedQueries({ @NamedQuery(name = Person.FIND_ALL, query = "SELECT DISTINCT p FROM Person p LEFT JOIN FETCH p.addresses LEFT JOIN FETCH p.credential LEFT JOIN FETCH p.jobs"), })
@Entity
public class Person extends PersistentEntity {
	public static final String FIND_ALL = "Person.findAll";

	private String firstName;
	private String lastName;
	@OneToMany(mappedBy = "owner")
	private Set<Address> addresses;
	@OneToOne(mappedBy = "owner")
	private Credential credential;
	@ManyToMany
	@JoinTable(name = "j_person_job", joinColumns = { @JoinColumn(name = "person_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "job_id", referencedColumnName = "id") })
	private Set<Job> jobs;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	public Credential getCredential() {
		return credential;
	}

	public void setCredential(Credential credential) {
		this.credential = credential;
	}
	
	public Set<Job> getJobs() {
		return jobs;
	}

	public void setJobs(Set<Job> jobs) {
		this.jobs = jobs;
	}
}
