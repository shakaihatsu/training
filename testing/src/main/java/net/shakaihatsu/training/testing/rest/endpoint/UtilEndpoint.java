package net.shakaihatsu.training.testing.rest.endpoint;

import java.lang.reflect.Method;
import java.util.Properties;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/util")
@RequestScoped
public class UtilEndpoint {
	@POST
	@Path("/setCoverageDestinationFile")
	@Produces("application/json")
	public void setCoverageDestinationFile(@HeaderParam("pathToDestFile") String pathToDestFile) throws Exception {
		Properties props = System.getProperties();
		props.setProperty("jacoco-agent.destfile", pathToDestFile);
	}
	
	@GET
	@Path("/dumpCoverageData")
	@Produces("application/json")
	public void dumpCoverageData() throws Exception {
		Class rtClass = Thread.currentThread().getContextClassLoader()
				.loadClass("org.jacoco.agent.rt.RT");

		Object jacocoAgent = rtClass.getMethod("getAgent", null).invoke(null);

		Method dumpMethod = jacocoAgent.getClass().getMethod("dump",
				boolean.class);

		dumpMethod.invoke(jacocoAgent, false);
	}
}
