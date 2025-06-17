package service;

import model.HoaDon;

public interface HoaDonService {
    int save(HoaDon hoaDon);
    void delete(int maHD);
}