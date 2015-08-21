package net.shakaihatsu.training.persistence.service.vehicle;

import javax.ejb.Stateless;

import net.shakaihatsu.training.persistence.api.Dao;
import net.shakaihatsu.training.persistence.domain.vehicle.Train;
import net.shakaihatsu.training.persistence.service.AbstractJpaDao;

@Stateless
public class TrainJpaDao extends AbstractJpaDao<Train> implements Dao<Train> {

	@Override
	protected Class<Train> getEntityClass() {
		return Train.class;
	}

	@Override
	protected String getFindAllNamedQuery() {
		return Train.FIND_ALL;
	}

}
