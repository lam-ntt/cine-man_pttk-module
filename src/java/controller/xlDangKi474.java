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
import service.*;
import helper.Hash;

/**
 *
 * @author nguye
 */
public class xlDangKi474 extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String email = request.getParameter("email");
        String ten = request.getParameter("ten");
        String matKhau = request.getParameter("matKhau");
        matKhau = Hash.hash(matKhau);
        
        NguoiDungDao474 nguoiDungDao = new NguoiDungDao474();
        if(nguoiDungDao.ktraEmailTonTai(email)) {
            request.setAttribute("error", "Email này đã tồn tại. Vui lòng chọn một email khác!");
            getServletContext().getRequestDispatcher("/gdDangKi474.jsp").forward(request, response);
        }
        
        KhachHangDao474 khachHangDao = new KhachHangDao474();
        if(!khachHangDao.addKhackHang(email, ten, matKhau)) {
            request.setAttribute("error", "Lỗi hệ thống. Vui lòng thử lại!");
            getServletContext().getRequestDispatcher("/gdDangKi474.jsp").forward(request, response);
        }
            
        request.setAttribute("success", "Tài khoản được tạo thành công. Bạn có thể đăng nhập!");
        getServletContext().getRequestDispatcher("/gdDangNhap474.jsp").forward(request, response);

//        PrintWriter out = response.getWriter();
//        out.println("OK");
//        out.close();
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("gdDangKi474.jsp").forward(request, response);
    }

}
