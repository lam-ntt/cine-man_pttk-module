/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Phim474;
import model.Phong474;

/**
 *
 * @author nguye
 */
public class PhongDao474 extends Dao474 {
    public static void main(String args[]) {
        System.out.println((new PhongDao474()).getPhong(4).getTen());
    }
    
    public PhongDao474() {
        super();
    }
    
    public Phong474 getPhong(int ma) {
        try {
            String query = "SELECT * FROM PHONG474 WHERE MA = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, ma);
            ResultSet resultset = preparedStatement.executeQuery();
            
            if(!resultset.next()) return null;
            Phong474 phong = new Phong474(
                    resultset.getInt("MA"),
                    resultset.getString("TEN"),
                    resultset.getInt("SUCCHUA"),
                    resultset.getString("LOAIPHONG"),
                    resultset.getString("VITRI")
            );
            return phong;
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
