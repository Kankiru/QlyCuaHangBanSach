/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author admin
 */
public class BanSach2 {
    private String maHd,maSach,tenSach,soLuong;
    private int giaMua,giamGia,thanhTien;

    public BanSach2() {
    }

    public BanSach2(String maHd, String maSach, String tenSach, String soLuong, int giaMua, int giamGia, int thanhTien) {
        this.maHd = maHd;
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.soLuong = soLuong;
        this.giaMua = giaMua;
        this.giamGia = giamGia;
        this.thanhTien = thanhTien;
    }

    public BanSach2(String maHd, String soLuong, int thanhTien) {
        this.maHd = maHd;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
    }
    

    public String getMaHd() {
        return maHd;
    }

    public void setMaHd(String maHd) {
        this.maHd = maHd;
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

    public String getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }

    public int getGiaMua() {
        return giaMua;
    }

    public void setGiaMua(int giaMua) {
        this.giaMua = giaMua;
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
        return "BanSach2{" + "maHd=" + maHd + ", maSach=" + maSach + ", tenSach=" + tenSach + ", soLuong=" + soLuong + ", giaMua=" + giaMua + ", giamGia=" + giamGia + ", thanhTien=" + thanhTien + '}';
    }
    public Object[]toDataRow(){
    return new Object[]{
    this.maHd,this.maSach,this.tenSach,this.soLuong,
        this.giaMua,this.giamGia,this.thanhTien
    };
    }
}
