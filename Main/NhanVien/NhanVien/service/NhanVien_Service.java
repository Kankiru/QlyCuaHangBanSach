/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main.NhanVien.NhanVien.service;

import Main.NhanVien.NhanVien.model.NhanVien_Model;

import java.sql.*;
import java.time.LocalDate;
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
        sql = "SELECT IDNV, TEN, EMAIL, SDT, GIOITINH, NGAYSINH,TAIKHOAN,MATKHAU FROM NHANVIEN";
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
                java.sql.Date ngaySinh = rs.getDate(6);
                if (ngaySinh != null) {
                    LocalDate ngaySinhUtil = ngaySinh.toLocalDate();
                    java.util.Date ngaySinhUtilDate = java.sql.Date.valueOf(ngaySinhUtil);
                    nv.setNgaySinh(ngaySinhUtilDate);
                }
                nv.setTaiKhoan(rs.getString(7));
                nv.setMatKhau(rs.getString(8));

                listNV.add(nv);
            }
            return listNV;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {

        }
    }

    public int addNhanVien(NhanVien_Model nhanVien) {
        sql = "INSERT INTO NHANVIEN (IDNV, TEN, GIOITINH, NGAYSINH, EMAIL, SDT, taikhoan, matkhau) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, nhanVien.getMaNhanVien());
            ps.setString(2, nhanVien.getTen());
            ps.setString(3, nhanVien.getGioiTinh());
            ps.setDate(4, new java.sql.Date(nhanVien.getNgaySinh().getTime())); // Chú ý ở đây
            ps.setString(5, nhanVien.getEmail());
            ps.setString(6, nhanVien.getSoDienThoai());
            ps.setString(7, nhanVien.getTaiKhoan());
            ps.setString(8, nhanVien.getMatKhau());

            return ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        } finally {

        }
    }

    public int deleteNhanVien(String ma) {
        sql = "DELETE FROM NHANVIEN WHERE IDNV = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ma);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {

        }
    }

    public int updateNhanVien(String ma, NhanVien_Model nv) {
        sql = "UPDATE NHANVIEN SET TEN=?,  EMAIL=?, SDT=?, GIOITINH=?, NGAYSINH=? WHERE IDNV = ?";
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
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {

        }
    }

    public List<NhanVien_Model> timKiemNhanVien(String truongTimKiem, String tuKhoa) {
        listNV = new ArrayList<>();

        try {
            sql = "SELECT * FROM NHANVIEN WHERE " + truongTimKiem + " LIKE ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + tuKhoa + "%"); // Tìm kiếm tất cả các dòng chứa từ khóa

            rs = ps.executeQuery();

            // Duyệt qua kết quả truy vấn và thêm từng nhân viên vào danh sách kết quả
            while (rs.next()) {
                String maNV = rs.getString("IDNV");
                String hoTen = rs.getString("Ten");
                String gioiTinh = rs.getString("GioiTinh");
                Date ngaySinh = rs.getDate("NgaySinh");
                String email = rs.getString("Email");
                String soDienThoai = rs.getString("Sdt");
                String taiKhoan = rs.getString("TaiKhoan");
                String matKhau = rs.getString("MatKhau");

                // Tạo đối tượng nhân viên và thêm vào danh sách kết quả
                NhanVien_Model nv = new NhanVien_Model(maNV, hoTen, gioiTinh, ngaySinh, email, soDienThoai, taiKhoan, matKhau);
                listNV.add(nv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listNV; // Trả về danh sách kết quả tìm kiếm
    }

    public List<String> getAllMaNhanVien() {
        List<String> listMaNV = new ArrayList<>();
        sql = "SELECT IDNV FROM NHANVIEN";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                listMaNV.add(rs.getString("IDNV"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listMaNV;
    }

}
