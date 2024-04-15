/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main.Login_Home.Service;

import java.sql.*;

public class LoginService {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public boolean kiemTraDangNhap(String taiKhoan, String matKhau) {
        boolean ketQua = false;

        try {
            con = DBConnect.getConnection(); // Lấy kết nối đến cơ sở dữ liệu
            sql = "SELECT * FROM NHANVIEN WHERE TAIKHOAN = ? AND MATKHAU = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, taiKhoan);
            ps.setString(2, matKhau);
            rs = ps.executeQuery();

            // Nếu có bản ghi trả về từ cơ sở dữ liệu, đăng nhập thành công
            if (rs.next()) {
                ketQua = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Đóng kết nối và các tài nguyên
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
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return ketQua; // Trả về kết quả kiểm tra đăng nhập

    }

    public boolean resetPassword(String taiKhoan, String matKhauMoi, String email) {

        CallableStatement callableStatement = null;

        try {
            con = DBConnect.getConnection(); // Lấy kết nối đến cơ sở dữ liệu

            // Gọi stored procedure để đổi mật khẩu
            String storedProcedure = "{call DoiMatKhau(?, ?)}";
            callableStatement = con.prepareCall(storedProcedure);
            callableStatement.setString(1, taiKhoan);
            callableStatement.setString(2, matKhauMoi);

            // Thực thi stored procedure
            callableStatement.execute();

            // Nếu không có lỗi, trả về true
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý lỗi
            return false;
        } finally {
            // Đóng kết nối và các tài nguyên
            try {
                if (callableStatement != null) {
                    callableStatement.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public String layTenNhanVien(String taiKhoan) {
        String tenNhanVien = ""; // Biến này lưu tên nhân viên lấy được từ cơ sở dữ liệu

        try {
            con = DBConnect.getConnection(); // Lấy kết nối đến cơ sở dữ liệu
            sql = "SELECT TEN FROM NHANVIEN WHERE TAIKHOAN = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, taiKhoan);
            rs = ps.executeQuery();

            // Nếu có bản ghi trả về từ cơ sở dữ liệu, lấy tên nhân viên
            if (rs.next()) {
                tenNhanVien = rs.getString("TEN");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Đóng kết nối và các tài nguyên
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
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return tenNhanVien; // Trả về tên nhân viên
    }

}
