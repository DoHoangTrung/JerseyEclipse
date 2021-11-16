package webService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/bonjour")
public class HelloResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN) // content type of the response send to the client
	public String direBonjour() {
		return "bonjour tout le monde!";
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHTMLHello() {
		return "<html><h1>Bonjour, tout le monde!</h1></html>";
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Student sayJsonHello() {
		return new Student(1, "cavani", "Uruguay");
	}
}
