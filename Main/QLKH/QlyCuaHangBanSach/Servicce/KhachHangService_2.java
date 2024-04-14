/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main.QLKH.QlyCuaHangBanSach.Servicce;

import Main.QLKH.QlyCuaHangBanSach.Model.KhachHang_2;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class KhachHangService_2 {

    List<KhachHang_2> ListKH_2;
    Connection con = DBConnect.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public List<KhachHang_2> getLichSuMuaHang(String MAKH) {
        List<KhachHang_2> lichSuMuaHang = new ArrayList<>();
        sql = "SELECT MAKH, MASACH, NGAYLAP,TONGTIEN, SOLUONG FROM hoadon WHERE MAKH = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, MAKH);
            rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang_2 khachHang = new KhachHang_2();
                khachHang.setMAKH(rs.getString("MAKH"));
                khachHang.setMASACH(rs.getString("MASACH"));
                khachHang.setTHOIGIAN(rs.getTimestamp("NGAYLAP"));
                khachHang.setTONGTIEN(rs.getInt("TONGTIEN"));
                khachHang.setSOLUONG(rs.getInt("SOLUONG"));
                lichSuMuaHang.add(khachHang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng ResultSet và PreparedStatement
            // (Bạn có thể chuyển đoạn này vào một phương thức đóng kết nối riêng nếu cần)
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
        return lichSuMuaHang;
    }

}
