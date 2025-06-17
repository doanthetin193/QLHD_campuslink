package service;

import java.util.List;

import model.SanPham;

public interface SanPhamService {
	List<SanPham> getAll();
	SanPham getById(int maSP);
	void update(int maSP, int soLuong);
}
