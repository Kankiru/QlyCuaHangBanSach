/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author admin
 */
public class HoaDonDTO {
    private String maHD,maKH,idNV,ngayLap,maKM;
    private int tongTien,giamGia,thanhTien;

    public HoaDonDTO() {
    }

    public HoaDonDTO(String maHD, String maKH, String idNV, String ngayLap, String maKM, int tongTien, int giamGia, int thanhTien) {
        this.maHD = maHD;
        this.maKH = maKH;
        this.idNV = idNV;
        this.ngayLap = ngayLap;
        this.maKM = maKM;
        this.tongTien = tongTien;
        this.giamGia = giamGia;
        this.thanhTien = thanhTien;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getIdNV() {
        return idNV;
    }

    public void setIdNV(String idNV) {
        this.idNV = idNV;
    }

    public String getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }

    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
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
        return "HoaDonDTO{" + "maHD=" + maHD + ", maKH=" + maKH + ", idNV=" + idNV + ", ngayLap=" + ngayLap + ", maKM=" + maKM + ", tongTien=" + tongTien + ", giamGia=" + giamGia + ", thanhTien=" + thanhTien + '}';
    }
public Object[]toDataRow(){
    return new Object[]{
        this.maHD,this.maKH,this.idNV,this.ngayLap,this.maKM,this.tongTien,this.giamGia,this.thanhTien
    };
}

    
}
