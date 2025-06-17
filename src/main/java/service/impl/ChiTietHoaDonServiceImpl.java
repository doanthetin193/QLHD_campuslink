package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ChiTietHoaDonDAO;
import model.ChiTietHoaDon;
import service.ChiTietHoaDonService;

import java.util.List;

@Service
public class ChiTietHoaDonServiceImpl implements ChiTietHoaDonService {
    @Autowired
    private ChiTietHoaDonDAO chiTietHoaDonDAO;

    @Override
    public void save(List<ChiTietHoaDon> chiTietHoaDons) {
        chiTietHoaDonDAO.save(chiTietHoaDons);
    }

    @Override
    public void delete(int maHD, int maSP) {
        chiTietHoaDonDAO.delete(maHD, maSP);
    }

    @Override
    public int countByMaHD(int maHD) {
        return chiTietHoaDonDAO.countByMaHD(maHD);
    }
}