<%-- 
    Document   : gdThanhToan
    Created on : Nov 18, 2024, 3:19:35 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Home</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">  
    </head>
    <body>
        <nav class="navbar navbar-expand-lg bg-body-tertiary">
            <div class="container-fluid" style="padding: 1em 5em;">
                <c:if test="${empty xacThuc}">
                    <a class="navbar-brand" href="#">CineMan</a> 
                </c:if>
                <c:if test="${not empty xacThuc}">
                    <div class="userInfo" style="display: flex; gap: 1em; align-items: center; justify-content: center;">
                        <img 
                          src="https://th.bing.com/th/id/OIP.7jJOJPxA60fS57Etfp5RqQAAAA?rs=1&pid=ImgDetMain" 
                          alt="" style="width: 2em; border-radius: 1em;"
                        >
                        <c:if test="${not empty nhanVienBanHang}">
                            <p style="margin: auto;">${nhanVienBanHang.getTen()}</p>
                        </c:if>
                        
                    </div>
                </c:if>

                <div class="collapse navbar-collapse" id="navbarSupportedContent" style="justify-content: flex-end;">
                    <ul class="nav justify-content-end">
                        <c:if test="${empty xacThuc}">
                            <li class="nav-item">
                                <a class="nav-link" href="xlDangKi474">Đăng kí</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="xlDangNhap474">Đăng nhập</a>
                            </li>
                        </c:if>
                        <c:if test="${not empty nhanVienBanHang}">
                            <li class="nav-item">
                                <a class="nav-link" href="xlChonVe474">Bán vé tại quầy</a>
                            </li>
                        </c:if>
                        <c:if test="${not empty xacThuc}">
                            <li class="nav-item">
                                <a class="nav-link" href="xlDangXuat474">Đăng xuất</a>
                            </li>
                        </c:if>
                    </ul>
                </div>
            </div>
        </nav>
        
        <c:if test="${empty thanhToan}">
            <div class="section invoice" style="width: 50em; height: 87vh; display: flex; flex-direction: column; align-items: center; justify-content: center; margin: auto;">
            <h1 class="invoice-title">Hóa đơn thanh toán</h1>
            <hr>
            <table class="table ticket-details" style="width: 100%; border-collapse: collapse; text-align: center; vertical-align: middle;">
                <thead>
                    <tr>
                        <th scope="col">STT</th>
                        <th scope="col">Tên phim</th>
                        <th scope="col">Giờ chiếu</th>
                        <th scope="col">Phòng chiếu</th>
                        <th scope="col">Số ghế</th>
                        <th scope="col">Giá</th>
                    </tr>
                </thead>
              <tbody>
                    <c:if test="${not empty dsVe}">
                        <c:forEach var="ve" items="${dsVe}" varStatus="status" >
                            <tr>
                              <th scope="row">${status.index + 1}</th>
                              <td>${ve.lichChieu.phim.ten}</td>
                              <td>
                                  <fmt:formatDate value="${ve.lichChieu.batDau}" pattern="HH:mm" /> - 
                                  <fmt:formatDate value="${ve.lichChieu.ketThuc}" pattern="HH:mm" /> 
                                  <fmt:formatDate value="${ve.lichChieu.batDau}" pattern="dd/MM/yyyy"/>
                              </td>
                              <td>${ve.lichChieu.phong.ten}</td>
                              <td>${ve.ghe.ten}</td>
                              <td>${ve.gia} VND</td>
                          </tr>
                        </c:forEach>
                    </c:if>
                    <tr>
                        <th scope="row" colspan="5" style="text-align: right; font-weight: normal;">Tổng giá vé</th>
                        <td>${tongGiaVe} VND</td>
                    </tr>
                    <tr>
                        <th scope="row" colspan="5" style="text-align: right; font-weight: normal;">Chiết khấu</th>
                        <td>${chietKhau} VND</td>
                    </tr> 
                    <tr>
                        <th scope="row" colspan="5" style="text-align: right;">Thành tiền</th>
                        <td><strong>${thanhTien} VND</strong></td>
                    </tr>
                </tbody>
            </table>
        </c:if>
        
        <c:if test="${not empty thanhToan}">
            <div class="section invoice" style="width: 50em; height: 87vh; display: flex; flex-direction: column; align-items: center; justify-content: center; margin: auto;">
            <h1 class="invoice-title">Hóa đơn thanh toán</h1>
            <hr>
            <table class="table ticket-details"  style="width: 100%; border-collapse: collapse; text-align: center; vertical-align: middle;">
                <thead>
                    <tr>
                        <th scope="col">STT</th>
                        <th scope="col">Tên phim</th>
                        <th scope="col">Giờ chiếu</th>
                        <th scope="col">Phòng chiếu</th>
                        <th scope="col">Số ghế</th>
                        <th scope="col">Giá</th>
                    </tr>
                </thead>
              <tbody>
                    <c:if test="${not empty hoaDonBan}">
                        <c:forEach var="ve" items="${hoaDonBan.dsVe}" varStatus="status" >
                            <tr>
                              <th scope="row">${status.index + 1}</th>
                              <td>${ve.lichChieu.phim.ten}</td>
                              <td>
                                  <fmt:formatDate value="${ve.lichChieu.batDau}" pattern="HH:mm" /> - 
                                  <fmt:formatDate value="${ve.lichChieu.ketThuc}" pattern="HH:mm" /> 
                                  <fmt:formatDate value="${ve.lichChieu.batDau}" pattern="dd/MM/yyyy"/>
                              </td>
                              <td>${ve.lichChieu.phong.ten}</td>
                              <td>${ve.ghe.ten}</td>
                              <td>${ve.gia} VND</td>
                          </tr>
                        </c:forEach>
                    </c:if>
                    <tr>
                        <th scope="row" colspan="5" style="text-align: right; font-weight: normal;">Tổng giá vé</th>
                        <td>${hoaDonBan.giaVe} VND</td>
                    </tr>
                    <tr>
                        <th scope="row" colspan="5" style="text-align: right; font-weight: normal;">Chiết khấu</th>
                        <td>${hoaDonBan.chietKhau} VND</td>
                    </tr> 
                    <tr>
                        <th scope="row" colspan="5" style="text-align: right;">Thành tiền</th>
                        <td><strong>${hoaDonBan.thanhTien} VND</strong></td>
                    </tr>
                    <tr>
                        <th scope="row" colspan="5" style="text-align: right;">Trạng thái</th>
                        <td><strong>${hoaDonBan.trangThai}</strong></td>
                    </tr>
                </tbody>
            </table>

            <hr>
            <div class="invoice-info" style="align-self: flex-start;">
                <p class="invoice-creator">Nhân viên thanh toán: <span>${nhanVienBanHang.ten}</span></p>
                <p class="invoice-time">Thời gian lập hóa đơn: <span>${hoaDonBan.ngayLap}</span></p>
                <p class="invoice-code">Mã hóa đơn: <span>${hoaDonBan.ma}</span></p>
            </div>
        </c:if>
            
        <form action="xlThanhToan474" method="post" style="width: 100%;">
            <div class="md-3 mt-3" style="float: right;"> 
                <button type="submit" name="action" value="thanhToan" class="btn btn-dark mb-3" ${empty thanhToan ? '': 'disabled'}>Thanh toán</button>
                <button type="submit" name="action" value="hoanTat" class="btn btn-dark mb-3" ${empty thanhToan ? 'disabled': ''}>Hoàn tất</button>
                
            </div>
        </form>
            
        <c:if test="${not empty success}">
            <div class="toast" role="alert" aria-live="assertive" aria-atomic="true" style="position: fixed; bottom: 2em; right: 1em" >
                <div class="toast-header">
                    <strong class="me-auto">Success</strong>
                    <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
                </div>
                <div class="toast-body">
                    ${success}
                </div>
              </div>
        </c:if>
        
        <footer>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
        </footer>
    </body>
    
    <script>
        const toastElement = document.querySelector('.toast');
        const toast = new bootstrap.Toast(toastElement);
        toast.show();
    </script>
</html>
