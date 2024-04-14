/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main.QLKH.QlyCuaHangBanSach.Model;

import java.sql.Timestamp;

public class KhachHang_2 {

    private String MAKH, MASACH;
    private Timestamp THOIGIAN;
    private int TONGTIEN, SOLUONG;

    public KhachHang_2() {
    }

    public KhachHang_2(String MAKH, String MASACH, Timestamp THOIGIAN, int TONGTIEN, int SOLUONG) {
        this.MAKH = MAKH;
        this.MASACH = MASACH;
        this.THOIGIAN = THOIGIAN;
        this.TONGTIEN = TONGTIEN;
        this.SOLUONG = SOLUONG;
    }

    public String getMAKH() {
        return MAKH;
    }

    public void setMAKH(String MAKH) {
        this.MAKH = MAKH;
    }

    public String getMASACH() {
        return MASACH;
    }

    public void setMASACH(String MASACH) {
        this.MASACH = MASACH;
    }

    public Timestamp getTHOIGIAN() {
        return THOIGIAN;
    }

    public void setTHOIGIAN(Timestamp THOIGIAN) {
        this.THOIGIAN = THOIGIAN;
    }

    public int getTONGTIEN() {
        return TONGTIEN;
    }

    public void setTONGTIEN(int TONGTIEN) {
        this.TONGTIEN = TONGTIEN;
    }

    public int getSOLUONG() {
        return SOLUONG;
    }

    public void setSOLUONG(int SOLUONG) {
        this.SOLUONG = SOLUONG;
    }

    public Object[] toDataRow() {
        return new Object[]{this.MAKH, MASACH, SOLUONG, TONGTIEN, THOIGIAN};
    }
}
