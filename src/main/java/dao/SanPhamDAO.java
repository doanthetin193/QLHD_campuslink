package dao;

import java.util.List;

import model.SanPham;

public interface SanPhamDAO {
	List<SanPham> getAll();
	SanPham getById(int maSP);
	void update(int maSP, int soLuong);
}
