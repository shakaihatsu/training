package net.shakaihatsu.training.persistence.service.animal;

import javax.ejb.Stateless;

import net.shakaihatsu.training.persistence.api.Dao;
import net.shakaihatsu.training.persistence.domain.animal.Bat;
import net.shakaihatsu.training.persistence.service.AbstractJpaDao;

@Stateless
public class BatJpaDao extends AbstractJpaDao<Bat> implements Dao<Bat> {

	@Override
	protected Class<Bat> getEntityClass() {
		return Bat.class;
	}

	@Override
	protected String getFindAllNamedQuery() {
		return Bat.FIND_ALL;
	}

}
