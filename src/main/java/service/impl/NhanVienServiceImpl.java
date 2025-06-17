package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.NhanVienDAO;
import model.NhanVien;
import service.NhanVienService;
@Service
public class NhanVienServiceImpl implements NhanVienService{
	@Autowired
	private NhanVienDAO nhanVienDAO;

	@Override
	public List<NhanVien> getAll() {
		return nhanVienDAO.getAll();
	}

}
