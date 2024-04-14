/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main.NhaCungCap.service;


import Main.NhaCungCap.model.NhaCungCap_2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pc
 */
public class NhaCCService_2 {




    List<NhaCungCap_2> ListSach_B;
    Connection con = DBConnect.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public List<NhaCungCap_2> getAll() {
        ListSach_B = new ArrayList<>();
        try {
            sql = "SELECT s.MASACH, s.TENSACH, s.NAMXUATBAN, s.SOLUONG, s.GIAMUA, s.ANH, nxb.TENNXB AS NHAXUATBAN, tg.TENTG AS TACGIA, tl.THELOAI "
                    + "FROM SACH s "
                    + "JOIN NHAXUATBAN nxb ON s.MANXB = nxb.MANXB "
                    + "JOIN TACGIA tg ON s.MATG = tg.MATG "
                    + "JOIN THELOAI tl ON s.THELOAI = tl.MATL";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                NhaCungCap_2 sach_B = new NhaCungCap_2();
                sach_B.setMaSach(rs.getString("MASACH"));
                sach_B.setTenSach(rs.getString("TENSACH"));
                sach_B.setTheLoai(rs.getString("THELOAI"));
                sach_B.setNamXuatBan(rs.getInt("NAMXUATBAN"));
                sach_B.setSoLuong(rs.getInt("SOLUONG"));
                sach_B.setGiaMua(rs.getInt("GIAMUA"));
                sach_B.setAnh(rs.getString("ANH"));
                sach_B.setNhaXuatBan(rs.getString("NHAXUATBAN"));
                sach_B.setTacGia(rs.getString("TACGIA"));

                ListSach_B.add(sach_B);
            }
            return ListSach_B;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<NhaCungCap_2> searchMaSach(String searchText) {
        ListSach_B = new ArrayList<>();
        sql = "SELECT s.MASACH, s.TENSACH, s.NAMXUATBAN, s.SOLUONG, s.GIAMUA, s.ANH, nxb.TENNXB AS NHAXUATBAN, tg.TENTG AS TACGIA, tl.THELOAI AS THELOAI "
                + "FROM SACH s "
                + "JOIN NHAXUATBAN nxb ON s.MANXB = nxb.MANXB "
                + "JOIN TACGIA tg ON s.MATG = tg.MATG "
                + "JOIN THELOAI tl ON s.THELOAI = tl.MATL "
                + "WHERE s.MASACH LIKE ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, searchText + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
               NhaCungCap_2 sach = new NhaCungCap_2(
                        rs.getString("MASACH"),
                        rs.getString("NHAXUATBAN"),
                        rs.getString("THELOAI"),
                        rs.getString("TACGIA"),
                        rs.getString("TENSACH"),
                        rs.getInt("NAMXUATBAN"),
                        rs.getInt("SOLUONG"),
                        rs.getInt("GIAMUA"),
                        rs.getString("ANH")
                );

                ListSach_B.add(sach);
            }
            return ListSach_B;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int count() {
        int count = 0;
        sql = "select count(*) from sach ";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        return count;
    }

    public List<NhaCungCap_2> searchByNhaXuatBan(String nhaXuatBan) {
        ListSach_B = new ArrayList<>();
        sql = "SELECT s.MASACH, s.TENSACH, s.NAMXUATBAN, s.SOLUONG, s.GIAMUA, s.ANH, nxb.TENNXB AS NHAXUATBAN, tg.TENTG AS TACGIA, tl.THELOAI "
                + "FROM SACH s "
                + "JOIN NHAXUATBAN nxb ON s.MANXB = nxb.MANXB "
                + "JOIN TACGIA tg ON s.MATG = tg.MATG "
                + "JOIN THELOAI tl ON s.THELOAI = tl.MATL "
                + "WHERE nxb.TENNXB LIKE ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + nhaXuatBan + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                NhaCungCap_2 sach = new NhaCungCap_2(
                        rs.getString("MASACH"),
                        rs.getString("NHAXUATBAN"),
                        rs.getString("THELOAI"),
                        rs.getString("TACGIA"),
                        rs.getString("TENSACH"),
                        rs.getInt("NAMXUATBAN"),
                        rs.getInt("SOLUONG"),
                        rs.getInt("GIAMUA"),
                        rs.getString("ANH")
                );

                ListSach_B.add(sach);
            }
            return ListSach_B;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<NhaCungCap_2> searchByTheLoai(String theLoai) {
        ListSach_B = new ArrayList<>();
        sql = "SELECT s.MASACH, s.TENSACH, s.NAMXUATBAN, s.SOLUONG, s.GIAMUA, s.ANH, nxb.TENNXB AS NHAXUATBAN, tg.TENTG AS TACGIA, tl.THELOAI "
                + "FROM SACH s "
                + "JOIN NHAXUATBAN nxb ON s.MANXB = nxb.MANXB "
                + "JOIN TACGIA tg ON s.MATG = tg.MATG "
                + "JOIN THELOAI tl ON s.THELOAI = tl.MATL "
                + "WHERE tl.THELOAI LIKE ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + theLoai + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
               NhaCungCap_2 sach = new NhaCungCap_2(
                        rs.getString("MASACH"),
                        rs.getString("NHAXUATBAN"),
                        rs.getString("THELOAI"),
                        rs.getString("TACGIA"),
                        rs.getString("TENSACH"),
                        rs.getInt("NAMXUATBAN"),
                        rs.getInt("SOLUONG"),
                        rs.getInt("GIAMUA"),
                        rs.getString("ANH")
                );
                ListSach_B.add(sach);
            }
            return ListSach_B;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Thêm phương thức lọc theo Tác Giả
    public List<NhaCungCap_2> searchByTacGia(String tacGia) {
        ListSach_B = new ArrayList<>();
        sql = "SELECT s.MASACH, s.TENSACH, s.NAMXUATBAN, s.SOLUONG, s.GIAMUA, s.ANH, nxb.TENNXB AS NHAXUATBAN, tg.TENTG AS TACGIA, tl.THELOAI "
                + "FROM SACH s "
                + "JOIN NHAXUATBAN nxb ON s.MANXB = nxb.MANXB "
                + "JOIN TACGIA tg ON s.MATG = tg.MATG "
                + "JOIN THELOAI tl ON s.THELOAI = tl.MATL "
                + "WHERE tg.TENTG LIKE ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + tacGia + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
               NhaCungCap_2 sach = new NhaCungCap_2(
                        rs.getString("MASACH"),
                        rs.getString("NHAXUATBAN"),
                        rs.getString("THELOAI"),
                        rs.getString("TACGIA"),
                        rs.getString("TENSACH"),
                        rs.getInt("NAMXUATBAN"),
                        rs.getInt("SOLUONG"),
                        rs.getInt("GIAMUA"),
                        rs.getString("ANH")
                );
                ListSach_B.add(sach);
            }
            return ListSach_B;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<NhaCungCap_2> searchByTenSach(String tenSach) {
        ListSach_B = new ArrayList<>();
        sql = "SELECT s.MASACH, s.TENSACH, s.NAMXUATBAN, s.SOLUONG, s.GIAMUA, s.ANH, nxb.TENNXB AS NHAXUATBAN, tg.TENTG AS TACGIA, tl.THELOAI "
                + "FROM SACH s "
                + "JOIN NHAXUATBAN nxb ON s.MANXB = nxb.MANXB "
                + "JOIN TACGIA tg ON s.MATG = tg.MATG "
                + "JOIN THELOAI tl ON s.THELOAI = tl.MATL "
                + "WHERE s.TENSACH LIKE ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + tenSach + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                NhaCungCap_2 sach = new NhaCungCap_2(
                        rs.getString("MASACH"),
                        rs.getString("NHAXUATBAN"),
                        rs.getString("THELOAI"),
                        rs.getString("TACGIA"),
                        rs.getString("TENSACH"),
                        rs.getInt("NAMXUATBAN"),
                        rs.getInt("SOLUONG"),
                        rs.getInt("GIAMUA"),
                        rs.getString("ANH")
                );
                ListSach_B.add(sach);
            }
            return ListSach_B;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<NhaCungCap_2> searchByGia(int giaMin, int giaMax) {
        ListSach_B = new ArrayList<>();
        sql = "SELECT s.MASACH, s.TENSACH, s.NAMXUATBAN, s.SOLUONG, s.GIAMUA, s.ANH, nxb.TENNXB AS NHAXUATBAN, tg.TENTG AS TACGIA, tl.THELOAI "
                + "FROM SACH s "
                + "JOIN NHAXUATBAN nxb ON s.MANXB = nxb.MANXB "
                + "JOIN TACGIA tg ON s.MATG = tg.MATG "
                + "JOIN THELOAI tl ON s.THELOAI = tl.MATL "
                + "WHERE s.GIAMUA BETWEEN ? AND ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, giaMin);
            ps.setInt(2, giaMax);
            rs = ps.executeQuery();
            while (rs.next()) {
                NhaCungCap_2 sach = new NhaCungCap_2(
                        rs.getString("MASACH"),
                        rs.getString("NHAXUATBAN"),
                        rs.getString("THELOAI"),
                        rs.getString("TACGIA"),
                        rs.getString("TENSACH"),
                        rs.getInt("NAMXUATBAN"),
                        rs.getInt("SOLUONG"),
                        rs.getInt("GIAMUA"),
                        rs.getString("ANH")
                );
                ListSach_B.add(sach);
            }
            return ListSach_B;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


}
