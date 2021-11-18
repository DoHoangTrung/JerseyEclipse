package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.DimensionUIResource;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;

import org.glassfish.jersey.client.ClientConfig;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Model.SinhVien;

@WebServlet("/sv")
public class AddSvServlet extends HttpServlet {

	private String baseServiceUrl = "http://localhost:8080/JerseyWebservice/rest/sinhvien";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(baseServiceUrl);
		String jsonListSinhvien = target.request().accept(MediaType.APPLICATION_JSON).get(String.class);
		
		//convert json string to list sinhvien
		ObjectMapper mapper = new ObjectMapper();
		List<SinhVien> listSv = mapper.readValue(jsonListSinhvien, new TypeReference<List<SinhVien>>() {});
		
		//gui du lieu len jsp
		request.setAttribute("listSinhVien", listSv);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String tensv, ngay , lop ;
			float diem;
			tensv = request.getParameter("ten");
			ngay = request.getParameter("ngay");
			lop = request.getParameter("lop");
			diem = Float.parseFloat( request.getParameter("diem"));
			SinhVien sv = new SinhVien(tensv, ngay, lop, diem);
			
			//call post service 
			WebTarget target = getWebTarget();
			Response wsResponse = target.request().post(Entity.entity(sv, MediaType.APPLICATION_JSON),Response.class);
			
			doGet(request, response);
		}
		catch (Exception e) {
			doGet(request, response);
		}
	}
	
	private WebTarget getWebTarget() {
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(baseServiceUrl);
		return target;
	}
}
