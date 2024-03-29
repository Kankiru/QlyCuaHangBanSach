/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author admin
 */
public class BanSach1 {
    private String maHd,maKh,maNV,maGg,ngayLap;
    private int tongTien,giamGia,thanhTien;

    public BanSach1() {
    }

    public BanSach1(String maHd, String maKh, String maNV, String maGg, String ngayLap, int tongTien, int giamGia, int thanhTien) {
        this.maHd = maHd;
        this.maKh = maKh;
        this.maNV = maNV;
        this.maGg = maGg;
        this.ngayLap = ngayLap;
        this.tongTien = tongTien;
        this.giamGia = giamGia;
        this.thanhTien = thanhTien;
    }

    public String getMaHd() {
        return maHd;
    }

    public void setMaHd(String maHd) {
        this.maHd = maHd;
    }

    public String getMaKh() {
        return maKh;
    }

    public void setMaKh(String maKh) {
        this.maKh = maKh;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaGg() {
        return maGg;
    }

    public void setMaGg(String maGg) {
        this.maGg = maGg;
    }

    public String getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
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
        return "BanSach1{" + "maHd=" + maHd + ", maKh=" + maKh + ", maNV=" + maNV + ", maGg=" + maGg + ", ngayLap=" + ngayLap + ", tongTien=" + tongTien + ", giamGia=" + giamGia + ", thanhTien=" + thanhTien + '}';
    }

    
    

    
    
    public Object[] toDataRow(){
        return new Object[]{
            this.maHd,
            this.maKh,this.maNV,
            this.maGg,this.ngayLap,this.tongTien,this.giamGia,this.thanhTien
        };
}
}
