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
public class NguoiDung474 implements Serializable {
    protected int ma;
    protected String email, ten, matKhau;

    public NguoiDung474(int ma, String email, String ten, String matKhau) {
        this.ma = ma;
        this.email = email;
        this.ten = ten;
        this.matKhau = matKhau;
    }
    
    public NguoiDung474(String email, String ten, String matKhau) {
        this.email = email;
        this.ten = ten;
        this.matKhau = matKhau;
    }

    public int getMa() {
        return ma;
    }

    public String getEmail() {
        return email;
    }

    public String getTen() {
        return ten;
    }

    public String getMatKhau() {
        return matKhau;
    }
    
    
}
