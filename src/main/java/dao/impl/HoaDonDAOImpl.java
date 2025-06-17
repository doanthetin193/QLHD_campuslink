package dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dao.HoaDonDAO;
import model.HoaDon;

@Repository
public class HoaDonDAOImpl implements HoaDonDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(HoaDon hoaDon) {
        String sql = "INSERT INTO HOADON(MaNV, MaKH, NgayThanhToan, PhuongThucThanhToan) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, hoaDon.getMaNV(), hoaDon.getMaKH(), 
                           hoaDon.getNgayThanhToan(), 
                           hoaDon.getPhuongThucThanhToan());
        return jdbcTemplate.queryForObject("SELECT MAX(MaHD) FROM HOADON", Integer.class);
    }

    @Override
    public void delete(int maHD) {
        String sql = "DELETE FROM HOADON WHERE MaHD = ?";
        jdbcTemplate.update(sql, maHD);
    }
}