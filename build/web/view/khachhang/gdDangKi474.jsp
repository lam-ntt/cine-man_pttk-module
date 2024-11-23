<%-- 
    Document   : gdDangKi474
    Created on : Nov 18, 2024, 3:19:14 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

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
        
        <div class="section register" style="width: 45em; height: 75vh; display: flex; align-items: center; justify-content: center; margin: auto;">
            <form action="xlDangKi474" method="post" style="width: 100%">
                <h1>Đăng kí tài khoản</h1>
                <hr>
                <div class="mb-3">
                    <label for="email" class="form-label">Email</label>
                    <input type="email" id="email" name="email" class="form-control" required>
                </div>
                <div class="mb-3">
                    <label for="ten" class="form-label">Họ tên</label>
                    <input type="text" id="ten" name="ten" class="form-control" required minlength="8">
                </div>
                <div class="md-3">
                    <label for="matKhau" class="form-label">Mật khẩu</label>
                    <input type="password" id="matKhau" name="matKhau" class="form-control" aria-describedby="passwordHelpBlock" required minlength="8">
                </div>
                <c:if test="${not empty error}">
                    <div class="md-3 mt-3">
                        <div class="form-text">
                            ${error}
                        </div>
                    </div>
                </c:if>
                <div class="md-3 mt-3">
                    <button type="submit" class="btn btn-dark mb-3" style="display: block;">Đăng kí</button>
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
        const toastElement = document.querySelector('.toast');
        const toast = new bootstrap.Toast(toastElement);
        toast.show();
    </script>
</html>
