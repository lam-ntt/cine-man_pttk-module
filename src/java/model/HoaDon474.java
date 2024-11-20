/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author nguye
 */
public class HoaDon474 implements Serializable {
    protected int ma;
    protected float giaVe, chietKhau, thanhTien;
    protected String trangThai;
    protected Timestamp ngayLap;
    protected List<Ve474> dsVe;

    public HoaDon474(int ma, float giaVe, float chietKhau, float thanhTien, String trangThai, Timestamp ngayLap, List<Ve474> dsVe) {
        this.ma = ma;
        this.giaVe = giaVe;
        this.chietKhau = chietKhau;
        this.thanhTien = thanhTien;
        this.trangThai = trangThai;
        this.ngayLap = ngayLap;
        this.dsVe = dsVe;
    }

    public int getMa() {
        return ma;
    }

    public float getGiaVe() {
        return giaVe;
    }

    public float getChietKhau() {
        return chietKhau;
    }

    public float getThanhTien() {
        return thanhTien;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public Timestamp getNgayLap() {
        return ngayLap;
    }

    public List<Ve474> getDsVe() {
        return dsVe;
    }

    public void setDsVe(List<Ve474> dsVe) {
        this.dsVe = dsVe;
    }
}
