/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service1;

import Model1.HoaDon;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class HoaDon_Service {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;

    public List<HoaDon> getAll() {
        List<HoaDon> listBs1 = new ArrayList<>();
        sql = "SELECT MAHD,MAKH,MANV,MAGG,NGAYLAP,TONGTIEN,GIAMGIA,THANHTIEN FROM HOADON";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon bs = new HoaDon(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getInt(6), rs.getInt(7), rs.getInt(8));
                listBs1.add(bs);
            }
            return listBs1;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int add(HoaDon b) {
        sql = "INSERT INTO HOADON (MAHD,MAKH,MANV,MAGG,NGAYLAP,TONGTIEN,THANHTIEN,GIAMGIA) values (?,?,?,?,?,?,?,?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, b.getMaHd());
            ps.setObject(2, b.getMaKh());
            ps.setObject(3, b.getMaNV());
            ps.setObject(4, b.getMaGg());
            ps.setObject(5, b.getNgayLap());
            ps.setObject(6, b.getTongTien());
            ps.setObject(7, b.getGiamGia());
            ps.setObject(8, b.getThanhTien());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int delete(String ma) {
        sql = "DELETE FROM HOADON WHERE MAHD LIKE ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }

    public int upDate(String ma, HoaDon b) {
        sql = "update HOADON set MAKH = ?,MANV = ?,MAGG = ?,NGAYLAP = ?,TONGTIEN = ?,GIAMGIA = ?,THANHTIEN = ? WHERE MAHD LIKE ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, b.getMaKh());
            ps.setObject(2, b.getMaNV());
            ps.setObject(3, b.getMaGg());
            ps.setObject(4, b.getNgayLap());
            ps.setObject(5, b.getTongTien());
            ps.setObject(6, b.getGiamGia());
            ps.setObject(7, b.getThanhTien());
            ps.setObject(8, ma);
            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
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
    
    public List<HoaDon> timkiemMHD(String maHD){
        try {
            List<HoaDon> ListH = new ArrayList<>();
            sql = "select * from HOADON where MAHD like ?";
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, "%" + maHD + "%");
            rs = ps.executeQuery();
             while (rs.next()) {
                HoaDon bs = new HoaDon(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getInt(6), rs.getInt(7), rs.getInt(8));
                ListH.add(bs);
            }
             return ListH;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<HoaDon> timkiemMKH(String maKH){
        try {
            List<HoaDon> ListH = new ArrayList<>();
            sql = "select * from HOADON where MAKH like ?";
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, "%" + maKH + "%");
            rs = ps.executeQuery();
             while (rs.next()) {
                HoaDon bs = new HoaDon(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getInt(6), rs.getInt(7), rs.getInt(8));
                ListH.add(bs);
            }
             return ListH;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
     public List<HoaDon> timkiemMNV(String maNV){
        try {
            List<HoaDon> ListH = new ArrayList<>();
            sql = "select * from HOADON where MANV like ?";
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, "%" + maNV + "%");
            rs = ps.executeQuery();
             while (rs.next()) {
                HoaDon bs = new HoaDon(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getInt(6), rs.getInt(7), rs.getInt(8));
                ListH.add(bs);
            }
             return ListH;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
