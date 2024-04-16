/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main.Sach.Model;

/**
 *
 * @author pc
 */
public class Sach {

    private String MaSach;
    private String NhaXuatBan;
    private String TheLoai;
    private String TacGia;
    private String TenSach;
    private int NamXuatBan;
    private int SoLuong;
    private int GiaMua;
    private String Anh;

    public Sach() {
    }

    public Sach(String MaSach, String NhaXuatBan, String TheLoai, String TacGia, String TenSach, int NamXuatBan, int SoLuong, int GiaMua, String Anh) {
        this.MaSach = MaSach;
        this.NhaXuatBan = NhaXuatBan;
        this.TheLoai = TheLoai;
        this.TacGia = TacGia;
        this.TenSach = TenSach;
        this.NamXuatBan = NamXuatBan;
        this.SoLuong = SoLuong;
        this.GiaMua = GiaMua;
        this.Anh = Anh;
    }

    public String getMaSach() {
        return MaSach;
    }

    public void setMaSach(String MaSach) {
        this.MaSach = MaSach;
    }

    public String getNhaXuatBan() {
        return NhaXuatBan;
    }

    public void setNhaXuatBan(String NhaXuatBan) {
        this.NhaXuatBan = NhaXuatBan;
    }

    public String getTheLoai() {
        return TheLoai;
    }

    public void setTheLoai(String TheLoai) {
        this.TheLoai = TheLoai;
    }

    public String getTacGia() {
        return TacGia;
    }

    public void setTacGia(String TacGia) {
        this.TacGia = TacGia;
    }

    public String getTenSach() {
        return TenSach;
    }

    public void setTenSach(String TenSach) {
        this.TenSach = TenSach;
    }

    public int getNamXuatBan() {
        return NamXuatBan;
    }

    public void setNamXuatBan(int NamXuatBan) {
        this.NamXuatBan = NamXuatBan;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public int getGiaMua() {
        return GiaMua;
    }

    public void setGiaMua(int GiaMua) {
        this.GiaMua = GiaMua;
    }

    public String getAnh() {
        return Anh;
    }

    public void setAnh(String Anh) {
        this.Anh = Anh;
    }

    public Object[] toDataRow() {
        return new Object[]{this.MaSach,
            this.NhaXuatBan,
            this.TheLoai,
            this.TacGia,
            this.TenSach,
            this.NamXuatBan,
            this.SoLuong,
            this.GiaMua,
            this.Anh};
    }

    public Object getNgayCapNhat() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object getGiaBan() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
