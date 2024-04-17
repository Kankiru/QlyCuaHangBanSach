/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main.ThongKe;

import Main.QLKH.QlyCuaHangBanSach.Servicce.DBConnect;
import Main.Sach.Model.SachModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author pc
 */
public class ThongKeService {

    List<SachModel> ListSach;
    Connection con = DBConnect.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public int laySoLuongSachHienCo() {
        int soLuong = 0;
        String sql = "SELECT COUNT(*) AS SoLuong FROM Sach";

        try (PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                soLuong = rs.getInt("SoLuong");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return soLuong;
    }

    public int tinhTongGiaMuaSach() {
        int tongGiaMua = 0; // Khai báo biến tongGiaMua để lưu tổng giá mua

        String sql = "SELECT SUM(GIAMUA) AS TONGGIAMUA FROM sach"; // Truy vấn tính tổng giá mua
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                tongGiaMua = rs.getInt("TONGGIAMUA"); // Lấy giá trị tổng giá mua từ kết quả truy vấn
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return tongGiaMua; // Trả về tổng giá mua
    }

}
