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
}