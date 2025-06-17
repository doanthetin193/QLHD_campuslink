package dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dao.ChiTietHoaDonDAO;
import model.ChiTietHoaDon;

import java.util.List;

@Repository
public class ChiTietHoaDonDAOImpl implements ChiTietHoaDonDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(List<ChiTietHoaDon> chiTietHoaDons) {
        String sql = "INSERT INTO CHITIETHOADON (MaHD, MaSP, SoLuong) VALUES (?, ?, ?)";
        for (ChiTietHoaDon chiTiet : chiTietHoaDons) {
            jdbcTemplate.update(sql, chiTiet.getMaHD(), chiTiet.getMaSP(), chiTiet.getSoLuong());
        }
    }

    @Override
    public void delete(int maHD, int maSP) {
        String sql = "DELETE FROM CHITIETHOADON WHERE MaHD = ? AND MaSP = ?";
        jdbcTemplate.update(sql, maHD, maSP);
    }

    @Override
    public int countByMaHD(int maHD) {
        String sql = "SELECT COUNT(*) FROM CHITIETHOADON WHERE MaHD = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, maHD);
    }
}