/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model1;

/**
 *
 * @author admin
 */
public class NhapSach {
    private String maPN,maNV,maNCC,ngayNhap;
    private int tongTien;

    public NhapSach(String maPN, String maNV, String maNCC, String ngayNhap, int tongTien) {
        this.maPN = maPN;
        this.maNV = maNV;
        this.maNCC = maNCC;
        this.ngayNhap = ngayNhap;
        this.tongTien = tongTien;
    }

    public NhapSach() {
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
        return "NhapSach1{" + "maPN=" + maPN + ", maNV=" + maNV + ", maNCC=" + maNCC + ", ngayNhap=" + ngayNhap + ", tongTien=" + tongTien + '}';
    }
    public Object[]toDataRow(){
        return new Object[]{
            this.maPN,this.maNV,this.maNCC,this.ngayNhap,this.tongTien
        };
    }
}
