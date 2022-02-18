package nl.dirkkok.youtubeagebypass.resource;

import nl.dirkkok.youtubeagebypass.HttpClientDownloader;
import org.schabi.newpipe.extractor.NewPipe;
import org.schabi.newpipe.extractor.ServiceList;
import org.schabi.newpipe.extractor.exceptions.ExtractionException;
import org.schabi.newpipe.extractor.services.youtube.linkHandler.YoutubeStreamLinkHandlerFactory;
import org.schabi.newpipe.extractor.stream.StreamExtractor;
import org.schabi.newpipe.extractor.stream.VideoStream;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.net.URI;
import java.util.List;

@Path("/watch")
@Singleton
public class WatchResource {
	static {
		NewPipe.init(new HttpClientDownloader());
	}

	@GET
	public Response watch(@QueryParam("v") String id) throws ExtractionException, IOException {
		StreamExtractor extractor = ServiceList.YouTube.getStreamExtractor(YoutubeStreamLinkHandlerFactory.getInstance().fromId(id));
		extractor.fetchPage();
		List<VideoStream> streams = extractor.getVideoStreams();
		VideoStream stream = streams.stream().reduce((current, next) -> next.getWidth() > current.getWidth() ? next : current).get();
		return Response.seeOther(URI.create(stream.getUrl())).build();
	}
}
