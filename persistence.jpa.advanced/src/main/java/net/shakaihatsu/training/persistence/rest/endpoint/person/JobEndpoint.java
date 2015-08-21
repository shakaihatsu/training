package net.shakaihatsu.training.persistence.rest.endpoint.person;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import net.shakaihatsu.training.persistence.api.Dao;
import net.shakaihatsu.training.persistence.domain.person.Job;
import net.shakaihatsu.training.persistence.rest.endpoint.AbstractEntityEndpoint;

@Path("/job")
@RequestScoped
public class JobEndpoint extends AbstractEntityEndpoint<Job> {
	@Inject
	private Dao<Job> dao;

	@GET
	@Path("/save/{name}")
	@Produces("application/json")
	public Long save(@PathParam("name") String name) {
		Long id;
		
		Job job = new Job();
		job.setName(name);
		
		dao.save(job);
		
		id = job.getId();
		
		return id;
		
	}
	
	@Override
	protected Dao<Job> getDao() {
		return dao;
	}
}
