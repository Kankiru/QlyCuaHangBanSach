/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service1;

import Model1.NhanVien_Model;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Admin
 */
public class NhanVien_Service {

    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private Connection con = null;
    private List<NhanVien_Model> listNV = null;
    private String sql = null;

    public List<NhanVien_Model> finAll() {
        sql = "SELECT IDNV, TEN, EMAIL, SDT, GIOITINH, NGAYSINH FROM NHANVIEN";
        try {
            listNV = new ArrayList<>();
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien_Model nv = new NhanVien_Model();
                nv.setMaNhanVien(rs.getString(1));
                nv.setTen(rs.getString(2));
                nv.setGioiTinh(rs.getString(5));
                nv.setEmail(rs.getString(3));
                nv.setSoDienThoai(rs.getString(4));

                java.sql.Date ngaysinh = rs.getDate(6);
                if (ngaysinh != null) {
                    nv.setNgaySinh(new java.util.Date(ngaysinh.getTime()));
                }
                listNV.add(nv);
            }
            return listNV;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public int addNhanVien(NhanVien_Model nv) {
        sql = "INSERT INTO NHANVIEN(IDNV, TEN, EMAIL, SDT, GIOITINH, NGAYSINH) VALUES (?,?,?,?,?,?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, nv.getMaNhanVien());
            ps.setString(2, nv.getTen());

            ps.setString(3, nv.getEmail());
            ps.setString(4, nv.getSoDienThoai());
            ps.setString(5, nv.getGioiTinh());
            ps.setDate(6, new java.sql.Date(nv.getNgaySinh().getTime()));
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

    public int DeleteNhanVien(String ma) {
        sql = "DELETE FROM NHANVIEN WHERE IDNV LIKE ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ma);
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

    public int UpdateNhanVien(String ma, NhanVien_Model nv) {
        sql = "UPDATE NHANVIEN SET TEN=?,  EMAIL=?, SDT=?, GIOITINH=?, NGAYSINH=? WHERE IDNV LIKE ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, nv.getTen());
            ps.setString(2, nv.getEmail());
            ps.setString(3, nv.getSoDienThoai());
            ps.setString(4, nv.getGioiTinh());
            ps.setDate(5, new java.sql.Date(nv.getNgaySinh().getTime()));
            ps.setString(6, ma);
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

    public List<NhanVien_Model> FindByTen(String ten) {
        sql = "SELECT IDNV, TEN,  EMAIL, SDT, GIOITINH, NGAYSINH FROM NHANVIEN WHERE TEN LIKE ?";
        try {
            listNV = new ArrayList<>();
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + ten + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien_Model nv = new NhanVien_Model();
                nv.setMaNhanVien(rs.getString(1));
                nv.setTen(rs.getString(2));
                nv.setGioiTinh(rs.getString(5));
                nv.setEmail(rs.getString(3));
                nv.setSoDienThoai(rs.getString(4));
                java.sql.Date ngaysinh = rs.getDate(6);
                if (ngaysinh != null) {
                    nv.setNgaySinh(new java.util.Date(ngaysinh.getTime()));
                }
                listNV.add(nv);
            }
            return listNV;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
