package model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class KhachHang {
	private int maKH;
	private String tenKH;
	private String soDienThoai;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ngaySinh;
	private String diaChi;
	
	public KhachHang() {}

	public int getMaKH() {
		return maKH;
	}

	public void setMaKH(int maKH) {
		this.maKH = maKH;
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	
}
