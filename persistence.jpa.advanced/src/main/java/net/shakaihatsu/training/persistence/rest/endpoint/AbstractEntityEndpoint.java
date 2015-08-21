package net.shakaihatsu.training.persistence.rest.endpoint;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import net.shakaihatsu.training.persistence.api.Dao;
import net.shakaihatsu.training.persistence.api.Identifiable;

public abstract class AbstractEntityEndpoint<T extends Identifiable> {
	protected abstract Dao<T> getDao();

	@GET
	@Path("/findAll")
	@Produces("application/json")
	public List<T> findAll() {
		List<T> entities = getDao().findAll();

		return entities;
	}

	@GET
	@Path("/find/{id}")
	@Produces("application/json")
	public T findById(@PathParam("id") Long id) {
		T entity = getDao().findById(id);

		return entity;
	}

	@GET
	@Path("/delete/{id}")
	@Produces("application/json")
	public boolean delete(@PathParam("id") Long id) {
		getDao().delete(id);

		return true;
	}
}
