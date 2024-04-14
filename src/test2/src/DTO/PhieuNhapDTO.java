/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author admin
 */
public class PhieuNhapDTO {
    private String maPN,maNV,maNCC;
    
    private String ngayNhap;
    private int tongTien;

    public PhieuNhapDTO() {
    }

    public PhieuNhapDTO(String maPN, String maNV,  String maNCC,  String ngayNhap, int tongTien) {
        this.maPN = maPN;
        this.maNV = maNV;
        
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

    
    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    
    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    @Override
    public String toString() {
        return "PhieuNhapDTO{" + "maPN=" + maPN + ", maNV=" + maNV + ",   ngayNhap=" + ngayNhap + ", tongTien=" + tongTien + '}';
    }
    
}
