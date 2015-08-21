package net.shakaihatsu.training.persistence.domain.animal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({ @NamedQuery(name = Bat.FIND_ALL, query = "SELECT e FROM Bat e"), })
@DiscriminatorValue("BAT")
@Entity
public class Bat extends Mammal {
	public static final String FIND_ALL = "Bat.findAll";

	private Long flightSpeedInKmh;

	{
		setNumberOfLegs(2);
	}

	public Long getFlightSpeedInKmh() {
		return flightSpeedInKmh;
	}

	public void setFlightSpeedInKmh(Long flightSpeedInKmh) {
		this.flightSpeedInKmh = flightSpeedInKmh;
	}
}
