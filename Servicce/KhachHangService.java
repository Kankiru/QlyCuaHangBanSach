/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1.QuanLyKhachHang.Servicce;

import Service.DBConnect;
import duan1.QuanLyKhachHang.Model.KhachHang;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class KhachHangService {

    List<KhachHang> ListKH;
    Connection con = DBConnect.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public List<KhachHang> getAll() {
        ListKH = new ArrayList<>();
        sql = "select * from khachhang";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDate(7));
                ListKH.add(kh);
            }
            return ListKH;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<KhachHang> add(String MAKH, String TENKH, String DIACHI, String Email, String SDT, String TONGCHI, Date NGSINH) {
        sql = "insert into khachhang (MAKH,TENKH, DIACHI, EMAIL, SDT, TongChi, NgaySinh) values (NEWID(),?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, TENKH);
            ps.setString(2, DIACHI);
            ps.setString(3, Email);
            ps.setString(4, SDT);
            ps.setString(5, TONGCHI);
            SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
            String NgSinhStr = SDF.format(NGSINH);
            ps.setString(6, NgSinhStr);
            int add = ps.executeUpdate();
            if (add > 0) {

                KhachHang kh = new KhachHang(MAKH, TENKH, DIACHI, Email, SDT, TONGCHI, NGSINH);
                ListKH.add(kh);
            }
            return ListKH;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<KhachHang> checkEmailExists(String EMAIL) {
        ListKH = new ArrayList<>();
        sql = "select * from khachhang where email =?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, EMAIL);
            rs = ps.executeQuery();
            while (rs.next()) {
                String MAKH = rs.getString("MAKH");
                String TENKH = rs.getString("TENKH");
                String DIACHI = rs.getString("DIACHI");
                String email = rs.getString("EMAIL");
                String SDT = rs.getString("SDT");
                String TongChi = rs.getString("TongChi");
                Date NgaySinh = rs.getDate("NgaySinh");

                KhachHang khachHang = new KhachHang(MAKH, TENKH, DIACHI, email, SDT, TongChi, NgaySinh);
                ListKH.add(khachHang);
            }
            return ListKH;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int count() {
        int count = 0;
        sql = "select count(*) from khachhang ";
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

    public List<KhachHang> Delete(String MAKH) {
        sql = "delete from khachhang where makh = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setObject(1, UUID.fromString(MAKH));
            int i = ps.executeUpdate();
            if (i > 0) {
                ListKH.removeIf(kh -> kh.getMAKH().equals(MAKH));
                
            }
            return ListKH;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
