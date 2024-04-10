/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1.NhaCungCap.service;

/**
 *
 * @author pc
 */
import duan1.NhaCungCap.model.NhaCungCap;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NhaCCService {

    Connection con = DBConnect.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;
    List<NhaCungCap> ListNCC;

    public int count() {
        int count = 0;
        sql = "select count(*) from nhacungcap ";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        return count;
    }

    public List<NhaCungCap> getAll() {
        ListNCC = new ArrayList<>();
        sql = "select * from Nhacungcap";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                NhaCungCap ncc = new NhaCungCap(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                ListNCC.add(ncc);

            }
            return ListNCC;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void add(NhaCungCap ncc) {
        sql = "INSERT INTO Nhacungcap (MaNCC, Tennhacungcap, DiaChi, Email, SDT, MoTa) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, ncc.getMANCC());
            ps.setString(2, ncc.getTENNHACUNGCAP());
            ps.setString(3, ncc.getDIACHI());
            ps.setString(4, ncc.getEMAIL());
            ps.setString(5, ncc.getSDT());
            ps.setString(6, ncc.getMOTA());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(NhaCungCap ncc) {
        sql = "UPDATE Nhacungcap SET TenNhacungcap = ?, DiaChi = ?, Email = ?, SDT = ?, MoTa = ? WHERE MaNCC = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, ncc.getTENNHACUNGCAP());
            ps.setString(2, ncc.getDIACHI());
            ps.setString(3, ncc.getEMAIL());
            ps.setString(4, ncc.getSDT());
            ps.setString(5, ncc.getMOTA());
            ps.setString(6, ncc.getMANCC());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String maNCC) {
        sql = "DELETE FROM Nhacungcap WHERE MaNCC = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, maNCC);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<NhaCungCap> timKiemTheoMaNCC(String keyword) {
        List<NhaCungCap> ketQua = new ArrayList<>();
        sql = "SELECT * FROM Nhacungcap WHERE MaNCC LIKE ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + keyword + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                NhaCungCap ncc = new NhaCungCap(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                ketQua.add(ncc);
            }
            return ketQua;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Tìm kiếm theo Tên Nhà Cung Cấp
    public List<NhaCungCap> timKiemTheoTenNCC(String keyword) {
        List<NhaCungCap> ketQua = new ArrayList<>();
        sql = "SELECT * FROM Nhacungcap WHERE Tennhacungcap LIKE ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + keyword + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                NhaCungCap ncc = new NhaCungCap(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                ketQua.add(ncc);
            }
            return ketQua;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Tìm kiếm theo Địa Chỉ
    public List<NhaCungCap> timKiemTheoDiaChi(String keyword) {
        List<NhaCungCap> ketQua = new ArrayList<>();
        sql = "SELECT * FROM Nhacungcap WHERE DiaChi LIKE ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + keyword + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                NhaCungCap ncc = new NhaCungCap(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                ketQua.add(ncc);
            }
            return ketQua;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Tìm kiếm theo Email
    public List<NhaCungCap> timKiemTheoEmail(String keyword) {
        List<NhaCungCap> ketQua = new ArrayList<>();
        sql = "SELECT * FROM Nhacungcap WHERE Email LIKE ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + keyword + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                NhaCungCap ncc = new NhaCungCap(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                ketQua.add(ncc);
            }
            return ketQua;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Tìm kiếm theo Số Điện Thoại
    public List<NhaCungCap> timKiemTheoSDT(String keyword) {
        List<NhaCungCap> ketQua = new ArrayList<>();
        sql = "SELECT * FROM Nhacungcap WHERE SDT LIKE ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + keyword + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                NhaCungCap ncc = new NhaCungCap(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                ketQua.add(ncc);
            }
            return ketQua;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
