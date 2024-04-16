package Main.HoaDon.Model;

public class HoaDonChiTiet {

    private String maSach;
    private String tenSach;
    private int soLuong;
    private int donGia;
    private int thanhTien;

    public HoaDonChiTiet() {
        // Khởi tạo đối tượng HoaDonChiTiet
    }

    public HoaDonChiTiet(String maSach, String tenSach, int soLuong, int donGia, int thanhTien) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
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

    public int getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }

    public Object[] toDataRow() {
        return new Object[]{maSach, tenSach, soLuong, donGia, thanhTien};
    }

}
