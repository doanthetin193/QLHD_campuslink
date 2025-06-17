package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.SanPhamDAO;
import model.SanPham;
import service.SanPhamService;
@Service
public class SanPhamServiceImpl implements SanPhamService{

	@Autowired
	private SanPhamDAO sanPhamDAO;
	
	@Override
	public List<SanPham> getAll() {
		return sanPhamDAO.getAll();
	}

	@Override
	public SanPham getById(int maSP) {
		return sanPhamDAO.getById(maSP);
	}

	@Override
	public void update(int maSP, int soLuong) {
		sanPhamDAO.update(maSP, soLuong);
	}

}
