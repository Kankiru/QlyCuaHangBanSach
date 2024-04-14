/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main.NhanVien.NhanVien.model;

/**
 *
 * @author Admin
 */
public class TaiKhoan_Model {

    private String maNhanVien;
    private String Username;
    private String password;

    public TaiKhoan_Model() {
    }

    public TaiKhoan_Model(String maNhanVien, String Username, String password) {
        this.maNhanVien = maNhanVien;
        this.Username = Username;
        this.password = password;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Object[] getDataRow() {
        return new Object[]{this.maNhanVien, this.Username, this.password};
    }

}
