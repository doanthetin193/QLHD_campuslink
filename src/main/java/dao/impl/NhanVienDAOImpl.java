package dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dao.NhanVienDAO;
import model.NhanVien;
@Repository
public class NhanVienDAOImpl implements NhanVienDAO{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<NhanVien> getAll() {
		String sql = "SELECT * FROM NHANVIEN";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(NhanVien.class));
	}

}
