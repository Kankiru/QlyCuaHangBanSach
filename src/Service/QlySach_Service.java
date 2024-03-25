/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;
import Model.QlySach;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author admin
 */
public class QlySach_Service {
     private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;
    public List<QlySach> getAll(){
        List<QlySach> listQls = new ArrayList<>();
        sql = "select MASACH,MANXB,THELOAI,MATG,TENSACH,NAMXUATBAN,SOLUONG,GIAMUA,ANH from SACH";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                QlySach qls = new QlySach(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), 
                        rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9));
                listQls.add(qls);
            }return listQls;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public int add(QlySach s){
        sql = "insert into SACH (MASACH,MANXB,THELOAI,MATG,TENSACH,NAMXUATBAN,SOLUONG,GIAMUA,ANH) values (?,?,?,?,?,?,?,?,?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, s.getMaSach());
            ps.setObject(2, s.getMaNxb());
            ps.setObject(3, s.getTheLoai());
            ps.setObject(4, s.getMaTg());
            ps.setObject(5, s.getTenSach());
            ps.setObject(6, s.getNamXuatBan());
            ps.setObject(7, s.getSoLuong());
            ps.setObject(8, s.getGiaMua());
            ps.setObject(9, s.getAnh());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    public int upDate(String ma, QlySach s){
        sql = "update SACH set MANXB = ?,THELOAI = ?,MATG = ?,TENSACH = ?,NAMXUATBAN = ?,SOLUONG = ?,GIAMUA = ?,ANH = ? where MASACH like ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, s.getMaNxb());
            ps.setObject(2, s.getTheLoai());
            ps.setObject(3, s.getMaTg());
            ps.setObject(4, s.getTenSach());
            ps.setObject(5, s.getNamXuatBan());
            ps.setObject(6, s.getSoLuong());
            ps.setObject(7, s.getGiaMua());
            ps.setObject(8, s.getAnh());
            ps.setObject(9, ma);
            
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    public int delete(String ma){
        sql = "delete from SACH where MASACH like ?";
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
