package net.shakaihatsu.training.persistence.service.animal;

import javax.ejb.Stateless;

import net.shakaihatsu.training.persistence.api.Dao;
import net.shakaihatsu.training.persistence.domain.animal.Dog;
import net.shakaihatsu.training.persistence.service.AbstractJpaDao;

@Stateless
public class DogJpaDao extends AbstractJpaDao<Dog> implements Dao<Dog> {

	@Override
	protected Class<Dog> getEntityClass() {
		return Dog.class;
	}

	@Override
	protected String getFindAllNamedQuery() {
		return Dog.FIND_ALL;
	}

}
