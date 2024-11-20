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
public class Phong474 implements Serializable {
    private int ma;
    private String ten;
    private int sucChua;
    private String loaiPhongString, viTri;

    public Phong474(int ma, String ten, int sucChua, String loaiPhongString, String viTri) {
        this.ma = ma;
        this.ten = ten;
        this.sucChua = sucChua;
        this.loaiPhongString = loaiPhongString;
        this.viTri = viTri;
    }

    public int getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public int getSucChua() {
        return sucChua;
    }

    public String getLoaiPhongString() {
        return loaiPhongString;
    }

    public String getViTri() {
        return viTri;
    }
}
