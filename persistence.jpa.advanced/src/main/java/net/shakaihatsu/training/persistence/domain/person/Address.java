package net.shakaihatsu.training.persistence.domain.person;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlTransient;

import net.shakaihatsu.training.persistence.domain.common.PersistentEntity;

@Entity
public class Address extends PersistentEntity {
	private String country;
	private String city;
	private String street;
	private String houseNumber;
	@ManyToOne
	@JoinColumn(name = "owner_id")
	private Person owner;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	@XmlTransient
	public Person getOwner() {
		return owner;
	}

	public void setOwner(Person owner) {
		this.owner = owner;
	}

}
