package Model;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

public class test {
	private static String baseUrl = "http://localhost:8080/JerseyWebservice/rest/sinhvien";

	public static void main(String[] args) {
		testPost();

	}

	private static WebTarget getWebTarget() {
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(baseUrl);
		return target;
	}
	
	public static void testListAll() {
		WebTarget target = getWebTarget();
		String response = target.request().accept(MediaType.APPLICATION_JSON).get(String.class);
		System.out.println(response);
	}
	
	public static void testGet() {
		WebTarget target = getWebTarget();
		String id = "1";
		SinhVien sv = target.path(id).request().accept(MediaType.APPLICATION_JSON).get(SinhVien.class);
		System.out.println(sv);
	}
	
	public static void testPost() {
		WebTarget target = getWebTarget();
		//ngay sinh: 10 ki tu, neu truyen 11 ki tu: loi truncate
		SinhVien sv = new SinhVien("henry", "01/01/2011", "CNDL", 1.5f);
		Response response = target.request().post(Entity.entity(sv, MediaType.APPLICATION_JSON),Response.class);
		System.out.println(response);
	}
	
	public static void testPut() {
		WebTarget target = getWebTarget();
		int id = 31;
		SinhVien sv = new SinhVien("____________", "____", "__________", 0);
		Response response = target.path(String.valueOf(id)).request().put(Entity.entity(sv, MediaType.APPLICATION_JSON),Response.class);
		System.out.println(response);
	}
	
	public static void testDelete() {
		WebTarget target = getWebTarget();
		int id = 8;
		Response response = target.path(String.valueOf(id)).request().delete();
		System.out.println(response);
	}
}
