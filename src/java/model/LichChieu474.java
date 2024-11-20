/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 *
 * @author nguye
 */
public class LichChieu474 implements Serializable {
    private int ma;
    private Timestamp batDau, ketThuc, ngayLap;
    private Phim474 phim;
    private Phong474 phong;
    private NhanVien474 nhanVien;

    public LichChieu474(int ma, Timestamp batDau, Timestamp ketThuc) {
        this.ma = ma;
        this.batDau = batDau;
        this.ketThuc = ketThuc;
    }

    public LichChieu474(int ma, Timestamp batDau, Timestamp ketThuc, Timestamp ngayLap, Phim474 phim, Phong474 phong, NhanVien474 nhanVien) {
        this.ma = ma;
        this.batDau = batDau;
        this.ketThuc = ketThuc;
        this.ngayLap = ngayLap;
        this.phim = phim;
        this.phong = phong;
        this.nhanVien = nhanVien;
    }

    public int getMa() {
        return ma;
    }

    public Timestamp getBatDau() {
        return batDau;
    }

    public Timestamp getKetThuc() {
        return ketThuc;
    }

    public Timestamp getNgayLap() {
        return ngayLap;
    }

    public Phim474 getPhim() {
        return phim;
    }

    public Phong474 getPhong() {
        return phong;
    }

    public NhanVien474 getNhanVien() {
        return nhanVien;
    }
}
