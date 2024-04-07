
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class NhanVien_Model {

    private String maNhanVien;
    private String Ten;
    private String Email;
    private String soDienThoai;
    private String gioiTinh;
    private Date ngaySinh;
    private String taiKhoan;
    private String matKhau;
    private String roles;

    public NhanVien_Model() {
    }

    public NhanVien_Model(String maNhanVien, String Email, String taiKhoan, String matKhau, String roles) {
        this.maNhanVien = maNhanVien;
        this.Email = Email;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.roles = roles;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public NhanVien_Model(String maNhanVien, String Ten, String Email, String soDienThoai, String gioiTinh, Date ngaySinh) {
        this.maNhanVien = maNhanVien;
        this.Ten = Ten;
        this.Email = Email;
        this.soDienThoai = soDienThoai;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public Object[] getDataRow() {
        return new Object[]{this.maNhanVien, this.Ten, this.gioiTinh, this.Email, this.soDienThoai, this.ngaySinh};
    }

    public Object[] getDataRow2() {
        return new Object[]{this.maNhanVien, this.Email, this.taiKhoan, this.matKhau, this.roles};
    }
}
