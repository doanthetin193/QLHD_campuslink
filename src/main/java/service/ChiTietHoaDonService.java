package service;

import model.ChiTietHoaDon;
import java.util.List;

public interface ChiTietHoaDonService {
    void save(List<ChiTietHoaDon> chiTietHoaDons);
    void delete(int maHD, int maSP);
    int countByMaHD(int maHD);
}