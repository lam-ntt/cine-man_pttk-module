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
import model.Ghe474;
import model.LichChieu474;

/**
 *
 * @author nguye
 */
public class GheDao474 extends Dao474 {
    public static void main(String args[]) {
//        List<Ghe474> ds = (new GheDao474()).getAllGheDatTheoLichChieu(32);
//        for(Ghe474 g: ds) {
//            System.out.println(g.getTen());
//        }
        
        System.out.println((new GheDao474().getGhe(107).getTen()));
    }
    
    public GheDao474() {
        super();
    }
    
    public List<Ghe474> getAllGheTheoLichChieu(int maLichChieu) {
        try {
            String query = "SELECT G.MA, G.TEN " 
                    + "FROM GHE474 AS G, LICHCHIEU474 AS LC " 
                    + "WHERE G.MAPHONG = LC.MAPHONG AND LC.MA = ?;";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, maLichChieu);
            ResultSet resultset = preparedStatement.executeQuery();
            
            List<Ghe474> dsGhe = new ArrayList();
            while(resultset.next()) {
                dsGhe.add(new Ghe474(
                        resultset.getInt("MA"),
                        resultset.getString("TEN")
                ));
            }
            return dsGhe;
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public List<Ghe474> getAllGheDatTheoLichChieu(int maLichChieu) {
        try {
            String query = "SELECT G.MA, G.TEN " 
                    + "FROM GHE474 AS G, LICHCHIEU474 AS LC, VE474 as V " 
                    + "WHERE G.MA = V.MAGHE AND V.MALICHCHIEU = LC.MA AND LC.MA = ?;";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, maLichChieu);
            ResultSet resultset = preparedStatement.executeQuery();
            
            List<Ghe474> dsGhe = new ArrayList();
            while(resultset.next()) {
                dsGhe.add(new Ghe474(
                        resultset.getInt("MA"),
                        resultset.getString("TEN")
                ));
            }
            return dsGhe;
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public Ghe474 getGhe(int ma) {
        try {
            String query = "SELECT * FROM GHE474 WHERE MA = ?;";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, ma);
            ResultSet resultset = preparedStatement.executeQuery();
            
            if(!resultset.next()) return null;
            Ghe474 ghe = new Ghe474(
                    resultset.getInt("MA"),
                    resultset.getString("TEN")
            );
            return ghe;
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    
}
