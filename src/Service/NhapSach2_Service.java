/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;
import Model.NhapSach2;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author admin
 */
public class NhapSach2_Service {
     private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;
    public List<NhapSach2> getAll2(){
        List<NhapSach2> listNs2 = new ArrayList<>();
        sql = "select MACTPN,MAPN,MASACH,SOLUONG,DONGIA,THANHTIEN from CTPHIEUNHAP";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                NhapSach2 ns = new NhapSach2(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6));
                listNs2.add(ns);
            }
            return listNs2;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public int add2(NhapSach2 ns2){
        sql = "insert into CTPHIEUNHAP (MACTPN,MAPN,MASACH,SOLUONG,DONGIA,THANHTIEN) values (?,?,?,?,?,?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ns2.getMaCTPN());
            ps.setObject(2, ns2.getMaPN());
            ps.setObject(3, ns2.getMaSach());
            ps.setObject(4, ns2.getSoLuong());
            ps.setObject(5, ns2.getDonGia());
            ps.setObject(6, ns2.getThanhTien());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
      public int delete2(String ma){
        sql = "delete from CTPHIEUNHAP where MACTPN like ?";
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
    
      public int upDate2(String ma,NhapSach2 ns2){
          sql = "update CTPHIEUNHAP set MAPN = ?,MASACH = ?,SOLUONG = ?,DONGIA = ?,THANHTIEN = ? where MACTPN like ?";
          try {
              con = DBConnect.getConnection();
              ps = con.prepareStatement(sql);
              ps.setObject(1, ns2.getMaPN());
              ps.setObject(2, ns2.getMaSach());
              ps.setObject(3, ns2.getSoLuong());
              ps.setObject(4, ns2.getDonGia());
              ps.setObject(5, ns2.getThanhTien());
              ps.setObject(6, ma);
              return ps.executeUpdate();
          } catch (Exception e) {
              e.printStackTrace();
              return 0;
          }
      }
    
}
