package DAO;

import DTO.NhanVienDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import connection.jdbcHelper;

public class NhanVienDAO {

    public static ArrayList<NhanVienDTO> getAll() {
        ArrayList<NhanVienDTO> listNV = new ArrayList<>();
        String sql = "SELECT * FROM NHANVIEN";
        try (Connection conn = jdbcHelper.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet resultSet = pstmt.executeQuery()) {
            while (resultSet.next()) {
                NhanVienDTO s = new NhanVienDTO();
                s.setIdNV(resultSet.getString("IDNV"));
                s.setTen(resultSet.getString("TEN"));
                s.setGioiTinh(resultSet.getString("GIOITINH"));
                s.setNgaySinh(resultSet.getDate("NGAYSINH").toLocalDate().plusDays(0).toString());
                s.setEmail(resultSet.getString("EMAIL"));
                s.setSdt(resultSet.getString("SDT"));
                s.setTaikhoan(resultSet.getString("TAIKHOAN"));
                s.setPass(resultSet.getString("PASWORD"));
                s.setRoles(resultSet.getString("ROLES"));
                listNV.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listNV;
    }

    public static boolean insert(NhanVienDTO nv) {
        String sql = "INSERT INTO NHANVIEN (IDNV, TEN, GIOITINH, NGAYSINH, EMAIL, SDT, TAIKHOAN, PASWORD, ROLES) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = jdbcHelper.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setObject(1, nv.getIdNV());
            pstmt.setObject(2, nv.getTen());
            pstmt.setObject(3, nv.getGioiTinh());
            pstmt.setObject(4, nv.getNgaySinh());
            pstmt.setObject(5, nv.getEmail());
            pstmt.setObject(6, nv.getSdt());
            pstmt.setObject(7, nv.getTaikhoan());
            pstmt.setObject(8, nv.getPass());
            pstmt.setObject(9, nv.getRoles());
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Integer update(NhanVienDTO nv) {
        Integer row = null;
        String sql = "UPDATE NhanVien SET TEN = ?, GIOITINH = ?, NGAYSINH = ?, EMAIL = ?, SDT = ?, TAIKHOAN = ?, PASWORD = ?, ROLES = ? WHERE IDNV = ?";
        Connection con = jdbcHelper.getConnection();
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, nv.getTen());
            pstm.setString(2, nv.getGioiTinh());
            pstm.setString(3, nv.getNgaySinh());
            pstm.setString(4, nv.getEmail());
            pstm.setString(5, nv.getSdt());
            pstm.setString(6, nv.getTaikhoan());
            pstm.setString(7, nv.getPass());
            pstm.setString(8, nv.getRoles());
            pstm.setString(9, nv.getIdNV());
            row = pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    public boolean delete(NhanVienDTO nv) {
        String sql = "DELETE FROM NHANVIEN WHERE IDNV = ?";
        Connection con = jdbcHelper.getConnection();
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setObject(1, nv.getIdNV());
            return pstm.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static ArrayList<NhanVienDTO> getListRole(String vaiTro) {
        ArrayList<NhanVienDTO> listNV = new ArrayList<>();
        String sql = "SELECT * FROM NHANVIEN WHERE ROLES=?";
        try (Connection conn = jdbcHelper.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, vaiTro);
            try (ResultSet resultSet = pstmt.executeQuery()) {
                while (resultSet.next()) {
                    NhanVienDTO s = new NhanVienDTO();
                    s.setIdNV(resultSet.getString("IDNV"));
                    s.setTen(resultSet.getString("TEN"));
                    s.setGioiTinh(resultSet.getString("GIOITINH"));
                    s.setNgaySinh(resultSet.getDate("NGAYSINH").toLocalDate().plusDays(0).toString());
                    s.setEmail(resultSet.getString("EMAIL"));
                    s.setSdt(resultSet.getString("SDT"));
                    
                    s.setTaikhoan(resultSet.getString("TAIKHOAN"));
                    s.setPass(resultSet.getString("PASWORD"));     
                    s.setRoles(resultSet.getString("ROLES"));
                    
                    listNV.add(s);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listNV;
    }

    public static NhanVienDTO getListName(String hoTen) {
        String sql = " SELECT * FROM NHANVIEN WHERE TEN LIKE ?";
        try (Connection conn = jdbcHelper.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + hoTen + "%");
            try (ResultSet resultSet = pstmt.executeQuery()) {
                if (resultSet.next()) {
                    NhanVienDTO s = new NhanVienDTO();
                    s.setIdNV(resultSet.getString("IDNV"));
                    s.setTen(resultSet.getString("TEN"));
                    s.setGioiTinh(resultSet.getString("GIOITINH"));
                    s.setNgaySinh(resultSet.getDate("NGAYSINH").toLocalDate().plusDays(0).toString());
                    s.setEmail(resultSet.getString("EMAIL"));
                    
                    s.setSdt(resultSet.getString("SDT"));
                    s.setTaikhoan(resultSet.getString("TAIKHOAN"));
                    s.setPass(resultSet.getString("PASWORD"));
                    
                    
                    s.setRoles(resultSet.getString("ROLES"));
                    
                    return s;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
