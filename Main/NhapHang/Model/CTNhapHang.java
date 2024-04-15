package Main.NhapHang.Model;

import java.util.Date;

public class CTNhapHang {

    private String maPN;
    private String maNV;
    private String maSach;
    private String maNCC;
    private int soLuong;
    private int donGia;
    private Date ngayNhap;
    private int tongTien; // Thêm cột tổng tiền vào class

    public CTNhapHang() {
    }

    public CTNhapHang(String maPN, String maNV, String maSach, String maNCC, int soLuong, int donGia, Date ngayNhap, int tongTien) {
        this.maPN = maPN;
        this.maNV = maNV;
        this.maSach = maSach;
        this.maNCC = maNCC;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.ngayNhap = ngayNhap;
        this.tongTien = tongTien; // Cập nhật giá trị tổng tiền
    }

    public String getMaPN() {
        return maPN;
    }

    public void setMaPN(String maPN) {
        this.maPN = maPN;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public Object[] toDataRow() {
        return new Object[]{maPN, maNV, maSach, maNCC, soLuong, donGia, ngayNhap, tongTien};
    }

}
