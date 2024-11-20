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
public class NhanVien474 extends NguoiDung474 implements Serializable {
    private String viTri; 
    
    public NhanVien474(int ma, String email, String ten, String matKhau, String viTri) {
        super(ma, email, ten, matKhau);
        this.viTri = viTri;
    }

    public String getViTri() {
        return viTri;
    }
}
