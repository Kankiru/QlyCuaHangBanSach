/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main.HoaDon.Service;

import Main.HoaDon.Model.HoaDon;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.Collections;

public class HoaDonService {

    List<HoaDon> ListHD;
    Connection con = DBConnect.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public List<HoaDon> getAllHoaDon() {
        ListHD = new ArrayList<>();
        try {
            sql = "SELECT mahd, maKh, idnv, maSach, soLuong, ngayLap, tongTien from hoadon";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hoaDon = new HoaDon();
                hoaDon.setMaHoaDon(rs.getString("MaHD"));
                hoaDon.setMaKhachHang(rs.getString("MaKH"));
                hoaDon.setMaNhanVien(rs.getString("IDNV"));
                hoaDon.setMaSach(rs.getString("MaSach"));
                hoaDon.setSoLuong(rs.getInt("SoLuong"));
                hoaDon.setNgayLap(rs.getTimestamp("NgayLap"));
                hoaDon.setTongTien(rs.getInt("TongTien"));
                ListHD.add(hoaDon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }
        return ListHD;
    }
    // Phương thức để xóa hóa đơn và trả về danh sách cập nhật
public List<HoaDon> xoaHoaDon(String maHoaDon) {
    try {
        // Xây dựng truy vấn SQL
       sql = "DELETE FROM HoaDon WHERE MAHD = ?";
        
        // Chuẩn bị truy vấn
        ps = con.prepareStatement(sql);
        ps.setString(1, maHoaDon);
        
        // Thực thi truy vấn
        int affectedRows = ps.executeUpdate();
        
        // Đóng PreparedStatement
        ps.close();
        
        // Kiểm tra xem có hàng nào bị ảnh hưởng không
        if (affectedRows > 0) {
            // Trả về danh sách hóa đơn sau khi xóa thành công
            return getAllHoaDon();
        }
    } catch (SQLException e) {
        // Xử lý ngoại lệ, ví dụ: in ra thông báo lỗi
        e.printStackTrace();
    } finally {
        // Đảm bảo rằng PreparedStatement được đóng sau khi sử dụng
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Trả về danh sách rỗng nếu không có hóa đơn nào bị xóa hoặc có lỗi xảy ra
    return Collections.emptyList();
}


}
