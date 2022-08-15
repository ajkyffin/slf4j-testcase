package com.example.testcase;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Stateless;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

@Path("/")
@Stateless
public class Slf4jTestcase {

	private final Logger logger = LoggerFactory.getLogger(Slf4jTestcase.class);
	private final Marker fatal = MarkerFactory.getMarker("FATAL");

	@PostConstruct
	private void init() {
		logger.info("*** Info message ***");
	}

	@GET
	@Path("debug")
	@Produces(MediaType.APPLICATION_JSON)
	public String getDebug() {
		logger.debug("*** Debug message ***");
		return "[\"Debug\"]";
	}

	@GET
	@Path("fatal")
	@Produces(MediaType.APPLICATION_JSON)
	public String getFatal() {
		logger.error(fatal, "*** Fatal message ***");
		return "[\"Fatal\"]";
	}
}
