/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author admin
 */
public class TheLoaiDTO {
    private String maTL,tenTL;

    public TheLoaiDTO() {
    }

    public TheLoaiDTO(String maTL, String tenTL) {
        this.maTL = maTL;
        this.tenTL = tenTL;
    }

    public String getMaTL() {
        return maTL;
    }

    public void setMaTL(String maTL) {
        this.maTL = maTL;
    }

    public String getTenTL() {
        return tenTL;
    }

    public void setTenTL(String tenTL) {
        this.tenTL = tenTL;
    }

    @Override
    public String toString() {
        return "TheLoaiDTO{" + "maTL=" + maTL + ", tenTL=" + tenTL + '}';
    }
    
}
