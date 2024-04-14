package Main.HoaDon.Model;

import java.sql.Timestamp;

public class HoaDon {
    private String maHoaDon;
    private String maKhachHang;
    private String maNhanVien;
    private String maSach;
    private int soLuong;
    private Timestamp ngayLap;
    private int tongTien;

    private int thanhTien;

    // Constructors
    public HoaDon() {
    }

    public HoaDon(String maHoaDon, String maKhachHang, String maNhanVien, String maSach, int soLuong, Timestamp ngayLap, int tongTien, int thanhTien) {
        this.maHoaDon = maHoaDon;
        this.maKhachHang = maKhachHang;
        this.maNhanVien = maNhanVien;
        this.maSach = maSach;
        this.soLuong = soLuong;
        this.ngayLap = ngayLap;
        this.tongTien = tongTien;

        this.thanhTien = thanhTien;
    }

    // Getters and Setters
    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Timestamp getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(Timestamp ngayLap) {
        this.ngayLap = ngayLap;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }


    public int getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }
  public Object[] toDataRow() {
    return new Object[] { 
        maHoaDon, 
        maKhachHang, 
        maNhanVien, 
        maSach, 
        soLuong, 
        ngayLap, 
        tongTien, 
        thanhTien 
    };
}

}
