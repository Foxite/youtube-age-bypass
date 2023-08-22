package nl.dirkkok.youtubeagebypass;

import org.schabi.newpipe.extractor.NewPipe;
import org.schabi.newpipe.extractor.ServiceList;
import org.schabi.newpipe.extractor.exceptions.ExtractionException;
import org.schabi.newpipe.extractor.services.youtube.linkHandler.YoutubeStreamLinkHandlerFactory;
import org.schabi.newpipe.extractor.stream.StreamExtractor;
import org.schabi.newpipe.extractor.stream.VideoStream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.List;

@RestController
public class Controller {
	static {
		NewPipe.init(new HttpClientDownloader());
	}

	@GetMapping("/")
	public RedirectView index() {
		return new RedirectView("https://github.com/Foxite/youtube-age-bypass");
	}

	@GetMapping("/watch")
	public RedirectView watch(@RequestParam("v") String id) throws ExtractionException, IOException {
		StreamExtractor extractor = ServiceList.YouTube.getStreamExtractor(YoutubeStreamLinkHandlerFactory.getInstance().fromId(id));
		extractor.fetchPage();
		List<VideoStream> streams = extractor.getVideoStreams();
		VideoStream stream = streams.stream().reduce((current, next) -> next.getWidth() > current.getWidth() ? next : current).get();
		return new RedirectView(stream.getUrl());
	}
}
