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
public class NhapSach {

    private String maPhieuNhap;
    private String maNhanVien;
    private String maNCC;
   
    private Date ngayNhap;
   

    public NhapSach() {
    }

    public NhapSach(String maPhieuNhap, String maNhanVien, String maNCC, Date ngayNhap) {
        this.maPhieuNhap = maPhieuNhap;
        this.maNhanVien = maNhanVien;
        this.maNCC = maNCC;
        this.ngayNhap = ngayNhap;
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

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

  

    public Object[] toDataRow() {
        return new Object[]{maPhieuNhap, maNhanVien,maNCC,ngayNhap};
    }
}
