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
public class Phim474 implements Serializable {
    private int ma, doDai;
    private String ten, theLoai, ngonNgu;

    public Phim474(int ma, String ten, String theLoai, int doDai, String ngonNgu) {
        this.ma = ma;
        this.ten = ten;
        this.theLoai = theLoai;
        this.doDai = doDai;
        this.ngonNgu = ngonNgu;
    }

    public int getMa() {
        return ma;
    }

    public int getDoDai() {
        return doDai;
    }

    public String getTen() {
        return ten;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public String getNgonNgu() {
        return ngonNgu;
    }
}
