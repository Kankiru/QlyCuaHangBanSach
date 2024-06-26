/*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main.Sach.Service;

import Main.Sach.Model.SachModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SachService {

    List<SachModel> ListSach;
    Connection con = DBConnect.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public List<SachModel> getAllSach() {
        ListSach = new ArrayList<>();
        sql = "SELECT * FROM SACH";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                SachModel sach = new SachModel();
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

    public boolean updateSach(SachModel sach) {
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

    public List<SachModel> timKiemSach(String truongTimKiem, String tuKhoa) {
        ListSach = new ArrayList<>();
        sql = "SELECT * FROM SACH WHERE " + truongTimKiem + " LIKE ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + tuKhoa + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                SachModel sach = new SachModel();
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

    public List<SachModel> timKiemSachDonGia(int giaDau, int giaCuoi) {
        ListSach = new ArrayList<>();
        sql = "SELECT * FROM SACH WHERE GIAMUA BETWEEN ? AND ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, giaDau);
            ps.setInt(2, giaCuoi);
            rs = ps.executeQuery();
            while (rs.next()) {
                SachModel sach = new SachModel();
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

    public int layGiamGiaTuMaKhuyenMai(String maKhuyenMai) {
        int giamGia = 0;
        try {
            String sql = "SELECT GIAMGIA FROM KHUYENMAI WHERE MAKM = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maKhuyenMai);
            ResultSet rs = ps.executeQuery();
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
            ps = con.prepareStatement(sql);
            ps.setInt(1, giamGia);
            ps.setString(2, maSach);
            int result = ps.executeUpdate();
            ps.close();

            // Nếu cập nhật giảm giá thành công, thì cập nhật lịch sử giá
            if (result > 0) {
                // Lấy ngày hiện tại
                Timestamp ngayCapNhat = new Timestamp(System.currentTimeMillis());

                // Thêm thông tin lịch sử giá vào bảng LichSuGia
                sql = "INSERT INTO LichSuGia (MASACH, NGAYCAPNHAT, GIABAN) VALUES (?, ?, ?)";
                ps = con.prepareStatement(sql);
                ps.setString(1, maSach);
                ps.setTimestamp(2, ngayCapNhat);
                ps.setInt(3, giamGia); // Giả sử giá bán sau giảm giá là giảm giá
                int resultLSG = ps.executeUpdate();
                ps.close();

                // Trả về kết quả cập nhật lịch sử giá
                return resultLSG > 0;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int tinhTongSoLuongSach() {
        int tongSoLuong = 0;
        for (SachModel sach : ListSach) {
            tongSoLuong += sach.getSoLuong();
        }
        return tongSoLuong;
    }

    public List<String> getMaSachList() {
        List<String> maSachList = new ArrayList<>();
        sql = "SELECT MASACH FROM SACH";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                maSachList.add(rs.getString("MASACH"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return maSachList;
    }

    public List<String> getMaKhuyenMai() {
        List<String> maKhuyenMaiList = new ArrayList<>();
        try {
            String sql = "SELECT MaKM FROM KHUYENMAI";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maKhuyenMai = rs.getString("MaKM");
                maKhuyenMaiList.add(maKhuyenMai);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maKhuyenMaiList;
    }

}
