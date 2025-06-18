package model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class NhanVien {
	private int maNV;
	private String tenNV;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate ngaySinh;
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

	public LocalDate getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	
}
