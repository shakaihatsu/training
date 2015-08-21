package net.shakaihatsu.training.persistence.api;

import java.util.List;

public interface Dao<T> {
	public List<T> findAll();

	public T findById(Long id);

	public Long save(T person);

	public void update(T person);

	public void delete(Long id);
}
