/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main.Sach.Model;

/**
 *
 * @author pc
 */
public class NhaXuatBan {

    private String MaNXB, TenNXB;

    public NhaXuatBan() {
    }

    public NhaXuatBan(String MaNXB, String TenNXB) {
        this.MaNXB = MaNXB;
        this.TenNXB = TenNXB;
    }

    public String getMaNXB() {
        return MaNXB;
    }

    public void setMaNXB(String MaNXB) {
        this.MaNXB = MaNXB;
    }

    public String getTenNXB() {
        return TenNXB;
    }

    public void setTenNXB(String TenNXB) {
        this.TenNXB = TenNXB;
    }

    public Object[] toDataRow() {
        return new Object[]{MaNXB, TenNXB};
    }
}
