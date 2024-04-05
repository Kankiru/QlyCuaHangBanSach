/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model1;

/**
 *
 * @author admin
 */
public class CTNhapSach {
    private String maCTPN,maPN,maSach;
    private int soLuong,donGia,thanhTien;

    public CTNhapSach() {
    }

    public CTNhapSach(String maCTPN, String maPN, String maSach, int soLuong, int donGia, int thanhTien) {
        this.maCTPN = maCTPN;
        this.maPN = maPN;
        this.maSach = maSach;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
    }

    public String getMaCTPN() {
        return maCTPN;
    }

    public void setMaCTPN(String maCTPN) {
        this.maCTPN = maCTPN;
    }

    public String getMaPN() {
        return maPN;
    }

    public void setMaPN(String maPN) {
        this.maPN = maPN;
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

    @Override
    public String toString() {
        return "NhapSach2{" + "maCTPN=" + maCTPN + ", maPN=" + maPN + ", maSach=" + maSach + ", soLuong=" + soLuong + ", donGia=" + donGia + ", thanhTien=" + thanhTien + '}';
    }
    public Object[]toDataRow(){
        return new Object[]{
            this.maCTPN,this.maPN,this.maSach,this.soLuong,this.donGia,this.thanhTien
        };
    }
}
