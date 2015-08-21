package net.shakaihatsu.training.persistence.domain.vehicle;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({ @NamedQuery(name = Train.FIND_ALL, query = "SELECT e FROM Train e"), })
@Entity
public class Train extends Vehicle {
	public static final String FIND_ALL = "Train.findAll";

	@Enumerated(EnumType.STRING)
	private EngineType engineType;

	public EngineType getEngineType() {
		return engineType;
	}

	public void setEngineType(EngineType engineType) {
		this.engineType = engineType;
	}

}
