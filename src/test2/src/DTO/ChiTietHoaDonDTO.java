/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author admin
 */
public class ChiTietHoaDonDTO {
    private String maHDCT,mahD,maSach,tenSach;
    private int soLuong,donGia,giamGia,thanhTien;

    public ChiTietHoaDonDTO(String lsG1, String text, String text1, String text2, int s, float gia, float giamgia, float thanhtien) {
    }

    public ChiTietHoaDonDTO(String maHDCT, String mahD, String maSach, String tenSach, int soLuong, int donGia, int giamGia, int thanhTien) {
        this.maHDCT = maHDCT;
        this.mahD = mahD;
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.giamGia = giamGia;
        this.thanhTien = thanhTien;
    }

    public String getMaHDCT() {
        return maHDCT;
    }

    public void setMaHDCT(String maHDCT) {
        this.maHDCT = maHDCT;
    }

    public String getMahD() {
        return mahD;
    }

    public void setMahD(String mahD) {
        this.mahD = mahD;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
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

    public int getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(int giamGia) {
        this.giamGia = giamGia;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }

    @Override
    public String toString() {
        return "ChiTietHoaDonDTO{" + "maHDCT=" + maHDCT + ", mahD=" + mahD + ", maSach=" + maSach + ", tenSach=" + tenSach + ", soLuong=" + soLuong + ", donGia=" + donGia + ", giamGia=" + giamGia + ", thanhTien=" + thanhTien + '}';
    }

    
    
}
