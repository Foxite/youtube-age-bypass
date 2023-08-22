/*
package nl.dirkkok.youtubeagebypass;

import nl.dirkkok.youtubeagebypass.resource.WatchResource;
import org.junit.jupiter.api.Test;
import org.schabi.newpipe.extractor.exceptions.ExtractionException;
import org.springframework.boot.test.context.SpringBootTest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import java.io.IOException;
import java.net.URI;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class YoutubeAgeBypassApplicationTests {
	@Test
	public void simpleSingle() throws ExtractionException, IOException {
		String id = "Z9XfDhaRkPg";

		Client client = ClientBuilder.newClient();
		Response response = new WatchResource().watch(id);
		assertEquals(303, response.getStatus());
		URI redirectTarget = ((URI) response.getHeaders().getFirst("location"));

		WebTarget webTarget = client.target(redirectTarget);
		Response youtubeResponse = webTarget.request().head();
		assertEquals(200, youtubeResponse.getStatus());
		String contentLength = ((String) youtubeResponse.getHeaders().getFirst("content-length"));
		assertEquals("214977895", contentLength);
	}
}
*/