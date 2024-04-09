/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service1;


import Model1.KhachHang;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
                KhachHang kh = new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6));
                ListKH.add(kh);
            }
            return ListKH;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<KhachHang> add(String MAKH, String TENKH, String DIACHI, String Email, String SDT, Date NGSINH) {
        sql = "insert into khachhang (MAKH,TENKH, DIACHI, EMAIL, SDT, NgaySinh) values (?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            
            ps.setString(1, MAKH);
            ps.setString(2, TENKH);
            ps.setString(3, DIACHI);
            ps.setString(4, Email);
            ps.setString(5, SDT);

            SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
            String NgSinhStr = SDF.format(NGSINH);
            ps.setString(6, NgSinhStr);
            int add = ps.executeUpdate();
            if (add > 0) {

                KhachHang kh = new KhachHang(MAKH, TENKH, DIACHI, Email, SDT, NGSINH);
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
                String MAKH = rs.getString("MAKH");
                String TENKH = rs.getString("TENKH");
                String DIACHI = rs.getString("DIACHI");
                String email = rs.getString("EMAIL");
                String SDT = rs.getString("SDT");

                Date NgaySinh = rs.getDate("NgaySinh");

                KhachHang khachHang = new KhachHang(MAKH, TENKH, DIACHI, email, SDT, NgaySinh);
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
        sql = "delete from khachhang where makh = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setObject(1, UUID.fromString(MAKH));
            int i = ps.executeUpdate();
            if (i > 0) {
                ListKH.removeIf(kh -> kh.getMAKH().equals(MAKH));

            }
            return ListKH;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<KhachHang> Update(KhachHang khachhang) {
        sql = "update khachhang set tenkh =?, diachi =?,email =?,sdt =?,ngaysinh=? where makh=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, khachhang.getTENKH());
            ps.setString(2, khachhang.getDIACHI());
            ps.setString(3, khachhang.getEMAIL());
            ps.setString(4, khachhang.getSDT());
            ps.setDate(5, new Date(khachhang.getNgaySinh().getTime()));
            ps.setObject(6, UUID.fromString(khachhang.getMAKH()));
            int update = ps.executeUpdate();
            if (update > 0) {
                for (KhachHang khachHang : ListKH) {
                    if (khachHang.getMAKH().equals(khachHang.getMAKH())) {
                        khachHang.setTENKH(khachHang.getTENKH());
                        khachHang.setTENKH(khachHang.getTENKH());
                        khachHang.setDIACHI(khachHang.getDIACHI());
                        khachHang.setEMAIL(khachHang.getEMAIL());
                        khachHang.setSDT(khachHang.getSDT());
                        khachHang.setNgaySinh(khachHang.getNgaySinh());
                        break;
                    }
                }
            }
            return ListKH;

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }

    public List<KhachHang> searchMKH(String searchText) {
        ListKH = new ArrayList<>();
        sql = "select * from khachhang where makh like ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, searchText + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6));
                ListKH.add(kh);
            }
            return ListKH;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
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
                KhachHang kh = new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6));
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
                KhachHang kh = new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6));
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
                KhachHang kh = new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6));
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
                KhachHang kh = new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6));
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
                KhachHang kh = new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6));
                ListKH.add(kh);
            }
            return ListKH;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
