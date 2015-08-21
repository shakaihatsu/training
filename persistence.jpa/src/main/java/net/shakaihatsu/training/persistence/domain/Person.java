package net.shakaihatsu.training.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({
	@NamedQuery(name = Person.FIND_ALL, query = "SELECT p FROM Person p"),
})
@Entity
public class Person {
	public static final String FIND_ALL = "Person.findAll";
	
	@Id
	private Long id;
	private String firstName;
	private String lastName;

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
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

}
