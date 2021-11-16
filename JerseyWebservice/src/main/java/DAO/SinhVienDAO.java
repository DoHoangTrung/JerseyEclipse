package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.SinhVien;

public class SinhVienDAO {
	private static SinhVienDAO dao;
	private Connection conn = null;

	public static SinhVienDAO getDAO() {
		if (dao == null) {
			dao = new SinhVienDAO();
		}
		return dao;
	}

	public List<SinhVien> getList() throws ClassNotFoundException, SQLException {
		String query = "SELECT * FROM SinhVien";

		conn = getConnection();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);

		List<SinhVien> listSinhVien = new ArrayList();
		while (rs.next()) {
			SinhVien sv = ResultSetToSinhVien(rs);
			listSinhVien.add(sv);
		}

		st.close();
		conn.close();

		return listSinhVien;
	}

	public SinhVien get(int id) throws ClassNotFoundException, SQLException {
		SinhVien sinhVien = null;

		String query = "SELECT * FROM SinhVien where ID = ?";

		conn = getConnection();
		PreparedStatement pst = conn.prepareStatement(query);
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {
			sinhVien = ResultSetToSinhVien(rs);
		}

		pst.close();
		conn.close();
		return sinhVien;
	}

	public boolean add(SinhVien newSv) throws ClassNotFoundException, SQLException {
		String query = "INSERT INTO SinhVien(Name,Birthday,Class,AvgGrade) VALUES (?,?,?,?)";

		conn = getConnection();
		PreparedStatement pst = conn.prepareStatement(query);
		pst.setString(1, newSv.getTen());
		pst.setString(2, newSv.getNgaySinh());
		pst.setString(3, newSv.getLop());
		pst.setFloat(4, newSv.getDiem());
		int count = pst.executeUpdate();

		pst.close();
		conn.close();

		if (count > 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean update(int id, SinhVien sinhVien) throws ClassNotFoundException, SQLException {
		String query = "UPDATE SinhVien SET NAME = ?, Birthday = ?, Class = ?, AvgGrade =? WHERE ID =?";

		conn = getConnection();
		PreparedStatement pst = conn.prepareStatement(query);
		pst.setString(1, sinhVien.getTen());
		pst.setString(2, sinhVien.getNgaySinh());
		pst.setString(3, sinhVien.getLop());
		pst.setFloat(4, sinhVien.getDiem());
		pst.setInt(5, id);

		int count = pst.executeUpdate();

		pst.close();
		conn.close();

		if (count > 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean delete(int id) throws ClassNotFoundException, SQLException {
		String query = "DELETE SinhVien WHERE ID = ?";
		conn = getConnection();
		PreparedStatement pst = conn.prepareStatement(query);
		pst.setInt(1, id);
		int count = pst.executeUpdate();
		
		pst.close();
		conn.close();

		if (count > 0) {
			return true;
		} else {
			return false;
		}
	}

	private SinhVien ResultSetToSinhVien(ResultSet rs) throws SQLException {
		SinhVien sinhVien = null;
		if (rs != null) {
			int id = rs.getInt("ID");
			String ten = rs.getString("Name");
			String ngaySinh = rs.getString("Birthday");
			String lop = rs.getString("Class");
			float diem = rs.getFloat("AvgGrade");
			sinhVien = new SinhVien(id, ten, ngaySinh, lop, diem);
		}

		return sinhVien;
	}

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String connectionUrl = "jdbc:sqlserver://localhost:1433;" + "databaseName = sinhvien;user=sa;password=123456";
		Connection connection = DriverManager.getConnection(connectionUrl);
		return connection;
	}
}
