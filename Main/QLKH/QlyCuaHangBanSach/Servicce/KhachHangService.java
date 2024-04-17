/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main.QLKH.QlyCuaHangBanSach.Servicce;

import Main.QLKH.QlyCuaHangBanSach.Model.KhachHang;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class KhachHangService {

    List<KhachHang> ListKH;
    Connection con = DBConnect.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public List<KhachHang> getAll() {
        ListKH = new ArrayList<>();
        sql = "select * from khachhang";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5));
                ListKH.add(kh);
            }
            return ListKH;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<KhachHang> add( String TENKH, String DIACHI, String Email, String SDT, Date NGSINH) {
        sql = "insert into khachhang (TENKH, DIACHI, EMAIL, SDT, NgaySinh) values (?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, TENKH);
            ps.setString(2, DIACHI);
            ps.setString(3, Email);
            ps.setString(4, SDT);

            SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
            String NgSinhStr = SDF.format(NGSINH);
            ps.setString(5, NgSinhStr);
            int add = ps.executeUpdate();
            if (add > 0) {

                KhachHang kh = new KhachHang(TENKH, DIACHI, Email, SDT, NGSINH);
                ListKH.add(kh);
            }
            return ListKH;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<KhachHang> checkEmailExists(String EMAIL) {
        ListKH = new ArrayList<>();
        sql = "select * from khachhang where email =?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, EMAIL);
            rs = ps.executeQuery();
            while (rs.next()) {

                String TENKH = rs.getString("TENKH");
                String DIACHI = rs.getString("DIACHI");
                String email = rs.getString("EMAIL");
                String SDT = rs.getString("SDT");

                Date NgaySinh = rs.getDate("NgaySinh");

                KhachHang khachHang = new KhachHang(TENKH, DIACHI, email, SDT, NgaySinh);
                ListKH.add(khachHang);
            }
            return ListKH;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int count() {
        int count = 0;
        sql = "select count(*) from khachhang ";
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

    public List<KhachHang> Delete(String MAKH) {

        try {
            // Xóa các bản ghi từ bảng CTVOUCHER có trường MAHD tham chiếu từ HOADON
            sql = "DELETE FROM CTVOUCHER WHERE MAHD IN (SELECT MAHD FROM HOADON WHERE tenKH = ?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, MAKH);
            ps.executeUpdate();

            // Xóa các bản ghi từ bảng HOADONCT có trường MAHD tham chiếu từ HOADON
            sql = "DELETE FROM HOADONCT WHERE MAHD IN (SELECT MAHD FROM HOADON WHERE tenKH = ?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, MAKH);
            ps.executeUpdate();

            // Xóa các hóa đơn từ bảng HOADON có trường MAKH tương ứng
            sql = "DELETE FROM HOADON WHERE tenkh = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, MAKH);
            ps.executeUpdate();

            // Xóa khách hàng từ bảng KHACHHANG
            sql = "DELETE FROM KHACHHANG WHERE tenKH = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, MAKH);
            int i = ps.executeUpdate();

            // Nếu xóa thành công, cập nhật ListKH
            if (i > 0) {
                ListKH.removeIf(kh -> kh.getTENKH().equals(MAKH));
            }

            return ListKH;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<KhachHang> Update(KhachHang khachhang) {
        sql = "UPDATE khachhang SET diachi = ?, email = ?, sdt = ?, ngaysinh = ? WHERE tenkh = ?";
        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, khachhang.getDIACHI());
            ps.setString(2, khachhang.getEMAIL());
            ps.setString(3, khachhang.getSDT());
            ps.setDate(4, new Date(khachhang.getNgaySinh().getTime()));
            ps.setString(5, khachhang.getTENKH());
            int update = ps.executeUpdate();
            if (update > 0) {
                for (KhachHang kh : ListKH) {
                    if (kh.getTENKH().equals(khachhang.getTENKH())) {
                        kh.setDIACHI(khachhang.getDIACHI());
                        kh.setEMAIL(khachhang.getEMAIL());
                        kh.setSDT(khachhang.getSDT());
                        kh.setNgaySinh(khachhang.getNgaySinh());
                        break;
                    }
                }
            }
            return ListKH;
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Trả về null nếu có lỗi xảy ra
        }
    }

    public List<KhachHang> searchTKH(String searchText) {
        ListKH = new ArrayList<>();
        sql = "select * from khachhang where tenkh like ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, searchText + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5));
                ListKH.add(kh);
            }
            return ListKH;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<KhachHang> searchDiaChi(String searchText) {
        ListKH = new ArrayList<>();
        sql = "select * from khachhang where diachi like ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, searchText + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5));
                ListKH.add(kh);
            }
            return ListKH;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<KhachHang> searchEmail(String searchText) {
        ListKH = new ArrayList<>();
        sql = "select * from khachhang where email like ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, searchText + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5));
                ListKH.add(kh);
            }
            return ListKH;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<KhachHang> searchSDT(String searchText) {
        ListKH = new ArrayList<>();
        sql = "select * from khachhang where sdt like ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, searchText + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang( rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5));
                ListKH.add(kh);
            }
            return ListKH;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<KhachHang> searchNS(String searchText) {
        ListKH = new ArrayList<>();
        sql = "select * from khachhang where ngaysinh like ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, searchText + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang( rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5));
                ListKH.add(kh);
            }
            return ListKH;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<String> getMaKHList() {
        List<String> maKHList = new ArrayList<>();
        sql = "SELECT tenKH FROM KHACHHANG";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                maKHList.add(rs.getString("tenKH"));
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
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return maKHList;
    }

}
