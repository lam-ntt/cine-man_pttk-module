/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import model.LichChieu474;
import model.NhanVien474;

/**
 *
 * @author nguye
 */
public class LichChieuDao474 extends Dao474 {
    public static void main(String args[]) {
//        List<LichChieu474> ds = (new LichChieuDao474()).getAllLichChieuTheoPhim(1);
//        for(LichChieu474 lc: ds) {
//            System.out.println(lc.getMa() + " " + lc.getBatDau() + " " + lc.getKetThuc());
//        }
        
        LichChieu474 lc = (new LichChieuDao474()).getLichChieu(35);
        System.out.println(lc.getPhim().getTen() + " " + lc.getPhong().getTen() + " " + lc.getNhanVien().getTen());
    }
    
    public LichChieuDao474() {
        super();
    }
    
    public List<LichChieu474> getAllLichChieuTheoPhim(int ma) {
        try {
            String query = "SELECT LC.MA, LC.BATDAU, LC.KETTHUC " 
                    + "FROM LICHCHIEU474 as LC, PHIM474 as P " 
                    + "WHERE LC.MAPHIM = P.MA and LC.BATDAU > NOW() AND P.MA = ?;";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, ma);
            ResultSet resultset = preparedStatement.executeQuery();
            
            List<LichChieu474> dsLichChieu = new ArrayList();
            while(resultset.next()) {
                dsLichChieu.add(new LichChieu474(
                        resultset.getInt("MA"),
                        resultset.getTimestamp("BATDAU"),
                        resultset.getTimestamp("KETTHUC")
                ));
            }
            return dsLichChieu;
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public LichChieu474 getLichChieu(int ma) {
        try {
            String query = "SELECT * FROM LICHCHIEU474 WHERE MA = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, ma);
            ResultSet resultset = preparedStatement.executeQuery();
            
            if(!resultset.next()) return null;
            LichChieu474 lichChieu = new LichChieu474(
                    resultset.getInt("MA"),
                    resultset.getTimestamp("BATDAU"),
                    resultset.getTimestamp("KETTHUC"),
                    resultset.getTimestamp("NGAYLAP"),
                    (new PhimDao474()).getPhim(resultset.getInt("MAPHIM")),
                    (new PhongDao474()).getPhong(resultset.getInt("MAPHONG")),
                    (new NhanVienDao474()).getNhanVien(resultset.getInt("MANHANVIEN"))
            );
            
            return lichChieu;
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
