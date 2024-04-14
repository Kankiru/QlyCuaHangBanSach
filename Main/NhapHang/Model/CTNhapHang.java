/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main.NhapHang.Model;

/**
 *
 * @author pc
 */
public class CTNhapHang {

    private String maPhieuNhap;
    private String maSach;
    private int soLuong;
    private int donGia;
    private int thanhTien;

    public CTNhapHang() {
    }

    public CTNhapHang(String maPhieuNhap, String maSach, int soLuong, int donGia, int thanhTien) {
        this.maPhieuNhap = maPhieuNhap;
        this.maSach = maSach;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
    }

    public String getMaPhieuNhap() {
        return maPhieuNhap;
    }

    public void setMaPhieuNhap(String maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }

    public Object[] toDataRow() {
        return new Object[]{maPhieuNhap, maSach, soLuong, donGia, thanhTien};
    }
}
