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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import model.Ghe474;
import model.LichChieu474;
import model.Phim474;
import model.Ve474;
import service.GheDao474;
import service.KhachHangDao474;
import service.LichChieuDao474;
import service.PhimDao474;

/**
 *
 * @author nguye
 */
public class xlChonVe474 extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        
        PrintWriter out = response.getWriter();
//        out.println();
//        out.close();
        
                
        switch (action) {
            case "chonPhim" -> {
                String maPhim = request.getParameter("phim");
                session.setAttribute("maPhim", maPhim);
                
                session.removeAttribute("dsLichChieu");
                session.removeAttribute("maLichChieu");
                session.removeAttribute("dsGhe");
                session.removeAttribute("dsGheDat");
                
                List<LichChieu474> dsLichChieu = (new LichChieuDao474()).getAllLichChieuTheoPhim(Integer.parseInt(maPhim));
                session.setAttribute("dsLichChieu", dsLichChieu);
                getServletContext().getRequestDispatcher("/gdChonVe474.jsp").forward(request, response);
            }
            case "chonGio" -> {
                String maLichChieu = request.getParameter("gio");
                session.setAttribute("maLichChieu", maLichChieu);
                
                session.removeAttribute("dsGhe");
                session.removeAttribute("dsGheDat");
                
                GheDao474 gheDao = new GheDao474();
                List<Ghe474> dsGhe = gheDao.getAllGheTheoLichChieu(Integer.parseInt(maLichChieu));
                List<Ghe474> dsGheDat = gheDao.getAllGheDatTheoLichChieu(Integer.parseInt(maLichChieu));            
                session.setAttribute("dsGhe", dsGhe);
                session.setAttribute("dsGheDat", dsGheDat);
                getServletContext().getRequestDispatcher("/gdChonVe474.jsp").forward(request, response);
            }
            case "chonGhe" -> {
                String[] dsMaGheStr = request.getParameterValues("ghe");
                List<Integer> dsMaGhe = new ArrayList<>();
                if(dsMaGheStr != null) {
                    for (String dsMaGheStr1 : dsMaGheStr) {
                        dsMaGhe.add(Integer.parseInt(dsMaGheStr1));
                    }
                }
                
                session.setAttribute("dsMaGhe", dsMaGhe);
                getServletContext().getRequestDispatcher("/gdChonVe474.jsp").forward(request, response);
            }
            case "luu" -> {
                int maLichChieu = Integer.parseInt((String) session.getAttribute("maLichChieu"));
                List<Integer> dsMaGhe = (List<Integer>) session.getAttribute("dsMaGhe");
                
                Object dsVeObj = session.getAttribute("dsVe");
                List<Ve474> dsVe = new ArrayList<>();
                if(dsVeObj != null) {
                    dsVe = (List<Ve474>) dsVeObj;
                }
                for(Integer i: dsMaGhe) {
                    Ve474 ve = new Ve474(
                            (new LichChieuDao474()).getLichChieu(maLichChieu),
                            (new GheDao474()).getGhe(i)
                    );
                    ve.setGia((float) 100.99);
                    dsVe.add(ve);
                }
                session.setAttribute("dsVe", dsVe);
                
                session.removeAttribute("maPhim");
                session.removeAttribute("dsLichChieu");
                session.removeAttribute("maLichChieu");
                session.removeAttribute("dsGhe");
                session.removeAttribute("dsGheDat");
                
                request.setAttribute("success", "Vé đã được lưu tạm thời!");
                getServletContext().getRequestDispatcher("/gdChonVe474.jsp").forward(request, response);
            }
            case "tiep" -> {
                float tongGiaVe = 0;
                for(Ve474 ve: (List<Ve474>) session.getAttribute("dsVe")) {
                    tongGiaVe += ve.getGia();
                }
                
                session.removeAttribute("dsMaGhe");
                
                session.setAttribute("tongGiaVe", tongGiaVe);
                session.setAttribute("xacNhan", true);
                getServletContext().getRequestDispatcher("/gdChonVe474.jsp").forward(request, response);
            }
            case "xacNhan" -> {
                String maThanThiet = request.getParameter("maThanThiet");
                if(!maThanThiet.equals("")) {
                    if(!(new KhachHangDao474()).ktrMaThanThiet(maThanThiet)) {
                        request.setAttribute("error", "Mã thân thiết này không hợp lệ!");
                        getServletContext().getRequestDispatcher("/gdChonVe474.jsp").forward(request, response);
                    }
                    
                    float tongGiaVe = (Float) session.getAttribute("tongGiaVe");
                    float chietKhau = chietKhau = maThanThiet.charAt(3) == '1' 
                            ? (float) (tongGiaVe * 0.05) : (maThanThiet.charAt(3) == '2' 
                            ? (float) (tongGiaVe * 0.1) : (maThanThiet.charAt(3) == '1' 
                            ? (float) (tongGiaVe * 0.15) : (float) 0));
                    float thanhTien = tongGiaVe - chietKhau;

                    session.setAttribute("maThanThiet", maThanThiet);
                    session.setAttribute("chietKhau", chietKhau);
                    session.setAttribute("thanhTien", thanhTien);
                } else {
                    float tongGiaVe = (Float) session.getAttribute("tongGiaVe");
                    session.setAttribute("maThanThiet", maThanThiet);
                    session.setAttribute("chietKhau", (float) 0);
                    session.setAttribute("thanhTien", tongGiaVe);
                }
                response.sendRedirect("xlThanhToan474");
            }
            default -> {
            }
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
        
        PhimDao474 phimDao = new PhimDao474();
        List<Phim474> dsPhim = phimDao.getAllPhim();
        session.setAttribute("dsPhim", dsPhim);
        request.getRequestDispatcher("/gdChonVe474.jsp").forward(request, response);
    }

}
