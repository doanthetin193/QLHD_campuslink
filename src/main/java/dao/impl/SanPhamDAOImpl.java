package dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dao.SanPhamDAO;
import model.SanPham;
@Repository
public class SanPhamDAOImpl implements SanPhamDAO{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<SanPham> getAll() {
		String sql = "SELECT * FROM SANPHAM";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(SanPham.class));
	}

	@Override
	public SanPham getById(int maSP) {
		String sql = "SELECT * FROM SANPHAM WHERE MaSP = ?";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(SanPham.class),maSP);
	}

	@Override
	public void update(int maSP, int soLuong) {
		String sql = "UPDATE SANPHAM SET SoLuong = ? WHERE MaSP = ?	";
		jdbcTemplate.update(sql,soLuong,maSP);
	}

}
