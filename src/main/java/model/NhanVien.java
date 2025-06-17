package model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class NhanVien {
	private int maNV;
	private String tenNV;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ngaySinh;
	private String diaChi;
	
	public NhanVien() {}

	public int getMaNV() {
		return maNV;
	}

	public void setMaNV(int maNV) {
		this.maNV = maNV;
	}

	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
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
