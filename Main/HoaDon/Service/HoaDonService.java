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
import java.util.UUID;

public class HoaDonService {

    List<HoaDon> ListHD;
    Connection con = DBConnect.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public List<HoaDon> getAllHoaDon() {
        ListHD = new ArrayList<>();
        try {
            // Sử dụng INNER JOIN để kết hợp dữ liệu từ bảng hoadon và sach
            sql = "Select * from hoadon";
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

                ListHD.add(hoaDon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ListHD;
    }

// Phương thức để xóa hóa đơn và trả về danh sách cập nhật
    public List<HoaDon> xoaHoaDon(String maHoaDon) {
        try {
            con = DBConnect.getConnection();
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

        }
        // Trả về danh sách rỗng nếu không có hóa đơn nào bị xóa hoặc có lỗi xảy ra
        return Collections.emptyList();
    }

    public void deleteHoaDon(String maHD) {

        ps = null;

        try {
            con = DBConnect.getConnection();
            sql = "DELETE FROM hoadon WHERE MaHD = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, maHD);

            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {

        }
    }

    public boolean updateHoaDon(HoaDon hoaDon) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBConnect.getConnection();

            // Kiểm tra xem các giá trị mà bạn muốn cập nhật cho MaKH, IDNV, MaSach có tồn tại không
            String checkExistenceSQL = "SELECT COUNT(*) FROM khachhang WHERE MAKH = ?;"
                    + "SELECT COUNT(*) FROM nhanvien WHERE IDNV = ?;"
                    + "SELECT COUNT(*) FROM sach WHERE MASACH = ?;";
            ps = con.prepareStatement(checkExistenceSQL);
            ps.setString(1, hoaDon.getMaKhachHang());
            ps.setString(2, hoaDon.getMaNhanVien());
            ps.setString(3, hoaDon.getMaSach());

            // Thực hiện truy vấn kiểm tra
            ResultSet rs = ps.executeQuery();
            rs.next();
            int countKhachHang = rs.getInt(1);
            rs.next();
            int countNhanVien = rs.getInt(1);
            rs.next();
            int countSach = rs.getInt(1);

            // Kiểm tra nếu có bất kỳ giá trị nào không tồn tại trong các bảng tham chiếu
            if (countKhachHang == 0 || countNhanVien == 0 || countSach == 0) {
                System.out.println("Có một hoặc nhiều giá trị không tồn tại trong các bảng tham chiếu.");
                return false;
            }

            // Nếu các giá trị tồn tại, tiến hành câu lệnh UPDATE
            String updateSQL = "UPDATE hoadon SET MaKH = ?, IDNV = ?, MaSach = ?, SoLuong = ? WHERE MaHD = ?";
            ps = con.prepareStatement(updateSQL);
            ps.setString(1, hoaDon.getMaKhachHang());
            ps.setString(2, hoaDon.getMaNhanVien());
            ps.setString(3, hoaDon.getMaSach());
            ps.setInt(4, hoaDon.getSoLuong());
            ps.setObject(5, hoaDon.getMaHoaDon());

            int result = ps.executeUpdate();
            return result > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            try {
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
    }

    public int getDonGiaByMaSach(String maSach) {
        int donGia = 0;
        try {
            // Truy vấn đơn giá từ bảng Sách
            String query = "SELECT GiaMua FROM Sach WHERE MaSach = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, maSach);
            rs = ps.executeQuery();

            // Nếu có kết quả từ truy vấn
            if (rs.next()) {
                // Lấy đơn giá từ kết quả
                donGia = rs.getInt("GiaMua");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // Đóng tài nguyên
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return donGia;
    }

    public void addHoaDon(String maKH, String maNV, String maSach, int soLuong) {
        try {
            con = DBConnect.getConnection();
            Timestamp ngayLap = new Timestamp(System.currentTimeMillis());

            // Thêm hóa đơn vào cơ sở dữ liệu
            sql = "INSERT INTO hoadon (MAHD, MaKH, IDNV, MaSach, SoLuong, NgayLap) VALUES (NEWID(), ?, ?, ?, ?, ?)";

            ps = con.prepareStatement(sql);
            ps.setString(1, maKH);
            ps.setString(2, maNV);
            ps.setString(3, maSach);
            ps.setInt(4, soLuong);
            ps.setTimestamp(5, ngayLap);

            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<HoaDon> timHoaDonTheoMaHD(String maHD) {
        List<HoaDon> hoaDonList = new ArrayList<>();
        String sql = "SELECT * FROM hoadon WHERE MaHD LIKE ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + maHD + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hoaDon = new HoaDon();
                hoaDon.setMaHoaDon(rs.getString("MaHD"));
                hoaDon.setMaKhachHang(rs.getString("MaKH"));
                hoaDon.setMaNhanVien(rs.getString("IDNV"));
                hoaDon.setMaSach(rs.getString("MaSach"));
                hoaDon.setSoLuong(rs.getInt("SoLuong"));
                hoaDon.setNgayLap(rs.getTimestamp("NgayLap"));
                hoaDonList.add(hoaDon);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // Đóng tài nguyên
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
        return hoaDonList;
    }

    public List<HoaDon> timHoaDonTheoMaNV(String maNV) {
        List<HoaDon> hoaDonList = new ArrayList<>();
        String sql = "SELECT * FROM hoadon WHERE IDNV LIKE ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + maNV + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hoaDon = new HoaDon();
                hoaDon.setMaHoaDon(rs.getString("MaHD"));
                hoaDon.setMaKhachHang(rs.getString("MaKH"));
                hoaDon.setMaNhanVien(rs.getString("IDNV"));
                hoaDon.setMaSach(rs.getString("MaSach"));
                hoaDon.setSoLuong(rs.getInt("SoLuong"));
                hoaDon.setNgayLap(rs.getTimestamp("NgayLap"));
                hoaDonList.add(hoaDon);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // Đóng tài nguyên
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
        return hoaDonList;
    }

    // Tìm hóa đơn theo Mã Khách Hàng
    public List<HoaDon> timHoaDonTheoMaKH(String maKH) {
        List<HoaDon> hoaDonList = new ArrayList<>();
        String sql = "SELECT * FROM hoadon WHERE MaKH LIKE ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + maKH + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hoaDon = new HoaDon();
                hoaDon.setMaHoaDon(rs.getString("MaHD"));
                hoaDon.setMaKhachHang(rs.getString("MaKH"));
                hoaDon.setMaNhanVien(rs.getString("IDNV"));
                hoaDon.setMaSach(rs.getString("MaSach"));
                hoaDon.setSoLuong(rs.getInt("SoLuong"));
                hoaDon.setNgayLap(rs.getTimestamp("NgayLap"));
                hoaDonList.add(hoaDon);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // Đóng tài nguyên
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
        return hoaDonList;
    }

    // Tìm hóa đơn theo Mã Sách
    public List<HoaDon> timHoaDonTheoMaMS(String maSach) {
        List<HoaDon> hoaDonList = new ArrayList<>();
        String sql = "SELECT * FROM hoadon WHERE MaSach LIKE ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + maSach + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hoaDon = new HoaDon();
                hoaDon.setMaHoaDon(rs.getString("MaHD"));
                hoaDon.setMaKhachHang(rs.getString("MaKH"));
                hoaDon.setMaNhanVien(rs.getString("IDNV"));
                hoaDon.setMaSach(rs.getString("MaSach"));
                hoaDon.setSoLuong(rs.getInt("SoLuong"));
                hoaDon.setNgayLap(rs.getTimestamp("NgayLap"));
                hoaDonList.add(hoaDon);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // Đóng tài nguyên
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
        return hoaDonList;
    }

}
