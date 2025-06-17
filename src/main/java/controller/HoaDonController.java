package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.ChiTietHoaDon;
import model.HoaDon;
import model.SanPham;
import service.ChiTietHoaDonService;
import service.HoaDonService;
import service.KhachHangService;
import service.NhanVienService;
import service.SanPhamService;

@Controller
@RequestMapping("/hoa-don")
public class HoaDonController {

    @Autowired
    private HoaDonService hoaDonService;

    @Autowired
    private ChiTietHoaDonService chiTietHoaDonService;

    @Autowired
    private NhanVienService nhanVienService;

    @Autowired
    private KhachHangService khachHangService;

    @Autowired
    private SanPhamService sanPhamService;

//    @GetMapping("/add")
//    public String showAddForm(Model model) {
//        HoaDon hoaDon = new HoaDon();
//        hoaDon.setNgayThanhToan(LocalDate.now());
//        model.addAttribute("hoaDon", hoaDon);
//        model.addAttribute("nhanViens", nhanVienService.getAll());
//        model.addAttribute("khachHangs", khachHangService.getAll());
//        model.addAttribute("sanPhams", sanPhamService.getAll());
//        model.addAttribute("showSanPhamFields", false);
//        return "add-hoa-don";
//    }
//
//    @PostMapping("/add")
//    public String addHoaDon(@ModelAttribute("hoaDon") HoaDon hoaDon,
//                            @RequestParam(value = "maSP", required = false) Integer maSP,
//                            @RequestParam(value = "soLuong", required = false) Integer soLuong,
//                            @RequestParam(value = "addSanPham", required = false) String addSanPham,
//                            Model model) {
//    	if (hoaDon.getMaNV() == 0 || hoaDon.getMaKH() == 0 || 
//    		    hoaDon.getNgayThanhToan() == null ||
//    		    hoaDon.getPhuongThucThanhToan() == null || hoaDon.getPhuongThucThanhToan().trim().isEmpty()) {
//            model.addAttribute("error", "Vui lòng điền đầy đủ các trường bắt buộc.");
//            model.addAttribute("nhanViens", nhanVienService.getAll());
//            model.addAttribute("khachHangs", khachHangService.getAll());
//            model.addAttribute("sanPhams", sanPhamService.getAll());
//            model.addAttribute("showSanPhamFields", addSanPham != null);
//            return "add-hoa-don";
//        }
//
//        if (addSanPham != null) {
//            model.addAttribute("nhanViens", nhanVienService.getAll());
//            model.addAttribute("khachHangs", khachHangService.getAll());
//            model.addAttribute("sanPhams", sanPhamService.getAll());
//            model.addAttribute("showSanPhamFields", true);
//            return "add-hoa-don";
//        }
//
//        if (maSP == null || soLuong == null || soLuong <= 0) {
//            model.addAttribute("error", "Vui lòng thêm ít nhất một sản phẩm.");
//            model.addAttribute("nhanViens", nhanVienService.getAll());
//            model.addAttribute("khachHangs", khachHangService.getAll());
//            model.addAttribute("sanPhams", sanPhamService.getAll());
//            model.addAttribute("showSanPhamFields", true);
//            return "add-hoa-don";
//        }
//
//        SanPham sp = sanPhamService.getById(maSP);
//        if (sp == null || sp.getSoLuong() < soLuong) {
//            model.addAttribute("error", sp == null ? "Sản phẩm không tồn tại!" : "Số lượng không đủ! Tồn kho: " + sp.getSoLuong());
//            model.addAttribute("nhanViens", nhanVienService.getAll());
//            model.addAttribute("khachHangs", khachHangService.getAll());
//            model.addAttribute("sanPhams", sanPhamService.getAll());
//            model.addAttribute("showSanPhamFields", true);
//            return "add-hoa-don";
//        }
//
//        try {
//            int maHD = hoaDonService.save(hoaDon);
//            if (maHD == 0) {
//                model.addAttribute("error", "Lỗi khi lưu hóa đơn.");
//                model.addAttribute("nhanViens", nhanVienService.getAll());
//                model.addAttribute("khachHangs", khachHangService.getAll());
//                model.addAttribute("sanPhams", sanPhamService.getAll());
//                model.addAttribute("showSanPhamFields", true);
//                return "add-hoa-don";
//            }
//
//            List<ChiTietHoaDon> chiTietHoaDons = new ArrayList<>();
//            ChiTietHoaDon chiTiet = new ChiTietHoaDon();
//            chiTiet.setMaHD(maHD);
//            chiTiet.setMaSP(maSP);
//            chiTiet.setSoLuong(soLuong);
//            chiTietHoaDons.add(chiTiet);
//            chiTietHoaDonService.save(chiTietHoaDons);
//
//            sanPhamService.update(maSP, sp.getSoLuong() - soLuong);
//
//            return "redirect:/hoa-don/add?success=true";
//        } catch (Exception e) {
//            model.addAttribute("error", "Lỗi: " + e.getMessage());
//            model.addAttribute("nhanViens", nhanVienService.getAll());
//            model.addAttribute("khachHangs", khachHangService.getAll());
//            model.addAttribute("sanPhams", sanPhamService.getAll());
//            model.addAttribute("showSanPhamFields", true);
//            return "add-hoa-don";
//        }
//    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        HoaDon hoaDon = new HoaDon();
        hoaDon.setNgayThanhToan(LocalDate.now());
        addCommonAttributes(model, hoaDon, false);
        return "add-hoa-don";
    }

    @PostMapping("/add")
    public String addHoaDon(@ModelAttribute("hoaDon") HoaDon hoaDon,
                            @RequestParam(value = "maSP", required = false) Integer maSP,
                            @RequestParam(value = "soLuong", required = false) Integer soLuong,
                            @RequestParam(value = "addSanPham", required = false) String addSanPham,
                            Model model) {
        
        // Xử lý nút "Thêm sản phẩm"
        if (addSanPham != null) {
            addCommonAttributes(model, hoaDon, true);
            return "add-hoa-don";
        }

        // Validation
        String error = validateHoaDon(hoaDon, maSP, soLuong);
        if (error != null) {
            addCommonAttributes(model, hoaDon, true);
            model.addAttribute("error", error);
            return "add-hoa-don";
        }

        // Kiểm tra sản phẩm
        SanPham sp = sanPhamService.getById(maSP);
        if (sp == null || sp.getSoLuong() < soLuong) {
            addCommonAttributes(model, hoaDon, true);
            model.addAttribute("error", sp == null ? "Sản phẩm không tồn tại!" : "Số lượng không đủ! Tồn kho: " + sp.getSoLuong());
            return "add-hoa-don";
        }

        // Lưu hóa đơn
        try {
            int maHD = hoaDonService.save(hoaDon);
            if (maHD == 0) {
                addCommonAttributes(model, hoaDon, true);
                model.addAttribute("error", "Lỗi khi lưu hóa đơn.");
                return "add-hoa-don";
            }

            // Lưu chi tiết hóa đơn
            saveChiTietHoaDon(maHD, maSP, soLuong);
            
            // Cập nhật số lượng sản phẩm
            sanPhamService.update(maSP, sp.getSoLuong() - soLuong);

            return "redirect:/hoa-don/add?success=true";
        } catch (Exception e) {
            addCommonAttributes(model, hoaDon, true);
            model.addAttribute("error", "Lỗi: " + e.getMessage());
            return "add-hoa-don";
        }
    }

    // Helper methods
    private void addCommonAttributes(Model model, HoaDon hoaDon, boolean showSanPhamFields) {
        model.addAttribute("hoaDon", hoaDon);
        model.addAttribute("nhanViens", nhanVienService.getAll());
        model.addAttribute("khachHangs", khachHangService.getAll());
        model.addAttribute("sanPhams", sanPhamService.getAll());
        model.addAttribute("showSanPhamFields", showSanPhamFields);
    }

    private String validateHoaDon(HoaDon hoaDon, Integer maSP, Integer soLuong) {
        if (hoaDon.getMaNV() == 0 || hoaDon.getMaKH() == 0 || 
            hoaDon.getNgayThanhToan() == null ||
            hoaDon.getPhuongThucThanhToan() == null || hoaDon.getPhuongThucThanhToan().trim().isEmpty()) {
            return "Vui lòng điền đầy đủ các trường bắt buộc.";
        }
        
        if (maSP == null || soLuong == null || soLuong <= 0) {
            return "Vui lòng thêm ít nhất một sản phẩm.";
        }
        
        return null;
    }

    private void saveChiTietHoaDon(int maHD, int maSP, int soLuong) {
        List<ChiTietHoaDon> chiTietHoaDons = new ArrayList<>();
        ChiTietHoaDon chiTiet = new ChiTietHoaDon();
        chiTiet.setMaHD(maHD);
        chiTiet.setMaSP(maSP);
        chiTiet.setSoLuong(soLuong);
        chiTietHoaDons.add(chiTiet);
        chiTietHoaDonService.save(chiTietHoaDons);
    }
}