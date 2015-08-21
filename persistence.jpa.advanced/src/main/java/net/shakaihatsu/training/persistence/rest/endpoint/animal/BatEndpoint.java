package net.shakaihatsu.training.persistence.rest.endpoint.animal;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import net.shakaihatsu.training.persistence.api.Dao;
import net.shakaihatsu.training.persistence.domain.animal.Bat;

@Path("/bat")
@RequestScoped
public class BatEndpoint extends AbstractAnimalEndpoint<Bat> {
	@Inject
	private Dao<Bat> dao;

	@GET
	@Path("/save/{name}/{flightSpeedInKmh}")
	@Produces("application/json")
	public Long save(@PathParam("name") String name,
			@PathParam("flightSpeedInKmh") Long flightSpeedInKmh) {
		
		Long id;
		
		Bat animal = createNew();
		animal.setName(name);
		animal.setFlightSpeedInKmh(flightSpeedInKmh);

		getDao().save(animal);

		id = animal.getId();
		
		return id;
	}

	@GET
	@Path("/update/{id}/{name}/{flightSpeedInKmh}")
	@Produces("application/json")
	public boolean update(@PathParam("id") Long id,
			@PathParam("name") String name,
			@PathParam("flightSpeedInKmh") Long flightSpeedInKmh) {
		Bat animal = createNew();
		animal.setId(id);
		animal.setName(name);
		animal.setFlightSpeedInKmh(flightSpeedInKmh);

		getDao().update(animal);

		return true;
	}

	@Override
	protected Bat createNew() {
		return new Bat();
	}

	@Override
	protected Dao<Bat> getDao() {
		return dao;
	}

}
