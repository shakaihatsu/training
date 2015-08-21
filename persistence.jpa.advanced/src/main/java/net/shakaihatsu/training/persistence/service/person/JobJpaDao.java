package net.shakaihatsu.training.persistence.service.person;

import javax.ejb.Stateless;
import javax.inject.Named;

import net.shakaihatsu.training.persistence.api.Dao;
import net.shakaihatsu.training.persistence.domain.person.Job;
import net.shakaihatsu.training.persistence.service.AbstractJpaDao;

@Named
@Stateless
public class JobJpaDao extends AbstractJpaDao<Job> implements Dao<Job> {

	@Override
	protected Class<Job> getEntityClass() {
		return Job.class;
	}

	@Override
	protected String getFindAllNamedQuery() {
		return null;
	}

}