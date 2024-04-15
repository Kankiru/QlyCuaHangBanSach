/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main.NhapHang.Service;

import Main.NhapHang.Model.NhapHang;
import Main.NhapHang.Model.CTNhapHang;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NhapHangService {

    List<NhapHang> ListNH;
    List<CTNhapHang> ListctNH;
    Connection con = DBConnect.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public List<CTNhapHang> getAllCTPhieuNhap() {
        ListctNH = new ArrayList<>();
        sql = "SELECT * FROM CTPHIEUNHAP";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                CTNhapHang nhapHang = new CTNhapHang();
                nhapHang.setMaPN(rs.getString("MAPN"));
                nhapHang.setMaNV(rs.getString("MANV"));
                nhapHang.setMaNCC(rs.getString("MANCC"));
                nhapHang.setMaSach(rs.getString("MASACH"));
                nhapHang.setSoLuong(rs.getInt("SOLUONG"));
                nhapHang.setDonGia(rs.getInt("DONGIA"));
                nhapHang.setNgayNhap(rs.getTimestamp("NGAYNHAP"));
                int soLuong = nhapHang.getSoLuong();
                int donGia = nhapHang.getDonGia();
                int tongTien = soLuong * donGia;
                nhapHang.setTongTien(tongTien);
                ListctNH.add(nhapHang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }

        return ListctNH;

    }

    public List<NhapHang> getAllPhieuNhap() {
        ListNH = new ArrayList<>();

        try {
            sql = "SELECT * FROM PHIEUNHAP";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                String maPhieuNhap = rs.getString("MAPN");
                String maNhanVien = rs.getString("MANV");
                String maNCC = rs.getString("MANCC");
                int soLuong = rs.getInt("SOLUONG");
                int donGia = rs.getInt("DONGIA");
                Date ngayNhap = rs.getDate("NGAYNHAP");
                int thanhTien = rs.getInt("TONGTIEN");

                NhapHang phieuNhap = new NhapHang(maPhieuNhap, maNhanVien, maNCC, soLuong, donGia, ngayNhap, thanhTien);

                ListNH.add(phieuNhap);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ListNH;
    }

    public void themPhieuNhap(NhapHang phieuNhap) {
        try {
            // Tạo câu lệnh SQL để thêm phiếu nhập vào cơ sở dữ liệu
            String sql = "INSERT INTO PHIEUNHAP (MAPN, MANV, MANCC, SOLUONG, DONGIA, NGAYNHAP, TONGTIEN) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            // Thiết lập các tham số cho câu lệnh SQL
            ps.setString(1, phieuNhap.getMaPhieuNhap());
            ps.setString(2, phieuNhap.getMaNhanVien());
            ps.setString(3, phieuNhap.getMaNCC());
            ps.setInt(4, phieuNhap.getSoLuong());
            ps.setInt(5, phieuNhap.getDonGia());
            ps.setDate(6, new java.sql.Date(phieuNhap.getNgayNhap().getTime()));
            ps.setInt(7, phieuNhap.getThanhTien());

            // Thực thi câu lệnh SQL để thêm phiếu nhập
            ps.executeUpdate();

            // Đóng tài nguyên
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void suaPhieuNhap(NhapHang phieuNhap) {
      
        try {
         
          sql = "UPDATE PHIEUNHAP SET MANV = ?, MANCC = ?, SOLUONG = ?, DONGIA = ?, NGAYNHAP = ?, TONGTIEN = ? WHERE MAPN = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, phieuNhap.getMaNhanVien());
            ps.setString(2, phieuNhap.getMaNCC());
            ps.setInt(3, phieuNhap.getSoLuong());
            ps.setInt(4, phieuNhap.getDonGia());
            ps.setDate(5, new java.sql.Date(phieuNhap.getNgayNhap().getTime()));
            ps.setInt(6, phieuNhap.getThanhTien());
            ps.setString(7, phieuNhap.getMaPhieuNhap());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            
        }
    }

    public void xoaPhieuNhap(String maPhieuNhap) {
        
        try {
            
            sql = "DELETE FROM PHIEUNHAP WHERE MAPN = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, maPhieuNhap);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            
        }
    }

}
