package net.shakaihatsu.training.persistence.rest.endpoint.person;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import net.shakaihatsu.training.persistence.api.Dao;
import net.shakaihatsu.training.persistence.domain.person.Credential;
import net.shakaihatsu.training.persistence.rest.endpoint.AbstractEntityEndpoint;

@Path("/credential")
@RequestScoped
public class CredentialEndpoint extends AbstractEntityEndpoint<Credential> {
	@Inject
	private Dao<Credential> dao;

	@GET
	@Path("/save/{personalId}")
	@Produces("application/json")
	public Long save(@PathParam("personalId") String personalId) {
		Long id;
		
		Credential credential = new Credential();
		credential.setPersonalId(personalId);
		
		dao.save(credential);
		
		id = credential.getId();
		
		return id;
		
	}
	
	@Override
	protected Dao<Credential> getDao() {
		return dao;
	}
}
