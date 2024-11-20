/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author nguye
 */
public class NguoiDungDao474 extends Dao474 {
    public static void main(String args[]) {
        System.out.println(new NguoiDungDao474().ktraEmailTonTai("annv@gmail.com"));
    }
    
    public NguoiDungDao474() {
        super();
    }
    
    public boolean ktraEmailTonTai(String email) {
        try {
            String query = "SELECT * FROM NGUOIDUNG474 WHERE EMAIL = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, email);
            ResultSet resultset = preparedStatement.executeQuery();
            return resultset.next();
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
