/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Phim474;

/**
 *
 * @author nguye
 */
public class PhimDao474 extends Dao474 {
    public static void main(String args[]) {
//        List<Phim474> dsPhim = (new PhimDao474()).getAllPhim();
//        for(Phim474 phim: dsPhim) {
//            System.out.println(phim.getTen());
//        }
        
        System.out.println((new PhimDao474()).getPhim(3).getTen());
    }
    
    public PhimDao474() {
        super();
    }
    
    public List<Phim474> getAllPhim() {
        try {
            String query = "SELECT * FROM PHIM474";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            ResultSet resultset = preparedStatement.executeQuery();
            
            List<Phim474> dsPhim = new ArrayList();
            while(resultset.next()) {
                dsPhim.add(new Phim474(
                        resultset.getInt("MA"),
                        resultset.getString("TEN"),
                        resultset.getString("THELOAI"),
                        resultset.getInt("DODAI"),
                        resultset.getString("NGONNGU")
                ));
            }
            return dsPhim;
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public Phim474 getPhim(int ma) {
        try {
            String query = "SELECT * FROM PHIM474 WHERE MA = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, ma);
            ResultSet resultset = preparedStatement.executeQuery();
            
            if(!resultset.next()) return null;
            Phim474 phim = new Phim474(
                    resultset.getInt("MA"),
                    resultset.getString("TEN"),
                    resultset.getString("THELOAI"),
                    resultset.getInt("DODAI"),
                    resultset.getString("NGONNGU")
            );
            return phim;
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
