/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main.NhapHang.Service;

import Main.NhapHang.Model.CTNhapHang;
import Main.NhapHang.Model.NhapHang;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NhapHangService {

    List<NhapHang> ListNH;
    List<CTNhapHang> ListctNH;
    Connection con = DBConnect.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public List<NhapHang> getAllPhieuNhap() {
        ListNH = new ArrayList<>();
        sql = "SELECT * FROM PHIEUNHAP";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                NhapHang nhapHang = new NhapHang();
                nhapHang.setMaPN(rs.getString("MAPN"));
                nhapHang.setMaNV(rs.getString("MANV"));
                nhapHang.setMaNCC(rs.getString("MANCC"));
                nhapHang.setMaSach(rs.getString("MASACH"));
                nhapHang.setNgayNhap(rs.getTimestamp("NGAYNHAP"));
                nhapHang.setTongTien(rs.getInt("TONGTIEN"));
                ListNH.add(nhapHang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }

        return ListNH;

    }

}
