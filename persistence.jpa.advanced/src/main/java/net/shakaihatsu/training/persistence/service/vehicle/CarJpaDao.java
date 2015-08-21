package net.shakaihatsu.training.persistence.service.vehicle;

import javax.ejb.Stateless;

import net.shakaihatsu.training.persistence.api.Dao;
import net.shakaihatsu.training.persistence.domain.vehicle.Car;
import net.shakaihatsu.training.persistence.service.AbstractJpaDao;

@Stateless
public class CarJpaDao extends AbstractJpaDao<Car> implements Dao<Car> {

	@Override
	protected Class<Car> getEntityClass() {
		return Car.class;
	}

	@Override
	protected String getFindAllNamedQuery() {
		return Car.FIND_ALL;
	}

}
