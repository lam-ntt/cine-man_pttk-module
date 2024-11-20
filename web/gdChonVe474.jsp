<%-- 
    Document   : gdChonVe474
    Created on : Nov 18, 2024, 3:19:23 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
        
        <div class="section choose-ticket" style="width: 50em; overflow: auto; display: flex; flex-direction: column; align-items: center; justify-content: center; margin: auto; margin-top: 5em; margin-bottom: 5em">
            <form action="xlChonVe474" method="post" style="width: 100%">
                <h1>Chọn vé</h1>
                <hr>

                <div style="display: flex; flex-direction: row; gap: 2em">
                    <div style="flex: 3.5 3.5 0;">
                        <div class="mb-3">
                            <label for="phim" class="form-label">Phim</label>
                            <select id="phim" name="phim" class="form-select"
                                    onchange="this.form.requestSubmit(document.getElementById('chonPhim'))" 
                                    >
                                <option ${empty maPhim ? 'selected' : ''} disabled >Chọn phim</option>
                                <c:if test="${not empty dsPhim}">
                                    <c:forEach var="phim" items="${dsPhim}" varStatus="status">
                                        <option value="${phim.ma}" 
                                                ${(not empty maPhim && maPhim == phim.ma) ? 'selected' : ''}
                                                >${phim.ten}</option>
                                    </c:forEach>
                                </c:if>
                            </select>
                        </div>

                        <div class="mb-3">
                            <label for="gio" class="form-label">Giờ chiếu</label>
                            <select id="gio" name="gio" class="form-select"
                                    onchange="this.form.requestSubmit(document.getElementById('chonGio'))" 
                                    >
                                <option ${empty maLichChieu ? 'selected' : ''} disabled >Chọn giờ</option>
                                <c:if test="${not empty dsLichChieu}">
                                    <c:forEach var="lichChieu" items="${dsLichChieu}" varStatus="status">
                                        <option value="${lichChieu.ma}" 
                                                ${(not empty maLichChieu && maLichChieu == lichChieu.ma) ? 'selected' : ''}
                                                >
                                            <fmt:formatDate value="${lichChieu.batDau}" pattern="HH:mm" /> - 
                                            <fmt:formatDate value="${lichChieu.ketThuc}" pattern="HH:mm" />
                                            <fmt:formatDate value="${lichChieu.batDau}" pattern="dd/MM/yyyy" />
                                        </option>
                                    </c:forEach>
                                </c:if>
                            </select>
                        </div>
                    </div>

                    <div style="flex: 5 5 0;">
                        <div class="mb-3">
                            <label for="ghe" class="form-label">Số ghế</label>
                            <br>
                            <div class="btn-group-vertical" role="group" style="display: flex; justify-content: center; align-items: center;">
                                <c:if test="${empty dsGhe}">
                                    <div style="width: 100%; height: 18em; border: 1px solid rgb(225, 225, 225); border-radius: .25em">
                                    </div>
                                </c:if>

                                <c:if test="${not empty dsGhe}">
                                    <c:forEach var="ghe" items="${dsGhe}" varStatus="status">
                                        <c:if test="${(fn:length(dsGhe) == 64 && status.index % 8 == 0) 
                                                      || (fn:length(dsGhe) == 80 && status.index % 10 == 0)}">
                                            <div class="btn-group" role="group"> 
                                        </c:if>

                                        <c:if test="${not empty dsLichChieu}">
                                            <c:set var="found" value="false" />
                                            <c:forEach var="gheDat" items="${dsGheDat}">
                                                <c:if test="${gheDat.ma == ghe.ma}">
                                                    <c:set var="found" value="true" />
                                                </c:if>
                                            </c:forEach>
                                        </c:if>

                                        <c:if test="${not empty dsMaGhe}">
                                            <c:set var="selected" value="false" />
                                            <c:forEach var="maGhe" items="${dsMaGhe}">
                                                <c:if test="${maGhe == ghe.ma}">
                                                    <c:set var="selected" value="true" />
                                                </c:if>
                                            </c:forEach>
                                        </c:if>

                                        <input type="checkbox" class="btn-check" id="${ghe.ma}" name="ghe" value="${ghe.ma}" 
                                               onchange="${not empty found && found ? '' : 'this.form.requestSubmit(document.getElementById(\'chonGhe\'))'}"
                                               ${(not empty found && found) ? 'readonly' : ''}
                                               ${(not empty selected && selected) ? 'checked': ''}
                                               >
                                        <label class="btn btn-light border" for="${ghe.ma}" 
                                               style="color: ${not empty found && found ? 'white' : ''}; background-color: ${not empty found && found ? 'grey' : ''}"
                                               >${ghe.ten}</label>

                                        <c:if test="${(fn:length(dsGhe) == 64 && status.index % 8 == 7) 
                                                      || (fn:length(dsGhe) == 80 && status.index % 10 == 9)}">
                                            </div>
                                        </c:if>
                                    </c:forEach>
                                </c:if>
                            </div>
                        </div>

                        <div class="md-3 mt-3">
                            <div class="form-text" id="error"></div>
                        </div>
                    </div>
                </div>

                <div class="md-3 mt-3" style="float: right;">
                    <button type="submit" id="chonPhim" name="action" value="chonPhim" class="btn btn-dark mb-3" style="display: none">Phim</button>
                    <button type="submit" id="chonGio" name="action" value="chonGio" class="btn btn-dark mb-3" style="display: none">Gio</button>
                    <button type="submit" id="chonGhe" name="action" value="chonGhe" class="btn btn-dark mb-3" style="display: none">Ghe</button>
                    <button type="submit" name="action" value="luu" class="btn btn-dark mb-3" ${dsMaGhe == null ? 'disabled': ''}>Lưu</button>
                </div>
            </form>
        </div>

        <div class="section confirm-ticket" style="width: 50em; display: flex; flex-direction: column; align-items: center; justify-content: center; margin: auto; margin-bottom: 5em">
            <h1 class="ticket-title">Các vé đã lưu</h1>
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
                        <th scope="row" colspan="5" style="text-align: right;">Tổng giá vé</th>
                        <td><strong>${not empty tongGiaVe ? tongGiaVe : ''} VND</strong></td>
                    </tr>
                </tbody>
            </table>

            <form action="xlChonVe474" method="post" style="width: 100%;">
                <div class="mb-3" style="width: 200px;">
                    <label for="maThanThiet" class="form-label">Mã thân thiết</label>
                    <input type="text" id="maThanThiet" name="maThanThiet" class="form-control">
                </div>
                <c:if test="${not empty error}">
                    <div class="md-3 mt-3">
                        <div class="form-text">
                            ${error}
                        </div>
                    </div>
                </c:if>
                <div class="md-3 mt-3"> 
                    <button type="submit" name="action" value="xacNhan" class="btn btn-dark mb-3" style="float: right;"  ${(empty tongGiaVe || tongGiaVe == 0.0) ? 'disabled': ''}>Xác nhận</button>
                </div>
            </form>
        </div>
        
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
        document.querySelectorAll('input[type="checkbox"]').forEach(checkbox => {
            checkbox.addEventListener('click', (event) => {
              if (checkbox.hasAttribute("readonly")) {
                    document.getElementById("error").innerText = "Ghế này đã được chọn!";
                    event.preventDefault();
              }
            });
        });
        
        const toastElement = document.querySelector('.toast');
        const toast = new bootstrap.Toast(toastElement);
        toast.show();
    </script>
</html>
