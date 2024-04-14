/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main.NhanVien.NhanVien.service;

import Main.NhanVien.NhanVien.model.TaiKhoan_Model;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Admin
 */
public class TaiKhoan_Service {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private List<TaiKhoan_Model> listTK = null;
    private String sql = null;

    public List<TaiKhoan_Model> fillAll() {
        sql = "SELECT IDNV , TAIKHOAN , PASWORD  FROM NHANVIEN";
        try {
            listTK = new ArrayList<>();
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                TaiKhoan_Model tk = new TaiKhoan_Model(rs.getString(1), rs.getString(2), rs.getString(3));
                listTK.add(tk);
            }
            return listTK;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public int AddTaiKhoan(TaiKhoan_Model tk) {
        sql = "INSERT INTO NHANVIEN( IDNV, TAIKHOAN, PASWORD)VALUES(?,?,?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, tk.getMaNhanVien());
            ps.setString(2, tk.getUsername());
            ps.setString(3, tk.getPassword());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public int Delete(String ID) {
        sql = "DELETE FROM NHANVIEN WHERE IDNV = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ID);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public int Update(String ID, TaiKhoan_Model tk) {
        sql = "UPDATE NHANVIEN SET TAIKHOAN=? , PASWORD=?  WHERE IDNV LIKE ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, tk.getUsername());
            ps.setString(2, tk.getPassword());
            ps.setString(3, ID);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }
}
