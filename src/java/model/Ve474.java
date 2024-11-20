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
public class Ve474 implements Serializable {
    private int ma;
    private float gia;
    private LichChieu474 lichChieu;
    private Ghe474 ghe;

    public Ve474(LichChieu474 lichChieu, Ghe474 ghe) {
        this.lichChieu = lichChieu;
        this.ghe = ghe;
    }

    public Ve474(int ma, float gia, LichChieu474 lichChieu, Ghe474 ghe) {
        this.ma = ma;
        this.gia = gia;
        this.lichChieu = lichChieu;
        this.ghe = ghe;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public int getMa() {
        return ma;
    }

    public float getGia() {
        return gia;
    }

    public LichChieu474 getLichChieu() {
        return lichChieu;
    }

    public Ghe474 getGhe() {
        return ghe;
    }
}
