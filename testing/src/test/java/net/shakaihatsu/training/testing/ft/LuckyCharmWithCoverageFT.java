package net.shakaihatsu.training.testing.ft;

import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/spring/applicationContext-ft.xml")
public class LuckyCharmWithCoverageFT extends LuckyCharmFT {
	// @Before
	public void setCoverageDestinationFile() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("pathToDestFile", "C:/dev/workspaces/training/testing/target/jacoco-it.exec");

		HttpEntity<Object> request = new HttpEntity<>(null, headers);
		
		restTemplate.postForObject("http://localhost:8080/testing/rest/util/setCoverageDestinationFile", request, Boolean.class);	
	}
	
	@After
	public void dumpCoverageData() {
		restTemplate.getForObject("http://localhost:8080/testing/rest/util/dumpCoverageData", Boolean.class);
	} 
}
