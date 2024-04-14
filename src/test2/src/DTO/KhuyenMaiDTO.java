/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author admin
 */
public class KhuyenMaiDTO {
    private String maKM,tenKM,ngayDB,ngayKT;
    private int giamGia;
    private String trangThai;

    public KhuyenMaiDTO() {
    }

    public KhuyenMaiDTO(String maKM, String tenKM, String ngayDB, String ngayKT, int giamGia, String trangThai) {
        this.maKM = maKM;
        this.tenKM = tenKM;
        this.ngayDB = ngayDB;
        this.ngayKT = ngayKT;
        this.giamGia = giamGia;
        this.trangThai = trangThai;
    }

    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

    public String getTenKM() {
        return tenKM;
    }

    public void setTenKM(String tenKM) {
        this.tenKM = tenKM;
    }

    public String getNgayDB() {
        return ngayDB;
    }

    public void setNgayDB(String ngayDB) {
        this.ngayDB = ngayDB;
    }

    public String getNgayKT() {
        return ngayKT;
    }

    public void setNgayKT(String ngayKT) {
        this.ngayKT = ngayKT;
    }

    public int getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(int giamGia) {
        this.giamGia = giamGia;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "KhuyenMaiDTO{" + "maKM=" + maKM + ", tenKM=" + tenKM + ", ngayDB=" + ngayDB + ", ngayKT=" + ngayKT + ", giamGia=" + giamGia + ", trangThai=" + trangThai + '}';
    }
    
}
