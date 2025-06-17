package dao;

import model.HoaDon;

public interface HoaDonDAO {
    int save(HoaDon hoaDon);
    void delete(int maHD);
}