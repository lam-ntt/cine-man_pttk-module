/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.HoaDonBan474;

/**
 *
 * @author nguye
 */
public class HoaDonBanDao474 extends Dao474{
    public static void main(String argsS[]) {
//        int ma = (new HoaDonBanDao474()).addHoaDonBan(45, 0, 3);
//        System.out.println(ma);
        
        HoaDonBan474 hd = (new HoaDonBanDao474()).getHoaDonBan(10);
        System.out.println(hd.getGiaVe() + " " + hd.getChietKhau() + " " + hd.getThanhTien());
    }
    
    public HoaDonBanDao474() {
        super();
    }
    
//    public int addHoaDonBan(float giaVe, float chietKhau, int maNhanVien) {
//        try {
//            String query = "INSERT INTO HOADON474(GIAVE, CHIETKHAU, THANHTIEN, TRANGTHAI) VALUES(?, ?, ?, 'Đã thanh toán')"; 
//            PreparedStatement preparedStatement = 
//                    con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
//            preparedStatement.setFloat(1, giaVe);
//            preparedStatement.setFloat(2, chietKhau);
//            preparedStatement.setFloat(3, giaVe-chietKhau);
//            preparedStatement.executeUpdate();
//            ResultSet resultSet = preparedStatement.getGeneratedKeys();
//            if(!resultSet.next()) return -1;
//            int maHoaDonBan = resultSet.getInt(1);
//            
//            query = "INSERT INTO HOADONBAN474(MA, MANHANVIEN) " + "VALUES(?, ?)"; 
//            preparedStatement = con.prepareStatement(query);
//            preparedStatement.setInt(1, maHoaDonBan);
//            preparedStatement.setInt(2, maNhanVien);
//            int rowAffected = preparedStatement.executeUpdate();
//            if(rowAffected != 1) return -1;
//            return maHoaDonBan;
//        } catch(SQLException ex) {
//            ex.printStackTrace();
//        }
//        return -1;
//    }
    
    public int addHoaDonBan(HoaDonBan474 hoaDonBan) {
        try {
            String query = "INSERT INTO HOADON474(GIAVE, CHIETKHAU, THANHTIEN, TRANGTHAI) VALUES(?, ?, ?, 'Đã thanh toán')"; 
            PreparedStatement preparedStatement = 
                    con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setFloat(1, hoaDonBan.getGiaVe());
            preparedStatement.setFloat(2, hoaDonBan.getChietKhau());
            preparedStatement.setFloat(3, hoaDonBan.getGiaVe()-hoaDonBan.getChietKhau());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if(!resultSet.next()) return -1;
            int maHoaDonBan = resultSet.getInt(1);
            
            query = "INSERT INTO HOADONBAN474(MA, MANHANVIEN) " + "VALUES(?, ?)"; 
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, maHoaDonBan);
            preparedStatement.setInt(2, hoaDonBan.getNhanVien().getMa());
            int rowAffected = preparedStatement.executeUpdate();
            if(rowAffected != 1) return -1;
            return maHoaDonBan;
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }
    
    public HoaDonBan474 getHoaDonBan(int ma) {
        try {
            String query = "SELECT HD.MA, HD.GIAVE, HD.CHIETKHAU, HD.THANHTIEN, HD.TRANGTHAI, HD.NGAYLAP, HDB.MANHANVIEN "
                    + "FROM HOADON474 AS HD, HOADONBAN474 AS HDB "
                    + "WHERE HD.MA = HDB.MA AND HD.MA = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, ma);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if(!resultSet.next()) return null;
            HoaDonBan474 hoaDonBan = new HoaDonBan474(
                    resultSet.getInt("MA"),
                    resultSet.getFloat("GIAVE"),
                    resultSet.getFloat("CHIETKHAU"),
                    resultSet.getFloat("THANHTIEN"),
                    resultSet.getString("TRANGTHAI"),
                    resultSet.getTimestamp("NGAYLAP"),
                    null,
                    (new NhanVienDao474()).getNhanVien(resultSet.getInt("MANHANVIEN"))
            );
            hoaDonBan.setDsVe((new VeDao474()).getAllVeTheoHoaDon(ma));
            return hoaDonBan;
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    
}
