package net.shakaihatsu.training.persistence.rest.endpoint.vehicle;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import net.shakaihatsu.training.persistence.api.Dao;
import net.shakaihatsu.training.persistence.domain.vehicle.Car;

@Path("/car")
@RequestScoped
public class CarEndpoint extends AbstractVehicleEndpoint<Car> {
	@Inject
	private Dao<Car> dao;

	@GET
	@Path("/save/{name}/{speedInKmh}/{numberOfDoors}")
	@Produces("application/json")
	public Long save(@PathParam("name") String name,
			@PathParam("speedInKmh") Long speedInKmh,
			@PathParam("numberOfDoors") Long numberOfDoors) {
		
		Long id;
		
		Car car = createNew();
		car.setName(name);
		car.setSpeedInKmh(speedInKmh);
		car.setNumberOfDoors(numberOfDoors);

		getDao().save(car);
		
		id = car.getId();

		return id;
	}

	@GET
	@Path("/update/{id}/{name}/{speedInKmh}/{numberOfDoors}")
	@Produces("application/json")
	public boolean update(@PathParam("id") Long id,
			@PathParam("name") String name,
			@PathParam("speedInKmh") Long speedInKmh,
			@PathParam("numberOfDoors") Long numberOfDoors) {
		Car car = createNew();
		car.setId(id);
		car.setName(name);
		car.setSpeedInKmh(speedInKmh);
		car.setNumberOfDoors(numberOfDoors);

		getDao().update(car);

		return true;
	}

	@Override
	protected Car createNew() {
		return new Car();
	}

	@Override
	protected Dao<Car> getDao() {
		return dao;
	}

}
