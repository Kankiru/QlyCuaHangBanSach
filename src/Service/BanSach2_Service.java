/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.BanSach2;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author admin
 */
public class BanSach2_Service {
     private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;
    
    public List<BanSach2> getAll2() {
        List<BanSach2> listBs2 = new ArrayList<>();
        sql = "select MAHD,MASACH,TENSACH,SOLUONG,GIAMUA,GIAMGIA,THANHTIEN from HOADONCT";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                BanSach2 bs2 = new BanSach2(rs.getString(1), rs.getString(2), rs.getString(3), 
                        rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(7));
                listBs2.add(bs2);
            }
            return listBs2;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
     public int delete(String ma) {
        sql = "DELETE FROM HOADONCT WHERE MAHD LIKE ?";
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
     public int upDate2(String ma,BanSach2 b){
         sql = "update HOADONCT set MASACH = ?,SOLUONG = ?,THANHTIEN = ? where MAHD like ?";
         try {
             con = DBConnect.getConnection();
             ps = con.prepareStatement(sql);
             ps.setObject(1, b.getMaSach());
             ps.setObject(2, b.getSoLuong());
             ps.setObject(3, b.getThanhTien());
             
             ps.setObject(4, ma);
             return ps.executeUpdate();
         } catch (Exception e) {
             e.printStackTrace();
             return 0;
         }
     }
}
