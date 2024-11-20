/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.HoaDonBan474;
import model.LichChieu474;
import model.Ve474;

/**
 *
 * @author nguye
 */
public class VeDao474 extends Dao474 {
    public static void main(String args[]) {
        System.out.println((new VeDao474()).addVe(54, 31, 1, 1));
    }
    
    public VeDao474() {
        super();
    }
    
    public boolean addVe(float gia, int maLichChieu, int maGhe, int maHoaDon) {
        try {
            String query = "INSERT INTO VE474(GIA, MALICHCHIEU, MAGHE, MAHOADON) VALUES(?, ?, ?, ?)"; 
            
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setFloat(1, gia);
            preparedStatement.setInt(2, maLichChieu);
            preparedStatement.setInt(3, maGhe);
            preparedStatement.setInt(4, maHoaDon);
            int rowAffected = preparedStatement.executeUpdate();
            
            if(rowAffected != 1) return false;
            return true;
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public List<Ve474> getAllVeTheoHoaDon(int maHoaDon) {
        try {
            String query = "SELECT * FROM VE474 WHERE MAHOADON = ?;"; 
            
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setFloat(1, maHoaDon);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            List<Ve474> dsVe = new ArrayList<>();
            while(resultSet.next()) {
                dsVe.add(new Ve474(
                        resultSet.getInt("MA"),
                        resultSet.getFloat("GIA"),
                        (new LichChieuDao474()).getLichChieu(resultSet.getInt("MALICHCHIEU")),
                        (new GheDao474()).getGhe(resultSet.getInt("MAGHE"))
                ));
            }
            return dsVe;
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
}
