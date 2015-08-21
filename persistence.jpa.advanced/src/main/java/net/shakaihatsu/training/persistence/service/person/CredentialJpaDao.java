package net.shakaihatsu.training.persistence.service.person;

import javax.ejb.Stateless;
import javax.inject.Named;

import net.shakaihatsu.training.persistence.api.Dao;
import net.shakaihatsu.training.persistence.domain.person.Credential;
import net.shakaihatsu.training.persistence.service.AbstractJpaDao;

@Named
@Stateless
public class CredentialJpaDao extends AbstractJpaDao<Credential> implements Dao<Credential> {

	@Override
	protected Class<Credential> getEntityClass() {
		return Credential.class;
	}

	@Override
	protected String getFindAllNamedQuery() {
		return null;
	}

}