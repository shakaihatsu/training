package net.shakaihatsu.training.persistence.rest.endpoint.vehicle;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import net.shakaihatsu.training.persistence.domain.vehicle.Vehicle;
import net.shakaihatsu.training.persistence.rest.endpoint.AbstractEntityEndpoint;

public abstract class AbstractVehicleEndpoint<T extends Vehicle> extends
		AbstractEntityEndpoint<T> {
	protected abstract T createNew();

	@GET
	@Path("/save/{name}/{speedInKmh}")
	@Produces("application/json")
	public Long save(@PathParam("name") String name, Long speedInKmh) {
		Long id;
		
		T vehicle = createNew();
		vehicle.setName(name);
		vehicle.setSpeedInKmh(speedInKmh);

		getDao().save(vehicle);
		
		id = vehicle.getId();

		return id;
	}

	@GET
	@Path("/update/{id}/{name}")
	@Produces("application/json")
	public boolean update(@PathParam("id") Long id,
			@PathParam("name") String name, Long speedInKmh) {
		T vehicle = createNew();
		vehicle.setId(id);
		vehicle.setName(name);
		vehicle.setSpeedInKmh(speedInKmh);

		getDao().update(vehicle);

		return true;
	}
}
