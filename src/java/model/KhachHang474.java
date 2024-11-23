/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author nguye
 */
public class KhachHang474 extends NguoiDung474 implements Serializable {
    private String maThanThiet;
    
    public KhachHang474(int ma, String email, String ten, String matKhau, String maThanThiet) {
        super(ma, email, ten, matKhau);
        this.maThanThiet = maThanThiet;
    }
    
    public KhachHang474(String email, String ten, String matKhau) {
        super(email, ten, matKhau);
    }

    public String getMaThanThiet() {
        return maThanThiet;
    }
}
