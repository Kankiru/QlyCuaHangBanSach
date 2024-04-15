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

    private String maPhieuNhap;
    private String maNhanVien;
    private String maNCC;
    private int donGia;
    private int soLuong;
    private Date ngayNhap;
    private int thanhTien;

    public NhapHang() {
    }

    public NhapHang(String maPhieuNhap, String maNhanVien, String maNCC, int donGia, int soLuong, Date ngayNhap, int thanhTien) {
        this.maPhieuNhap = maPhieuNhap;
        this.maNhanVien = maNhanVien;
        this.maNCC = maNCC;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.ngayNhap = ngayNhap;
        this.thanhTien = thanhTien;
    }

    public String getMaPhieuNhap() {
        return maPhieuNhap;
    }

    public void setMaPhieuNhap(String maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }

  

    public Object[] toDataRow() {
        return new Object[]{maPhieuNhap, maNhanVien,maNCC,soLuong, donGia,ngayNhap, thanhTien};
    }
}
