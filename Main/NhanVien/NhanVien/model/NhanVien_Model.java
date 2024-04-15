package Main.NhanVien.NhanVien.model;

import java.util.Date;

public class NhanVien_Model {

    private String maNhanVien;
    private String ten;
    private String gioiTinh;
    private Date ngaySinh;
    private String email;
    private String soDienThoai;
    private String taiKhoan;
    private String matKhau;

    public NhanVien_Model() {
    }

    public NhanVien_Model(String maNhanVien, String ten, String gioiTinh, Date ngaySinh, String email, String soDienThoai, String taiKhoan, String matKhau) {
        this.maNhanVien = maNhanVien;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public Object[] getDataRow() {
        return new Object[]{this.maNhanVien, this.ten, this.email, this.soDienThoai, this.gioiTinh, this.ngaySinh, taiKhoan, matKhau};

    }
}
