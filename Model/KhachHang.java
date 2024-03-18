/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1.QuanLyKhachHang.Model;

import java.sql.Date;

public class KhachHang {

    private String MAKH;
    private String TENKH;
    private String DIACHI;
    private String EMAIL;
    private String SDT;
    private String TongChi;
    private Date NgaySinh;

    public KhachHang() {
    }

    public KhachHang(String TENKH, String DIACHI, String EMAIL, String SDT, String TongChi, Date NgaySinh) {
        this.TENKH = TENKH;
        this.DIACHI = DIACHI;
        this.EMAIL = EMAIL;
        this.SDT = SDT;
        this.TongChi = TongChi;
        this.NgaySinh = NgaySinh;
    }

   public KhachHang(String MAKH, String TENKH, String DIACHI, String Email, String SDT, String TONGCHI, Date NGSINH) {
    this.MAKH = MAKH;
    this.TENKH = TENKH;
    this.DIACHI = DIACHI;
    this.EMAIL = Email;
    this.SDT = SDT;
    this.TongChi = TONGCHI;
    this.NgaySinh = NGSINH;
}

  

    public String getMAKH() {
        return MAKH;
    }

    public void setMAKH(String MAKH) {
        this.MAKH = MAKH;
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

    public String getTongChi() {
        return TongChi;
    }

    public void setTongChi(String TongChi) {
        this.TongChi = TongChi;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public Object[] toDataRow() {
        return new Object[]{MAKH, TENKH, DIACHI, EMAIL, SDT, TongChi, NgaySinh};
    }
}
