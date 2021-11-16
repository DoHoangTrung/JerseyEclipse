package Model;

import java.sql.Date;

public class SinhVien {
	private int id;
	private String ten;
	private String ngaySinh;
	private String lop;
	private float diem;

	public SinhVien() {
	}

	public SinhVien(String ten, String ngaySinh, String lop, float diem) {
		super();
		this.ten = ten;
		this.ngaySinh = ngaySinh;
		this.lop = lop;
		this.diem = diem;
	}

	public SinhVien(int id, String ten, String ngaySinh, String lop, float diem) {
		this.id = id;
		this.ten = ten;
		this.ngaySinh = ngaySinh;
		this.lop = lop;
		this.diem = diem;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getLop() {
		return lop;
	}

	public void setLop(String lop) {
		this.lop = lop;
	}

	public float getDiem() {
		return diem;
	}

	public void setDiem(float diem) {
		this.diem = diem;
	}

	@Override
	public String toString() {
		return "SinhVien [id=" + id + ", ten=" + ten + ", ngaySinh=" + ngaySinh + ", lop=" + lop + ", diem=" + diem
				+ "]";
	}
	
	
}
