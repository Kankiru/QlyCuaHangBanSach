/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;
import Model.NhapSach1;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author admin
 */
public class NhapSach_Service {
     private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;
    public List<NhapSach1> getAll(){
        List<NhapSach1> listNs = new ArrayList<>();
        sql = "select MAPN,MANV,MANCC,NGAYNHAP,TONGTIEN from PHIEUNHAP";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
               NhapSach1 ns = new NhapSach1(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
                listNs.add(ns);
            }
            return listNs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public int add(NhapSach1 ns){
        sql = "insert into PHIEUNHAP (MAPN,MANV,MANCC,NGAYNHAP,TONGTIEN) values (?,?,?,?,?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ns.getMaPN());
            ps.setObject(2, ns.getMaNV());
            ps.setObject(3, ns.getMaNCC());
            ps.setObject(4, ns.getNgayNhap());
            ps.setObject(5, ns.getTongTien());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public int upDate(String ma,NhapSach1 ns){
        sql = "update PHIEUNHAP set MANV = ?,MANCC = ?,NGAYNHAP = ?,TONGTIEN = ? where MAPN like ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ns.getMaNV());
            ps.setObject(2, ns.getMaNCC());
            ps.setObject(3, ns.getNgayNhap());
            ps.setObject(4, ns.getTongTien());
            ps.setObject(5, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public int delete(String ma){
        sql = "delete from PHIEUNHAP where MAPN like ?";
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
    

}
