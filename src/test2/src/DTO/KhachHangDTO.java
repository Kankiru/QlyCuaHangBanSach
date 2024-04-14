/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author admin
 */
public class KhachHangDTO {
    private String maKH,tenKH,diaChi,Email,sdt,ngaySinh;

    public KhachHangDTO() {
    }

    public KhachHangDTO(String maKH, String tenKH, String diaChi, String Email, String sdt, String ngaySinh) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.diaChi = diaChi;
        this.Email = Email;
        this.sdt = sdt;
        this.ngaySinh = ngaySinh;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    @Override
    public String toString() {
        return "KhachHangDTO{" + "maKH=" + maKH + ", tenKH=" + tenKH + ", diaChi=" + diaChi + ", Email=" + Email + ", sdt=" + sdt + ", ngaySinh=" + ngaySinh + '}';
    }
    public Object[]toDataRow(){
    return new Object[]{
    this.maKH,this.tenKH,this.diaChi,this.Email,this.sdt,this.ngaySinh
    };
    }
    
}
