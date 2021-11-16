package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

@WebServlet("/deleteSv")
public class DeleteSvServlet extends HttpServlet {
	
	private String baseServiceUrl = "http://localhost:8080/JerseyWebservice/rest/sinhvien";
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(baseServiceUrl);
		
		
		String id = request.getParameter("id");
		Response wsResponse = target.path(id).request().delete();
		
		response.sendRedirect(request.getContextPath() + "/sv");
	}
}
