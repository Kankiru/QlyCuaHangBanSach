/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author admin
 */
public class QlySach {
    private String maSach,maNxb,theLoai,maTg,tenSach,namXuatBan;
    private int soLuong,giaMua;
    private String anh;

    public QlySach() {
    }

    public QlySach(String maSach, String maNxb, String theLoai, String maTg, String tenSach, String namXuatBan, int soLuong, int giaMua, String anh) {
        this.maSach = maSach;
        this.maNxb = maNxb;
        this.theLoai = theLoai;
        this.maTg = maTg;
        this.tenSach = tenSach;
        this.namXuatBan = namXuatBan;
        this.soLuong = soLuong;
        this.giaMua = giaMua;
        this.anh = anh;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getMaNxb() {
        return maNxb;
    }

    public void setMaNxb(String maNxb) {
        this.maNxb = maNxb;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public String getMaTg() {
        return maTg;
    }

    public void setMaTg(String maTg) {
        this.maTg = maTg;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getNamXuatBan() {
        return namXuatBan;
    }

    public void setNamXuatBan(String namXuatBan) {
        this.namXuatBan = namXuatBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getGiaMua() {
        return giaMua;
    }

    public void setGiaMua(int giaMua) {
        this.giaMua = giaMua;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    @Override
    public String toString() {
        return "QlySach{" + "maSach=" + maSach + ", maNxb=" + maNxb + ", theLoai=" + theLoai + ", maTg=" + maTg + ", tenSach=" + tenSach + ", namXuatBan=" + namXuatBan + ", soLuong=" + soLuong + ", giaMua=" + giaMua + ", anh=" + anh + '}';
    }

    
   
    public Object[] toDataRow(){
        return new Object[]{
            this.maSach,
            this.maNxb,
            this.theLoai,
            this.maTg,
            this.tenSach,
            this.namXuatBan,
            this.soLuong,
            this.giaMua,
            this.anh
        };
    }
            
}
