/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main.Voucher.Service;

import Main.QLKH.QlyCuaHangBanSach.Servicce.DBConnect;
import Main.Voucher.Model.Voucher;
import java.util.ArrayList;

import java.sql.*;
import java.util.List;

public class VoucherService {

    Connection con = DBConnect.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public List<Voucher> getAllVoucher() {
        List<Voucher> voucherList = new ArrayList<>();
        try {
            // Tạo câu truy vấn SQL
            sql = "SELECT * FROM VOUCHER";

            // Tạo đối tượng PreparedStatement
            ps = con.prepareStatement(sql);

            // Thực thi truy vấn
            rs = ps.executeQuery();

            // Duyệt qua các dòng kết quả và tạo đối tượng Voucher từ mỗi dòng
            while (rs.next()) {
                // Đọc dữ liệu từ ResultSet
                String maVoucher = rs.getString("MAVOUCHER");
                String tenVoucher = rs.getString("TENVOUCHER");
                int dieuKien = rs.getInt("DIEUKIEN");

                int giamGia = rs.getInt("GIAMGIA");

                // Tạo đối tượng Voucher và thêm vào danh sách
                Voucher voucher = new Voucher(maVoucher, tenVoucher, dieuKien, giamGia);
                voucherList.add(voucher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return voucherList;
    }

    public boolean deleteVoucher(String maVoucher) {
        try {
            // Tạo câu truy vấn SQL
            String sql = "DELETE FROM VOUCHER WHERE MAVOUCHER = ?";

            // Tạo đối tượng PreparedStatement
            ps = con.prepareStatement(sql);

            // Thiết lập tham số cho câu truy vấn
            ps.setString(1, maVoucher);

            // Thực thi câu truy vấn DELETE và trả về kết quả
            int rowsDeleted = ps.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean addVoucher(Voucher newVoucher) {
        try {
            // Tạo câu truy vấn SQL
            String sql = "INSERT INTO VOUCHER (MAVOUCHER, TENVOUCHER, DIEUKIEN, GIAMGIA) VALUES (?, ?, ?, ?)";

            // Tạo đối tượng PreparedStatement
            ps = con.prepareStatement(sql);

            // Thiết lập tham số cho câu truy vấn
            ps.setString(1, newVoucher.getMaVoucher());
            ps.setString(2, newVoucher.getTenVoucher());
            ps.setInt(3, newVoucher.getDieuKien());
            ps.setInt(4, newVoucher.getGiamGia());

            // Thực thi câu truy vấn INSERT và trả về kết quả
            int rowsInserted = ps.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateVoucher(Voucher updatedVoucher) {
        try {
            // Tạo câu truy vấn SQL
            String sql = "UPDATE VOUCHER SET TENVOUCHER = ?, DIEUKIEN = ?, GIAMGIA = ? WHERE MAVOUCHER = ?";

            // Tạo đối tượng PreparedStatement
            ps = con.prepareStatement(sql);

            // Thiết lập tham số cho câu truy vấn
            ps.setString(1, updatedVoucher.getTenVoucher());
            ps.setInt(2, updatedVoucher.getDieuKien());
            ps.setInt(3, updatedVoucher.getGiamGia());
            ps.setString(4, updatedVoucher.getMaVoucher());

            // Thực thi câu truy vấn UPDATE và trả về kết quả
            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Voucher> searchByMaVoucher(String maVoucher) {
        ArrayList<Voucher> searchResult = new ArrayList<>();
        try {
            // Tạo câu truy vấn SQL
            sql = "SELECT * FROM VOUCHER WHERE MAVOUCHER = ?";

            // Tạo đối tượng PreparedStatement
            ps = con.prepareStatement(sql);

            // Đặt giá trị tham số cho câu truy vấn
           ps.setString(1, "%" + maVoucher + "%");

            // Thực thi truy vấn
            rs = ps.executeQuery();

            // Duyệt qua các dòng kết quả và tạo đối tượng Voucher từ mỗi dòng
            while (rs.next()) {
                // Đọc dữ liệu từ ResultSet
                String maVoucherResult = rs.getString("MAVOUCHER");
                int dieuKien = rs.getInt("DIEUKIEN");
                String tenVoucher = rs.getString("TENVOUCHER");
                int giamGia = rs.getInt("GIAMGIA");

                // Tạo đối tượng Voucher và thêm vào danh sách kết quả
                Voucher voucher = new Voucher(maVoucherResult, tenVoucher, dieuKien, giamGia);
                searchResult.add(voucher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return searchResult;
    }

    public ArrayList<Voucher> searchByTenVoucher(String tenVoucher) {
        ArrayList<Voucher> searchResult = new ArrayList<>();
        try {
            // Tạo câu truy vấn SQL
            sql = "SELECT * FROM VOUCHER WHERE TENVOUCHER LIKE ?";

            // Tạo đối tượng PreparedStatement
            ps = con.prepareStatement(sql);

            // Đặt giá trị tham số cho câu truy vấn
            ps.setString(1, "%" + tenVoucher + "%");

            // Thực thi truy vấn
            rs = ps.executeQuery();

            // Duyệt qua các dòng kết quả và tạo đối tượng Voucher từ mỗi dòng
            while (rs.next()) {
                // Đọc dữ liệu từ ResultSet
                String maVoucher = rs.getString("MAVOUCHER");
                int dieuKien = rs.getInt("DIEUKIEN");
                String tenVoucherResult = rs.getString("TENVOUCHER");
                int giamGia = rs.getInt("GIAMGIA");

                // Tạo đối tượng Voucher và thêm vào danh sách kết quả
                Voucher voucher = new Voucher(maVoucher, tenVoucherResult, dieuKien, giamGia);
                searchResult.add(voucher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return searchResult;
    }

}
