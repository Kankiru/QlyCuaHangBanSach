/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.BanSach1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class BanSach1_Service {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;

    public List<BanSach1> getAll() {
        List<BanSach1> listBs1 = new ArrayList<>();
        sql = "SELECT MAHD,MAKH,MANV,MAGG,NGAYLAP,TONGTIEN,GIAMGIA,THANHTIEN FROM HOADON";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                BanSach1 bs = new BanSach1(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getInt(6), rs.getInt(7), rs.getInt(8));
                listBs1.add(bs);
            }
            return listBs1;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
        

    public int add(BanSach1 b) {
        sql = "INSERT INTO HOADON (MAHD,MAKH,MANV,MAGG,NGAYLAP,TONGTIEN,GIAMGIA,THANHTIEN) values (?,?,?,?,?,?,?,?)";
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
    public int upDate(String ma,BanSach1 b){
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
}