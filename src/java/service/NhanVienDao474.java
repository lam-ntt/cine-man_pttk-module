/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.NhanVien474;

/**
 *
 * @author nguye
 */
public class NhanVienDao474 extends Dao474 {
    public static void main(String args[]) {
//        NhanVien474 nv = (new NhanVienDao474()).getNhanVienTheoEmail("tuanlm@gmail.com");
//        System.out.println(nv.getMa() + " " + nv.getEmail() + " " + nv.getTen());
        
        System.out.println((new NhanVienDao474()).getNhanVien(3).getTen());
    }
    
    public NhanVienDao474() {
        super();
    }
    
    public NhanVien474 getNhanVienTheoEmail(String email) {
        try {
            String query = "SELECT ND.MA, ND.EMAIL, ND.TEN, ND.MATKHAU, NV.VITRI "
                    + "FROM NGUOIDUNG474 AS ND, NHANVIEN474 AS NV "
                    + "WHERE ND.MA = NV.MA AND ND.EMAIL = ?;";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, email);
            ResultSet resultset = preparedStatement.executeQuery();
            
            if(!resultset.next()) return null;
            NhanVien474 nhanVien = new NhanVien474(
                    resultset.getInt("MA"),
                    resultset.getString("EMAIL"), 
                    resultset.getString("TEN"), 
                    resultset.getString("MATKHAU"), 
                    resultset.getString("VITRI")
            );
            return nhanVien;
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public NhanVien474 getNhanVien(int ma) {
        try {
            String query = "SELECT ND.MA, ND.EMAIL, ND.TEN, ND.MATKHAU, NV.VITRI "
                    + "FROM NGUOIDUNG474 AS ND, NHANVIEN474 AS NV "
                    + "WHERE ND.MA = NV.MA AND ND.MA = ?;";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, ma);
            ResultSet resultset = preparedStatement.executeQuery();
            
            if(!resultset.next()) return null;
            NhanVien474 nhanVien = new NhanVien474(
                    resultset.getInt("MA"),
                    resultset.getString("EMAIL"), 
                    resultset.getString("TEN"), 
                    resultset.getString("MATKHAU"), 
                    resultset.getString("VITRI")
            );
            return nhanVien;
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
