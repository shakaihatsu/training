package net.shakaihatsu.training.testing.rest.endpoint;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import net.shakaihatsu.training.testing.domain.LuckyCharmData;
import net.shakaihatsu.training.testing.service.LuckyCharmFacade;

@Path("/luckyCharm")
@RequestScoped
public class LuckCharmEndpoint {
	@Inject
	private LuckyCharmFacade luckyCharmFacade;
	
	@GET
	@Path("/{base}")
	@Produces("application/json")
	public String getLuckCharmMessage(@PathParam("base") Integer base) {
		String luckyCharm = luckyCharmFacade.getLuckCharm(base);
				
		return luckyCharm;
		
	}
	
	@GET
	@Path("/")
	@Produces("application/json")
	public LuckyCharmData getLuckCharmData(@QueryParam("base") Integer base) {
		LuckyCharmData luckyCharmData = new LuckyCharmData();
		
		String luckyCharm = luckyCharmFacade.getLuckCharm(base);
		
		luckyCharmData.setLuckyCharm(luckyCharm);
		
		return luckyCharmData;
		
	}
}
