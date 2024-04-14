/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main.NhapHang.Model;

import java.util.Date;

/**
 *
 * @author pc
 */
public class NhapHang {

    private String maPN;
    private String maNV;
    private String maSach;
    private String maNCC;

    private Date ngayNhap;
    private int tongTien;

    public NhapHang() {
    }

    public NhapHang(String maPN, String maNV, String maSach, String maNCC, Date ngayNhap, int tongTien) {
        this.maPN = maPN;
        this.maNV = maNV;
        this.maSach = maSach;
        this.maNCC = maNCC;

        this.ngayNhap = ngayNhap;
        this.tongTien = tongTien;
    }

    public String getMaPN() {
        return maPN;
    }

    public void setMaPN(String maPN) {
        this.maPN = maPN;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public Object[] toDataRow() {
        return new Object[]{maPN, maNV, maSach, maNCC, ngayNhap, tongTien};
    }
}
