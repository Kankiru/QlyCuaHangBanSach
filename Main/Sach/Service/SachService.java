/*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main.Sach.Service;

import Main.Sach.Model.Sach;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SachService {

    List<Sach> ListSach;
    Connection con = DBConnect.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public List<Sach> getAllSach() {
        ListSach = new ArrayList<>();
        sql = "SELECT * FROM SACH";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Sach sach = new Sach();
                sach.setMaSach(rs.getString("MASACH"));
                sach.setNhaXuatBan(rs.getString("MANXB"));
                sach.setTheLoai(rs.getString("THELOAI"));
                sach.setTacGia(rs.getString("MATG"));
                sach.setTenSach(rs.getString("TENSACH"));
                sach.setNamXuatBan(rs.getInt("NAMXUATBAN"));
                sach.setSoLuong(rs.getInt("SOLUONG"));
                sach.setGiaMua(rs.getInt("GIAMUA"));
                sach.setAnh(rs.getString("ANH"));
                ListSach.add(sach);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ListSach;

    }

    public boolean deleteSach(String maSach) {
        sql = "DELETE FROM SACH WHERE MASACH = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, maSach);
            int result = ps.executeUpdate();
            ps.close();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateSach(Sach sach) {
        sql = "UPDATE SACH SET MANXB = ?, THELOAI = ?, MATG = ?, TENSACH = ?, NAMXUATBAN = ?, SOLUONG = ?, GIAMUA = ?, ANH = ? WHERE MASACH = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, sach.getNhaXuatBan());
            ps.setString(2, sach.getTheLoai());
            ps.setString(3, sach.getTacGia());
            ps.setString(4, sach.getTenSach());
            ps.setInt(5, sach.getNamXuatBan());
            ps.setInt(6, sach.getSoLuong());
            ps.setInt(7, sach.getGiaMua());
            ps.setString(8, sach.getAnh());
            ps.setString(9, sach.getMaSach());
            int result = ps.executeUpdate();
            ps.close();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Sach> timKiemSach(String truongTimKiem, String tuKhoa) {
        ListSach = new ArrayList<>();
        sql = "SELECT * FROM SACH WHERE " + truongTimKiem + " LIKE ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + tuKhoa + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Sach sach = new Sach();
                sach.setMaSach(rs.getString("MASACH"));
                sach.setNhaXuatBan(rs.getString("MANXB"));
                sach.setTheLoai(rs.getString("THELOAI"));
                sach.setTacGia(rs.getString("MATG"));
                sach.setTenSach(rs.getString("TENSACH"));
                sach.setNamXuatBan(rs.getInt("NAMXUATBAN"));
                sach.setSoLuong(rs.getInt("SOLUONG"));
                sach.setGiaMua(rs.getInt("GIAMUA"));
                sach.setAnh(rs.getString("ANH"));
                ListSach.add(sach);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ListSach;
    }

    public List<Sach> timKiemSachDonGia(int giaDau, int giaCuoi) {
        ListSach = new ArrayList<>();
        sql = "SELECT * FROM SACH WHERE GIAMUA BETWEEN ? AND ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, giaDau);
            ps.setInt(2, giaCuoi);
            rs = ps.executeQuery();
            while (rs.next()) {
                Sach sach = new Sach();
                sach.setMaSach(rs.getString("MASACH"));
                sach.setNhaXuatBan(rs.getString("MANXB"));
                sach.setTheLoai(rs.getString("THELOAI"));
                sach.setTacGia(rs.getString("MATG"));
                sach.setTenSach(rs.getString("TENSACH"));
                sach.setNamXuatBan(rs.getInt("NAMXUATBAN"));
                sach.setSoLuong(rs.getInt("SOLUONG"));
                sach.setGiaMua(rs.getInt("GIAMUA"));
                sach.setAnh(rs.getString("ANH"));
                ListSach.add(sach);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ListSach;
    }

    private int layGiamGiaTuMaKhuyenMai(String maKhuyenMai) {
        sql = "SELECT GIAMGIA FROM KHUYENMAI WHERE MAKM = ?";
        int giamGia = 0;
        try {
             ps = con.prepareStatement(sql);
            ps.setString(1, maKhuyenMai);
             rs = ps.executeQuery();
            if (rs.next()) {
                giamGia = rs.getInt("GIAMGIA");
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return giamGia;
    }

    public boolean apDungMaKhuyenMaiChoSach(String maSach, String maKhuyenMai) {
        // Kiểm tra thông tin đầu vào
        if (maSach == null || maKhuyenMai == null || maSach.isEmpty() || maKhuyenMai.isEmpty()) {
            return false;
        }

        // Lấy thông tin giảm giá từ bảng KHUYENMAI
        int giamGia = layGiamGiaTuMaKhuyenMai(maKhuyenMai);

        // Cập nhật đơn giá của sách trong bảng SACH
        sql = "UPDATE SACH SET GIAMUA = GIAMUA - (GIAMUA * ? / 100) WHERE MASACH = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, giamGia);
            ps.setString(2, maSach);
            int result = ps.executeUpdate();
            ps.close();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
