package client;

import javax.ws.rs.Path;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

public class ProductClient {
	private static String baseUri = "http://localhost:8080/CRUDwithJersey/rest/product";

	public static void main(String[] args) {
		
		System.out.println("Show all: ____________________");
		testList();
	}

	
	static void testList() {
		WebTarget target = getTarget();
		String response = target.request().accept(MediaType.APPLICATION_JSON).get(String.class);
		System.out.println(response);
	}

	static WebTarget getTarget() {
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		return client.target(baseUri);
	}

	static void testGet() {
		WebTarget target = getTarget();
		String productId = "1";
		Product product = target.path(productId).request().accept(MediaType.APPLICATION_JSON).get(Product.class);

		System.out.println(product.toString());
	}

	static void testAdd() {
		WebTarget target = getTarget();
		Product product = new Product("ipod", 200f);

		Response response = target.request().post(Entity.entity(product, MediaType.APPLICATION_JSON), Response.class);
		System.out.println(response);
	}

	static void testUpdate() {
		WebTarget target = getTarget();
		Product productUpdate = new Product(2, "111111111", 11111f);

		Response response = target.request().put(Entity.entity(productUpdate, MediaType.APPLICATION_JSON),
				Response.class);

		System.out.println(response);
	}

	static void testDelete() {
		WebTarget target = getTarget();
		String idDelete = "1";

		Response response = target.path(idDelete).request().delete(Response.class);
		System.out.println(response);
	}
}
