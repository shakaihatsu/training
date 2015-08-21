package net.shakaihatsu.training.persistence.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.shakaihatsu.training.persistence.api.Dao;
import net.shakaihatsu.training.persistence.api.Identifiable;

public abstract class AbstractJpaDao<T extends Identifiable> implements Dao<T> {
	@PersistenceContext(unitName = "basic")
	private EntityManager entityManager;

	protected abstract Class<T> getEntityClass();

	protected abstract String getFindAllNamedQuery();

	@Override
	public List<T> findAll() {
		List<T> entities;
		
		String findAllNamedQuery = getFindAllNamedQuery();
		
		if (findAllNamedQuery != null) {
			entities = entityManager.createNamedQuery(findAllNamedQuery, getEntityClass()).getResultList();
		} else {
			entities = entityManager.createQuery("SELECT e FROM " + getEntityClass().getSimpleName() + " e", getEntityClass()).getResultList();
		}

		return entities;
	}

	@Override
	public T findById(Long id) {
		T entity = entityManager.find(getEntityClass(), id);

		return entity;
	}

	@Override
	public Long save(T entity) {
		Long id;
		
		entity.setId(IdSequencer.ID_SEQUENCE.getAndIncrement());

		entityManager.persist(entity);
		
		id = entity.getId();
		
		return id;
	}

	@Override
	public void update(T entity) {
		entityManager.merge(entity);
	}

	@Override
	public void delete(Long id) {
		entityManager.remove(findById(id));
	}
}
