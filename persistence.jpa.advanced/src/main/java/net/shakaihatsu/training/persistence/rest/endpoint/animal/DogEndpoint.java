package net.shakaihatsu.training.persistence.rest.endpoint.animal;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Path;

import net.shakaihatsu.training.persistence.api.Dao;
import net.shakaihatsu.training.persistence.domain.animal.Dog;

@Path("/dog")
@RequestScoped
public class DogEndpoint extends AbstractAnimalEndpoint<Dog> {
	@Inject
	private Dao<Dog> dao;

	@Override
	protected Dog createNew() {
		return new Dog();
	}

	@Override
	protected Dao<Dog> getDao() {
		return dao;
	}

}
