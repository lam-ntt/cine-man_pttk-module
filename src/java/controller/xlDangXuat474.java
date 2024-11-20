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
public class xlDangXuat474 extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        session.removeAttribute("nhanVienBanHang");
        session.removeAttribute("xacThuc");
        request.getRequestDispatcher("gdDangNhap474.jsp").forward(request, response);
        
        PrintWriter out = response.getWriter();
        out.println("OK");
        out.close();
        
    }

}
