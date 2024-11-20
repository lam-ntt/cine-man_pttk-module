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
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.HoaDonBan474;
import model.NhanVien474;
import model.Ve474;
import service.HoaDonBanDao474;
import service.VeDao474;

/**
 *
 * @author nguye
 */
public class xlThanhToan474 extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        
//        PrintWriter out = response.getWriter();
//        out.println();
//        out.close();
        
        if (action.equals("thanhToan")) {
            float tongGiaVe = (Float) session.getAttribute("tongGiaVe");
            float chietKhau = (Float) session.getAttribute("chietKhau");
            NhanVien474 nhanVien = (NhanVien474) session.getAttribute("nhanVienBanHang");
            
            HoaDonBanDao474 hoaDonBanDao = new HoaDonBanDao474();
            int maHoaDonBan = hoaDonBanDao.addHoaDonBan(tongGiaVe, chietKhau, nhanVien.getMa());
            
            VeDao474 veDao = new VeDao474();
            List<Ve474> dsVe = (List<Ve474>) session.getAttribute("dsVe");
            for(Ve474 ve: dsVe) {
                veDao.addVe(ve.getGia(), ve.getLichChieu().getMa(), ve.getGhe().getMa(), maHoaDonBan);
            }
            
            HoaDonBan474 hoaDonBan = hoaDonBanDao.getHoaDonBan(maHoaDonBan);
            session.setAttribute("hoaDonBan", hoaDonBan);
            session.setAttribute("thanhToan", true);
            
            request.setAttribute("success", "Thanh toán hóa đơn thành công!");
            request.getRequestDispatcher("gdThanhToan474.jsp").forward(request, response);
        } else if (action.equals("hoanTat")) {
            session.removeAttribute("dsVe");
            session.removeAttribute("tongGiaVe");
            session.removeAttribute("xacNhan");
            session.removeAttribute("maThanThiet");
            session.removeAttribute("chietKhau");
            session.removeAttribute("thanhTien");
            session.removeAttribute("hoaDonBan");
            session.removeAttribute("thanhToan");
            
            request.getRequestDispatcher("gdChinh474.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Object xacThucObj = session.getAttribute("xacThuc");
        if(xacThucObj == null || Boolean.FALSE.equals(xacThucObj)){
            getServletContext().getRequestDispatcher("/gdDangNhap474.jsp").forward(request, response);
        }
        
        request.getRequestDispatcher("gdThanhToan474.jsp").forward(request, response);
        
    }

}
