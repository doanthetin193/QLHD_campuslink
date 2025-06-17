package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.HoaDonDAO;
import model.HoaDon;
import service.HoaDonService;

@Service
public class HoaDonServiceImpl implements HoaDonService {
    @Autowired
    private HoaDonDAO hoaDonDAO;

    @Override
    public int save(HoaDon hoaDon) {
        return hoaDonDAO.save(hoaDon);
    }

    @Override
    public void delete(int maHD) {
        hoaDonDAO.delete(maHD);
    }
}