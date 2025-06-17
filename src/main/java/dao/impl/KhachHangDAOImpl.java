package dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dao.KhachHangDAO;
import model.KhachHang;
@Repository
public class KhachHangDAOImpl implements KhachHangDAO{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<KhachHang> getAll() {
		String sql = "SELECT * FROM KHACHHANG";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(KhachHang.class));
	}

}
