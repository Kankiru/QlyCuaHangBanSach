/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author admin
 */
public class ChiTietChuongTrinhGiamGiaDTO {
    private String maKM,maSach;

    public ChiTietChuongTrinhGiamGiaDTO() {
    }

    public ChiTietChuongTrinhGiamGiaDTO(String maKM, String maSach) {
        this.maKM = maKM;
        this.maSach = maSach;
    }

    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    @Override
    public String toString() {
        return "ChiTietChuongTrinhGiamGiaDTO{" + "maKM=" + maKM + ", maSach=" + maSach + '}';
    }
    
}
