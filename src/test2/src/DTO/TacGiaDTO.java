/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author admin
 */
public class TacGiaDTO {
    private String maTG,tenTG,diaChi,Sdt;

    public TacGiaDTO() {
    }

    public TacGiaDTO(String maTG, String tenTG, String diaChi, String Sdt) {
        this.maTG = maTG;
        this.tenTG = tenTG;
        this.diaChi = diaChi;
        this.Sdt = Sdt;
    }

    public String getMaTG() {
        return maTG;
    }

    public void setMaTG(String maTG) {
        this.maTG = maTG;
    }

    public String getTenTG() {
        return tenTG;
    }

    public void setTenTG(String tenTG) {
        this.tenTG = tenTG;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String Sdt) {
        this.Sdt = Sdt;
    }

    @Override
    public String toString() {
        return "TacGiaDTO{" + "maTG=" + maTG + ", tenTG=" + tenTG + ", diaChi=" + diaChi + ", Sdt=" + Sdt + '}';
    }
    
}
