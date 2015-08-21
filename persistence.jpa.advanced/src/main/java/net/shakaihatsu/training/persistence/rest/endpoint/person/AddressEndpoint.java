package net.shakaihatsu.training.persistence.rest.endpoint.person;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import net.shakaihatsu.training.persistence.api.Dao;
import net.shakaihatsu.training.persistence.domain.person.Address;
import net.shakaihatsu.training.persistence.rest.endpoint.AbstractEntityEndpoint;

@Path("/address")
@RequestScoped
public class AddressEndpoint extends AbstractEntityEndpoint<Address> {
	@Inject
	private Dao<Address> dao;

	@GET
	@Path("/save/{country}/{city}/{street}/{houseNumber}")
	@Produces("application/json")
	public Long save(@PathParam("country") String country, @PathParam("city") String city, @PathParam("street") String street, @PathParam("houseNumber") String houseNumber) {
		Long id;
		
		Address address = new Address();
		address.setCountry(country);
		address.setCity(city);
		address.setStreet(street);
		address.setHouseNumber(houseNumber);
		
		dao.save(address);
		
		id = address.getId();
		
		return id;
		
	}
	
	@Override
	protected Dao<Address> getDao() {
		return dao;
	}
}
