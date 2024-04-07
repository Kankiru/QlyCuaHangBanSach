/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.NhanVien_Model;

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
                nv.setGioiTinh(rs.getString(3));
                nv.setEmail(rs.getString(4));
                nv.setSoDienThoai(rs.getString(5));
                java.sql.Date ngaysinh = rs.getDate(6);
                if (ngaysinh != null) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String ngaySinhString = dateFormat.format(new java.util.Date(ngaysinh.getTime()));
                    nv.setNgaySinh(java.sql.Date.valueOf(ngaySinhString));
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

    public List<NhanVien_Model> searchIDNV(String searchText) {
        listNV = new ArrayList<>();
        sql = "select  IDNV, TEN, EMAIL, SDT, GIOITINH, NGAYSINH  from NHANVIEN where IDNV like ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, searchText + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien_Model nv = new NhanVien_Model();
                nv.setMaNhanVien(rs.getString(1));
                nv.setTen(rs.getString(2));
                nv.setGioiTinh(rs.getString(3));
                nv.setEmail(rs.getString(4));
                nv.setSoDienThoai(rs.getString(5));
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

    public List<NhanVien_Model> searchTen(String searchText) {
        listNV = new ArrayList<>();
        sql = "select  IDNV, TEN, EMAIL, SDT, GIOITINH, NGAYSINH from NHANVIEN where TEN like ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + searchText + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien_Model nv = new NhanVien_Model();
                nv.setMaNhanVien(rs.getString(1));
                nv.setTen(rs.getString(2));
                nv.setGioiTinh(rs.getString(3));
                nv.setEmail(rs.getString(4));
                nv.setSoDienThoai(rs.getString(5));
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

    //----- phần tài khoản --------------------------------------------------
    public List<NhanVien_Model> fillAll2() {
        sql = "SELECT IDNV , TAIKHOAN , PASWORD ,EMAIL,ROLES FROM NHANVIEN";
        try {
            listNV = new ArrayList<>();
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien_Model tk = new NhanVien_Model(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                listNV.add(tk);
            }
            return listNV;
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

   public int Update(String ID, NhanVien_Model tk) {
        if (isUsernameExists(tk.getTaiKhoan(), ID)) {
            JOptionPane.showMessageDialog(null, "Tên đăng nhập đã tồn tại!");
            return 0;
        }
        sql = "UPDATE NHANVIEN SET TAIKHOAN=? , PASWORD=?,ROLES=?  WHERE IDNV LIKE ?";
        String hashedPassword = PasswordHasher.hashPassword(tk.getMatKhau());
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, tk.getTaiKhoan());
            ps.setString(2, hashedPassword);
            ps.setString(3, tk.getRoles());
            ps.setString(4, ID);
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
    // Phương thức kiểm tra trùng tên đăng nhập

    private boolean isUsernameExists(String username, String ID) {
        boolean exists = false;
        try {
            con = DBConnect.getConnection();
            sql = "SELECT COUNT(*) FROM NHANVIEN WHERE TAIKHOAN=? AND IDNV <> ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, ID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                if (count > 0) {
                    exists = true; // Tên đăng nhập đã tồn tại
                }
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return exists;
    }

}
