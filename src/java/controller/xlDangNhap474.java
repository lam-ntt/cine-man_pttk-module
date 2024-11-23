/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import service.KhachHangDao474;
import model.KhachHang474;
import helper.Hash;
import model.NhanVien474;
import service.NguoiDungDao474;
import service.NhanVienDao474;

/**
 *
 * @author nguye
 */
public class xlDangNhap474 extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String email = request.getParameter("email");
        String matKhau = request.getParameter("matKhau");
        
        NguoiDungDao474 nguoiDungDao = new NguoiDungDao474();
        if(!nguoiDungDao.ktraEmailTonTai(email)) {
            request.setAttribute("error", "Email này không tồn tại trong hệ thống. Vui lòng đăng kí tài khoản!");
            getServletContext().getRequestDispatcher("/view/nguoidung/gdDangNhap474.jsp").forward(request, response);
        }
        
        NhanVienDao474 nhanVienDao = new NhanVienDao474();
        NhanVien474 nhanVien = nhanVienDao.getNhanVienTheoEmail(email);
        if(nhanVien == null) {
            request.setAttribute("error", "Email này không hợp lệ. Vui lòng thử lại!");
            getServletContext().getRequestDispatcher("/view/nguoidung/gdDangNhap474.jsp").forward(request, response);
        }
        if(!nhanVien.getMatKhau().equals(Hash.hash(matKhau))) {
            request.setAttribute("error", "Mật khẩu không chính xác. Vui lòng thử lại!");
            getServletContext().getRequestDispatcher("/view/nguoidung/gdDangNhap474.jsp").forward(request, response);
            
        }
        
        if(nhanVien.getViTri().equals("Nhân viên bán hàng")) {
            HttpSession session = request.getSession();
            session.setAttribute("xacThuc", true);
            session.setAttribute("nhanVienBanHang", nhanVien);
            getServletContext().getRequestDispatcher("/view/nguoidung/gdChinh474.jsp").forward(request, response);
//            response.sendRedirect("/pttk/view/nguoidung/gdChinh474.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.getRequestDispatcher("/view/nguoidung/gdDangNhap474.jsp").forward(request, response);
    }

}
