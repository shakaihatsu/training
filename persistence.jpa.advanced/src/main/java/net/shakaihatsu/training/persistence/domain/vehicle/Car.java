package net.shakaihatsu.training.persistence.domain.vehicle;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({ @NamedQuery(name = Car.FIND_ALL, query = "SELECT e FROM Car e"), })
@Entity
public class Car extends Vehicle {
	public static final String FIND_ALL = "Car.findAll";

	private Long numberOfDoors;

	public Long getNumberOfDoors() {
		return numberOfDoors;
	}

	public void setNumberOfDoors(Long numberOfDoors) {
		this.numberOfDoors = numberOfDoors;
	}
}
