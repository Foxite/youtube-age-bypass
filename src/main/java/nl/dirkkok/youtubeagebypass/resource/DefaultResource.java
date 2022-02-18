package nl.dirkkok.youtubeagebypass.resource;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/")
@Singleton
public class DefaultResource {
	@GET
	public Response index() {
		return Response.seeOther(URI.create("https://github.com/Foxite/youtube-age-bypass")).build();
	}
}
