package net.shakaihatsu.training.persistence.rest.endpoint.animal;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import net.shakaihatsu.training.persistence.domain.animal.Animal;
import net.shakaihatsu.training.persistence.rest.endpoint.AbstractEntityEndpoint;

public abstract class AbstractAnimalEndpoint<T extends Animal> extends
		AbstractEntityEndpoint<T> {
	protected abstract T createNew();

	@GET
	@Path("/save/{name}")
	@Produces("application/json")
	public Long save(@PathParam("name") String name) {
		Long id;
		
		T animal = createNew();
		animal.setName(name);

		getDao().save(animal);

		id = animal.getId();
		
		return id;
	}

	@GET
	@Path("/update/{id}/{name}")
	@Produces("application/json")
	public boolean update(@PathParam("id") Long id,
			@PathParam("name") String name) {
		T animal = createNew();
		animal.setId(id);
		animal.setName(name);

		getDao().update(animal);

		return true;
	}
}
