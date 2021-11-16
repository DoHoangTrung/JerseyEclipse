package test;

import java.sql.SQLException;
import java.util.List;

import DAO.SinhVienDAO;
import Model.SinhVien;

public class test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		SinhVienDAO dao = SinhVienDAO.getDAO();
		
		SinhVien sv = new SinhVien("22222222222","222","22222",22f);
		boolean check = dao.delete(13);
		System.out.println(check);
	}

}
