package WebService;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import DAO.SinhVienDAO;
import Model.SinhVien;

@Path("/sinhvien")
public class SinhVienResource {
	private SinhVienDAO dao = SinhVienDAO.getDAO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<SinhVien> getList() throws ClassNotFoundException, SQLException {
		List<SinhVien> listSinhVien = dao.getList();
		return listSinhVien;
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public SinhVien get(@PathParam("id") int id) throws ClassNotFoundException, SQLException {
		SinhVien sv = dao.get(id);
		return sv;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addSinhVien(SinhVien newSv) throws ClassNotFoundException, SQLException {
		boolean isSuccessful = dao.add(newSv);
		if (isSuccessful) {
			return Response.ok("successed").build();
		} else {
			return Response.status(404).entity("insert failed").build();
		}
	}
	
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateSinhVien(@PathParam("id") int id, SinhVien sinhVien) throws Exception, SQLException {
		boolean isSuccessful =dao.update(id, sinhVien);
		if(isSuccessful) {
			return Response.ok("successed").build();
		}else {
			return Response.status(Response.Status.NOT_FOUND).entity("update failed").build();
		}
	}
	
	@DELETE
	@Path("{id}")
	public Response deleteSinhVien(@PathParam("id") int id) throws ClassNotFoundException, SQLException {
		boolean isSuccessful = dao.delete(id);
		if(isSuccessful) {
			return Response.ok("successed").build();
		}else {
			return Response.status(Response.Status.NOT_FOUND).entity("delete failed").build();
		}
	}
}
