<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm Hóa Đơn</title>
    <style>
        .error { color: red; }
        .form-group { margin-bottom: 15px; }
        label { display: inline-block; width: 150px; }
        .required::after { content: "*"; color: red; }
    </style>
</head>
<body>
    <h2>Thêm Hóa Đơn</h2>
    <c:if test="${not empty error}">
        <p class="error">${error}</p>
    </c:if>
    <c:if test="${param.success}">
        <p style="color: green;">Thêm hóa đơn thành công!</p>
    </c:if>

    <form action="${pageContext.request.contextPath}/hoa-don/add" method="post">
        <div class="form-group">
            <label for="maNV" class="required">Nhân viên:</label>
            <select name="maNV" id="maNV" required>
                <option value="">-- Chọn nhân viên --</option>
                <c:forEach var="nv" items="${nhanViens}">
                    <option value="${nv.maNV}" <c:if test="${hoaDon.maNV == nv.maNV}">selected</c:if>>${nv.tenNV}</option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <label for="maKH" class="required">Khách hàng:</label>
            <select name="maKH" id="maKH" required>
                <option value="">-- Chọn khách hàng --</option>
                <c:forEach var="kh" items="${khachHangs}">
                    <option value="${kh.maKH}" <c:if test="${hoaDon.maKH == kh.maKH}">selected</c:if>>${kh.tenKH}</option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <label for="ngayThanhToan">Ngày thanh toán:</label>
            <input type="date" name="ngayThanhToan" id="ngayThanhToan" value="${hoaDon.ngayThanhToan}" readonly>
        </div>

        <div class="form-group">
            <label for="phuongThucThanhToan" class="required">Phương thức thanh toán:</label>
            <select name="phuongThucThanhToan" id="phuongThucThanhToan" required>
                <option value="">-- Chọn phương thức --</option>
                <option value="Tien mat" <c:if test="${hoaDon.phuongThucThanhToan == 'Tien mat'}">selected</c:if>>Tiền mặt</option>
                <option value="Chuyen khoan" <c:if test="${hoaDon.phuongThucThanhToan == 'Chuyen khoan'}">selected</c:if>>Chuyển khoản</option>
                <option value="QR Code" <c:if test="${hoaDon.phuongThucThanhToan == 'QR Code'}">selected</c:if>>QR Code</option>
            </select>
        </div>

        <c:if test="${showSanPhamFields}">
            <div class="form-group">
                <label for="maSP" class="required">Sản phẩm:</label>
                <select name="maSP" id="maSP" required>
                    <option value="">-- Chọn sản phẩm --</option>
                    <c:forEach var="sp" items="${sanPhams}">
                        <option value="${sp.maSP}" <c:if test="${param.maSP == sp.maSP}">selected</c:if>>${sp.tenSP}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="soLuong" class="required">Số lượng:</label>
                <input type="number" name="soLuong" id="soLuong" min="1" value="${param.soLuong}" required>
            </div>
        </c:if>

        <div class="form-group">
            <button type="submit" name="addSanPham" value="true">Thêm sản phẩm</button>
            <button type="submit">Lưu hóa đơn</button>
        </div>
    </form>
</body>
</html>