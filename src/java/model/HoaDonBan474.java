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
public class HoaDonBan474 extends HoaDon474 implements Serializable {
    private NhanVien474 nhanVien;
    
    public HoaDonBan474(int ma, float giaVe, float chietKhau, float thanhTien, String trangThai, Timestamp ngayLapStamp, List<Ve474> dsVe, NhanVien474 nhanVien) {
        super(ma, giaVe, chietKhau, thanhTien, trangThai, ngayLapStamp, dsVe);
        this.nhanVien = nhanVien;
    }

    public NhanVien474 getNhanVien() {
        return nhanVien;
    }
}
