/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author admin
 */
public class NhaXuatBanDTO {
    private String maNXB,tenNXB,diaChi,Email,SDT;

    public NhaXuatBanDTO() {
    }

    public NhaXuatBanDTO(String maNXB, String tenNXB, String diaChi, String Email, String SDT) {
        this.maNXB = maNXB;
        this.tenNXB = tenNXB;
        this.diaChi = diaChi;
        this.Email = Email;
        this.SDT = SDT;
    }

    public String getMaNXB() {
        return maNXB;
    }

    public void setMaNXB(String maNXB) {
        this.maNXB = maNXB;
    }

    public String getTenNXB() {
        return tenNXB;
    }

    public void setTenNXB(String tenNXB) {
        this.tenNXB = tenNXB;
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

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    @Override
    public String toString() {
        return "NhaXuatBanDTO{" + "maNXB=" + maNXB + ", tenNXB=" + tenNXB + ", diaChi=" + diaChi + ", Email=" + Email + ", SDT=" + SDT + '}';
    }
    
}
