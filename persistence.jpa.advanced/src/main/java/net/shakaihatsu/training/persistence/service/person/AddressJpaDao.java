package net.shakaihatsu.training.persistence.service.person;

import javax.ejb.Stateless;
import javax.inject.Named;

import net.shakaihatsu.training.persistence.api.Dao;
import net.shakaihatsu.training.persistence.domain.person.Address;
import net.shakaihatsu.training.persistence.service.AbstractJpaDao;

@Named
@Stateless
public class AddressJpaDao extends AbstractJpaDao<Address> implements Dao<Address> {

	@Override
	protected Class<Address> getEntityClass() {
		return Address.class;
	}

	@Override
	protected String getFindAllNamedQuery() {
		return null;
	}

}