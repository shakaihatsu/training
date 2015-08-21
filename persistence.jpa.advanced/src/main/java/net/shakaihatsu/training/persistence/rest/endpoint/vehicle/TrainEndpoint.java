package net.shakaihatsu.training.persistence.rest.endpoint.vehicle;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import net.shakaihatsu.training.persistence.api.Dao;
import net.shakaihatsu.training.persistence.domain.vehicle.EngineType;
import net.shakaihatsu.training.persistence.domain.vehicle.Train;

@Path("/train")
@RequestScoped
public class TrainEndpoint extends AbstractVehicleEndpoint<Train> {
	@Inject
	private Dao<Train> dao;

	@GET
	@Path("/save/{name}/{speedInKmh}/{engineType}")
	@Produces("application/json")
	public Long save(@PathParam("name") String name,
			@PathParam("speedInKmh") Long speedInKmh,
			@PathParam("engineType") EngineType engineType) {
		
		Long id;
		
		Train train = createNew();
		train.setName(name);
		train.setSpeedInKmh(speedInKmh);
		train.setEngineType(engineType);

		getDao().save(train);
		
		id = train.getId();

		return id;
	}

	@GET
	@Path("/update/{id}/{name}/{speedInKmh}/{engineType}")
	@Produces("application/json")
	public boolean update(@PathParam("id") Long id,
			@PathParam("name") String name,
			@PathParam("speedInKmh") Long speedInKmh,
			@PathParam("engineType") EngineType engineType) {
		Train train = createNew();
		train.setId(id);
		train.setName(name);
		train.setSpeedInKmh(speedInKmh);
		train.setEngineType(engineType);

		getDao().update(train);

		return true;
	}

	@Override
	protected Train createNew() {
		return new Train();
	}

	@Override
	protected Dao<Train> getDao() {
		return dao;
	}

}
