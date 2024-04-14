package DAO;

import DTO.ChiTietHoaDonDTO;
import connection.jdbcHelper;

import java.sql.*;
import java.util.ArrayList;

public class ChiTietHoaDonDAO {

    Connection conn;

    public ChiTietHoaDonDAO() {
        conn = jdbcHelper.getConnection();
    }

    public ArrayList<ChiTietHoaDonDTO> List() {
        ArrayList<ChiTietHoaDonDTO> CTHD = new ArrayList<>();
        try {
            String sql = "SELECT * FROM HOADONCT";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String maHDCT = rs.getString("MAHDCT");
                String MaHD = rs.getString("MAHD");
                String MaSach = rs.getString("MASACH");
                String TenSach = rs.getString("TENSACH");
                int SoLuong = Integer.parseInt(rs.getString("SOLUONG"));
                int DonGia = Integer.parseInt(rs.getString("GIAMUA"));
                int GiamGia = Integer.parseInt(rs.getString("GIAMGIA"));
                int ThanhTien = Integer.parseInt(rs.getString("THANHTIEN"));
                ChiTietHoaDonDTO ct = new ChiTietHoaDonDTO(maHDCT, MaHD, MaSach, TenSach, SoLuong, DonGia, GiamGia, ThanhTien);
                CTHD.add(ct);
            }
            rs.close();
        } catch (Exception e) {
            System.out.print("ChiTietHoaDonDAO khong tai duoc.");
        }

        return CTHD;
    }

    public ArrayList<ChiTietHoaDonDTO> getListHD(String maHD) {
        ArrayList<ChiTietHoaDonDTO> CTHD = new ArrayList<>();
        try {
            String sql = "SELECT * FROM HOADONCT where MAHD = " + "'" + maHD + "'";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                 String maHDCT = rs.getString("MAHDCT");
                String MaHD = rs.getString("MAHD");
                String MaSach = rs.getString("MASACH");
                String TenSach = rs.getString("TENSACH");
                int SoLuong = Integer.parseInt(rs.getString("SOLUONG"));
                int DonGia = Integer.parseInt(rs.getString("GIAMUA"));
                int GiamGia = Integer.parseInt(rs.getString("GIAMGIA"));
                int ThanhTien = Integer.parseInt(rs.getString("THANHTIEN"));
                ChiTietHoaDonDTO ct = new ChiTietHoaDonDTO(maHDCT, MaHD, MaSach, TenSach, SoLuong, DonGia, GiamGia, ThanhTien);
                CTHD.add(ct);
            }
            rs.close();
        } catch (Exception e) {
            System.out.print("ChiTietHoaDonDAO khong tai duoc.");
        }

        return CTHD;
    }

    public void Them(ChiTietHoaDonDTO ct) {
        String sql = "INSERT INTO HOADONCT([MAHDCT], [MAHD], [MASACH], [TENSACH], [SOLUONG], [GIAMUA], [GIAMGIA], [THANHTIEN]) VALUES ('"
                + "LSG1" + "','"
                + ct.getMaHDCT()+ "','"
                + ct.getMaSach() + "','"
                + ct.getTenSach() + "','"
                + ct.getSoLuong() + "','"
                + ct.getDonGia() + "','"
                + 0 + "','"
                + ct.getThanhTien() + "')";
        try {
            System.out.println("CTHD THEM: " + sql);
            PreparedStatement stmt = conn.prepareStatement(sql);
            int n = stmt.executeUpdate();
        } catch (Exception ex) {
            System.out.print("CTHDDAO khong them duoc.");
        }
        System.out.println(sql);

    }

//    public void deletebyMaSach(String idSach) {
//        try {
//            String sql = "DELETE FROM chitietphieunhap WHERE  MaSach ='" + idSach + "'";
//            PreparedStatement stmt = conn.prepareStatement(sql);
//            int n = stmt.executeUpdate();
//        } catch (Exception e) {
//            System.out.println("Lỗi không thể xóa !!");
//        }
//
//    }

    public void Sua(ChiTietHoaDonDTO ct) {
        try {
            String sql = "UPDATE HOADONCT SET ";
            sql += "MAHD='" + ct.getMahD()+ "',";
            sql += "MASACH='" + ct.getMaSach() + "',";
            sql += "TENSACH='" + ct.getTenSach() + "',";
            sql += "SOLUONG='" + ct.getSoLuong() + "',";
            sql += "GIAMGIA='" + ct.getDonGia() + "',";
            sql += "GIAMGIA='" + ct.getGiamGia() + "',";
            sql += "THANHTIEN='" + ct.getThanhTien() + "'";
            sql += " WHERE MAHD='" + ct.getMahD()+ "' AND MASACH='" + ct.getMaSach() + "'";
            System.out.println(sql);
            PreparedStatement stmt = conn.prepareStatement(sql);
            int n = stmt.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Không update được cthd.");
        }
    }

    public void Xoa(String MaHD) {
        String sql = "DELETE FROM HOADONCT WHERE MAHD='" + MaHD + "'";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            int n = stmt.executeUpdate();
        } catch (Exception ex) {
            System.out.print("Chi tiet HD khong xoa duoc.");
        }
        System.out.println(sql);
    }

    public void XoaMS(String MaSach, String MaHD) {
        String sql = "DELETE FROM HOADONCT WHERE MASACH='" + MaSach + "' AND MAHD='" + MaHD + "'";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            int n = stmt.executeUpdate();
        } catch (Exception ex) {
            System.out.print("Chi tiet HD khong xoa duoc.");
        }
        System.out.println(sql);
    }
}
