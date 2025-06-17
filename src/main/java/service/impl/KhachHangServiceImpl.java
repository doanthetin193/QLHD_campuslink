package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.KhachHangDAO;
import model.KhachHang;
import service.KhachHangService;
@Service
public class KhachHangServiceImpl implements KhachHangService{
	@Autowired
	private KhachHangDAO khachHangDAO;

	@Override
	public List<KhachHang> getAll() {
		return khachHangDAO.getAll();
	}
}
