/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main.QLKH.QlyCuaHangBanSach.Model;

import java.sql.Date;

public class KhachHang {

 
    private String TENKH;
    private String DIACHI;
    private String EMAIL;
    private String SDT;
    
    private Date NgaySinh;

    public KhachHang() {
    }

    public KhachHang(String TENKH, String DIACHI, String EMAIL, String SDT, Date NgaySinh) {
        this.TENKH = TENKH;
        this.DIACHI = DIACHI;
        this.EMAIL = EMAIL;
        this.SDT = SDT;
        this.NgaySinh = NgaySinh;
    }

   



  

  

    public String getTENKH() {
        return TENKH;
    }

    public void setTENKH(String TENKH) {
        this.TENKH = TENKH;
    }

    public String getDIACHI() {
        return DIACHI;
    }

    public void setDIACHI(String DIACHI) {
        this.DIACHI = DIACHI;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public Object[] toDataRow() {
        return new Object[]{ TENKH, DIACHI, EMAIL, SDT, NgaySinh};
    }
}
