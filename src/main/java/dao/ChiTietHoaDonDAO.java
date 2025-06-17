package dao;

import model.ChiTietHoaDon;
import java.util.List;

public interface ChiTietHoaDonDAO {
    void save(List<ChiTietHoaDon> chiTietHoaDons);
    void delete(int maHD, int maSP);
    int countByMaHD(int maHD);
}