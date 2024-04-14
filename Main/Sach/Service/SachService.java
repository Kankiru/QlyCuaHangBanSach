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

}
