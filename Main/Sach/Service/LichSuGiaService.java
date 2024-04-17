/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main.Sach.Service;

import Main.Sach.Model.LichSuGia;
import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pc
 */
public class LichSuGiaService {

    Connection con = DBConnect.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public List<String> getAllMaSach() {
        List<String> listMaSach = new ArrayList<>();
        sql = "SELECT MASACH FROM SACH";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String maSach = rs.getString("MASACH");
                listMaSach.add(maSach);
            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return listMaSach;
    }

    public List<LichSuGia> getLichSuGiaByMaSach(String maSach) {
        List<LichSuGia> lichSuGiaList = new ArrayList<>();
        String sql = "SELECT * FROM LichSuGia WHERE MaSach = ?";
        try (Connection conn = DBConnect.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, maSach);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    LichSuGia lichSuGia = new LichSuGia();
                    lichSuGia.setMaSach(rs.getString("MaSach"));
                    Timestamp ngayCapNhat = rs.getTimestamp("NgayCapNhat");
                    lichSuGia.setNgayCapNhat(ngayCapNhat);
                    int giamGia = rs.getInt("GiaBan"); // Giả sử đây là giảm giá, chú ý thay đổi nếu tên cột không đúng
                    // Lấy giá mua từ bảng SACH
                    int giaMua = layGiaMuaTuMaSach(maSach); // Phương thức này cần phải được định nghĩa
                    // Tính toán giá bán sau giảm giá
                    int giaBan = giaMua - (giaMua * giamGia / 100);
                    lichSuGia.setGiaBan(giaBan);
                    lichSuGiaList.add(lichSuGia);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lichSuGiaList;
    }

// Phương thức để lấy giá mua từ bảng SACH
    private int layGiaMuaTuMaSach(String maSach) {
        int giaMua = 0;
        String sql = "SELECT GIAMUA FROM SACH WHERE MaSach = ?";
        try (Connection conn = DBConnect.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, maSach);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    giaMua = rs.getInt("GIAMUA");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return giaMua;
    }

}
