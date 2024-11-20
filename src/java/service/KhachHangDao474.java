/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.KhachHang474;

/**
 *
 * @author nguye
 */
public class KhachHangDao474 extends Dao474 {
    public static void main(String args[]) {
//        System.out.println((new KhachHangDao474()).addKhackHang("lamntt2@gmail.com", "Nguyễn Thị Thanh Lam", "123"));
    
        System.out.println((new KhachHangDao474()).ktrMaThanThiet("MXAQ23"));
    }
    
    public KhachHangDao474() {
        super();
    }
    
    public boolean addKhackHang(String email, String ten, String matKhau) {
        try {
            String query = "INSERT INTO NGUOIDUNG474(EMAIL, TEN, MATKHAU) VALUES(?, ?, ?)"; 
            PreparedStatement preparedStatement = 
                    con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, ten);
            preparedStatement.setString(3, matKhau);
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if(!resultSet.next()) return false;
            int maKhachHang = resultSet.getInt(1);
            
            query = "INSERT INTO KHACHHANG474(MA) " + "VALUES(?)"; 
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, maKhachHang);
            int rowAffected = preparedStatement.executeUpdate();
            return rowAffected == 1;
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public boolean ktrMaThanThiet(String maThanThiet) {
        try {
            String query = "SELECT * "
                    + "FROM NGUOIDUNG474 AS ND, KHACHHANG474 AS KH "
                    + "WHERE ND.MA = KH.MA AND KH.MATHANTHIET = ?;";
            PreparedStatement preparedStatement = 
                    con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, maThanThiet);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(!resultSet.next()) return false;
            return true;
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
