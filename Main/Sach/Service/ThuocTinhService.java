/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main.Sach.Service;

import Main.Sach.Model.NhaXuatBan;
import Main.Sach.Model.SachModel;


import Main.Sach.Model.TacGia;
import Main.Sach.Model.TheLoai;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pc
 */
public class ThuocTinhService {

    List<TheLoai> ListTL;
    List<TacGia> ListTG;

  
    Connection con = DBConnect.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public boolean themTheLoai(String maTheLoai, String tenTheLoai) {
        try {
            // Chuẩn bị câu lệnh SQL
            sql = "INSERT INTO THELOAI (MATL, THELOAI) VALUES (?, ?)";

            // Tạo PreparedStatement và gán giá trị cho các tham số
            ps = con.prepareStatement(sql);
            ps.setString(1, maTheLoai);
            ps.setString(2, tenTheLoai);

            // Thực hiện câu lệnh SQL
            int rowsInserted = ps.executeUpdate();

            // Trả về true nếu thành công, ngược lại trả về false
            return rowsInserted > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean themTenSach(String maSach, String tenSach) {
        try {
            // Chuẩn bị câu lệnh SQL
            sql = "INSERT INTO SACH (MASACH, TENSACH) VALUES (?, ?)";

            // Tạo PreparedStatement và gán giá trị cho các tham số
            ps = con.prepareStatement(sql);
            ps.setString(1, maSach);
            ps.setString(2, tenSach);

            // Thực hiện câu lệnh SQL
            int rowsInserted = ps.executeUpdate();

            // Trả về true nếu thành công, ngược lại trả về false
            return rowsInserted > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean themTacGia(String maTacGia, String tenTacGia) {
        try {
            // Chuẩn bị câu lệnh SQL
            sql = "INSERT INTO TACGIA (MATG, TENTG) VALUES (?, ?)";

            // Tạo PreparedStatement và gán giá trị cho các tham số
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maTacGia);
            ps.setString(2, tenTacGia);

            // Thực hiện câu lệnh SQL
            int rowsInserted = ps.executeUpdate();

            // Trả về true nếu thành công, ngược lại trả về false
            return rowsInserted > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean themNhaXuatBan(String maNXB, String tenNXB) {
        try {
            // Chuẩn bị câu lệnh SQL
            sql = "INSERT INTO NHAXUATBAN (MANXB, TENNXB) VALUES (?, ?)";

            // Tạo PreparedStatement và gán giá trị cho các tham số
            ps = con.prepareStatement(sql);
            ps.setString(1, maNXB);
            ps.setString(2, tenNXB);

            // Thực hiện câu lệnh SQL
            int rowsInserted = ps.executeUpdate();

            // Trả về true nếu thành công, ngược lại trả về false
            return rowsInserted > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public List<SachModel> getTenSach() {
        List<SachModel> sachList = new ArrayList<>();
        try {
            // Chuẩn bị câu lệnh SQL
            sql = "SELECT Masach,TENSACH FROM SACH";

            // Tạo PreparedStatement và thực thi câu lệnh SQL
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            // Duyệt qua kết quả trả về và tạo các đối tượng SachModel từ dữ liệu
            while (rs.next()) {
                // Lấy thông tin từ ResultSet
                String maSach = rs.getString("maSACH");
                String tenSach = rs.getString("TENSACH");

                // Tạo đối tượng SachModel và thêm vào danh sách
                SachModel sach = new SachModel();
                sach.setMaSach(maSach);
                sach.setTenSach(tenSach);
                sachList.add(sach);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return sachList;
    }

    public List<TheLoai> getTheLoai() {
        List<TheLoai> theLoaiList = new ArrayList<>();
        try {
            // Chuẩn bị câu lệnh SQL
            sql = "SELECT  * FROM THELOAI";

            // Tạo PreparedStatement và thực thi câu lệnh SQL
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            // Duyệt qua kết quả trả về và tạo các đối tượng TheLoai từ dữ liệu
            while (rs.next()) {
                // Lấy thông tin từ ResultSet

                String maTL = rs.getString("matl");
                String tenTL = rs.getString("THELOAI");

                // Tạo đối tượng TheLoai và thêm vào danh sách
                TheLoai theLoai = new TheLoai();

                theLoai.setMaTheLoai(maTL);
                theLoai.setTenTheLoai(tenTL);
                theLoaiList.add(theLoai);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return theLoaiList;
    }

    public List<TacGia> getTacGia() {
        List<TacGia> tacGiaList = new ArrayList<>();
        try {
            // Chuẩn bị câu lệnh SQL
            sql = "SELECT *FROM TACGIA";

            // Tạo PreparedStatement và thực thi câu lệnh SQL
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            // Duyệt qua kết quả trả về và tạo các đối tượng TacGia từ dữ liệu
            while (rs.next()) {
                // Lấy thông tin từ ResultSet

                String maTG = rs.getString("maTG");
                String tenTG = rs.getString("TENTG");

                // Tạo đối tượng TacGia và thêm vào danh sách
                TacGia tacGia = new TacGia();

                tacGia.setMaTacGia(maTG);
                tacGia.setTenTacGia(tenTG);
                tacGiaList.add(tacGia);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return tacGiaList;
    }

    public List<NhaXuatBan> getNXB() {
        List<NhaXuatBan> nxbList = new ArrayList<>();
        try {
            // Chuẩn bị câu lệnh SQL
            sql = "SELECT  * FROM NHAXUATBAN";

            // Tạo PreparedStatement và thực thi câu lệnh SQL
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            // Duyệt qua kết quả trả về và tạo các đối tượng NhaXuatBan từ dữ liệu
            while (rs.next()) {
                // Lấy thông tin từ ResultSet

                String maNXB = rs.getString("maNXB");
                String tenNXB = rs.getString("TENNXB");

                // Tạo đối tượng NhaXuatBan và thêm vào danh sách
                NhaXuatBan nxb = new NhaXuatBan();

                nxb.setMaNXB(maNXB);
                nxb.setTenNXB(tenNXB);
                nxbList.add(nxb);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return nxbList;
    }

    public boolean suaTheLoai(String maTheLoai, String tenTheLoai) {
        try {
            // Chuẩn bị câu lệnh SQL
            sql = "UPDATE THELOAI SET THELOAI = ? WHERE MATL = ?";

            // Tạo PreparedStatement và gán giá trị cho các tham số
            ps = con.prepareStatement(sql);
            ps.setString(1, tenTheLoai);
            ps.setString(2, maTheLoai);

            // Thực hiện câu lệnh SQL
            int rowsUpdated = ps.executeUpdate();

            // Trả về true nếu thành công, ngược lại trả về false
            return rowsUpdated > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean suaTacGia(String maTacGia, String tenTacGia) {
        try {
            // Chuẩn bị câu lệnh SQL
            sql = "UPDATE TACGIA SET TENTG = ? WHERE MATG = ?";

            // Tạo PreparedStatement và gán giá trị cho các tham số
            ps = con.prepareStatement(sql);
            ps.setString(1, tenTacGia);
            ps.setString(2, maTacGia);

            // Thực hiện câu lệnh SQL
            int rowsUpdated = ps.executeUpdate();

            // Trả về true nếu thành công, ngược lại trả về false
            return rowsUpdated > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean suaNhaXuatBan(String maNXB, String tenNXB) {
        try {
            // Chuẩn bị câu lệnh SQL
            sql = "UPDATE NHAXUATBAN SET TENNXB = ? WHERE MANXB = ?";

            // Tạo PreparedStatement và gán giá trị cho các tham số
            ps = con.prepareStatement(sql);
            ps.setString(1, tenNXB);
            ps.setString(2, maNXB);

            // Thực hiện câu lệnh SQL
            int rowsUpdated = ps.executeUpdate();

            // Trả về true nếu thành công, ngược lại trả về false
            return rowsUpdated > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean suaTenSach(String maSach, String tenSach) {
        try {
            // Chuẩn bị câu lệnh SQL
            sql = "UPDATE SACH SET TENSACH = ? WHERE MASACH = ?";

            // Tạo PreparedStatement và gán giá trị cho các tham số
            ps = con.prepareStatement(sql);
            ps.setString(1, tenSach);
            ps.setString(2, maSach);

            // Thực hiện câu lệnh SQL
            int rowsUpdated = ps.executeUpdate();

            // Trả về true nếu thành công, ngược lại trả về false
            return rowsUpdated > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean xoaTheLoai(String maTheLoai) {
        try {
            // Chuẩn bị câu lệnh SQL
            sql = "DELETE FROM THELOAI WHERE MATL = ?";

            // Tạo PreparedStatement và gán giá trị cho tham số
            ps = con.prepareStatement(sql);
            ps.setString(1, maTheLoai);

            // Thực thi câu lệnh SQL
            int rowsDeleted = ps.executeUpdate();

            // Trả về true nếu có ít nhất một dòng bị xóa, ngược lại trả về false
            return rowsDeleted > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean xoaTacGia(String maTacGia) {
        try {
            // Chuẩn bị câu lệnh SQL
            sql = "DELETE FROM TACGIA WHERE MATG = ?";

            // Tạo PreparedStatement và gán giá trị cho tham số
            ps = con.prepareStatement(sql);
            ps.setString(1, maTacGia);

            // Thực thi câu lệnh SQL
            int rowsDeleted = ps.executeUpdate();

            // Trả về true nếu có ít nhất một dòng bị xóa, ngược lại trả về false
            return rowsDeleted > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean xoaNhaXuatBan(String maNXB) {
        try {
            // Chuẩn bị câu lệnh SQL
            sql = "DELETE FROM NHAXUATBAN WHERE MANXB = ?";

            // Tạo PreparedStatement và gán giá trị cho tham số
            ps = con.prepareStatement(sql);
            ps.setString(1, maNXB);

            // Thực thi câu lệnh SQL
            int rowsDeleted = ps.executeUpdate();

            // Trả về true nếu có ít nhất một dòng bị xóa, ngược lại trả về false
            return rowsDeleted > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean xoaTenSach(String maSach) {
        try {
            // Chuẩn bị câu lệnh SQL
            sql = "DELETE FROM SACH WHERE MASACH = ?";

            // Tạo PreparedStatement và gán giá trị cho tham số
            ps = con.prepareStatement(sql);
            ps.setString(1, maSach);

            // Thực thi câu lệnh SQL
            int rowsDeleted = ps.executeUpdate();

            // Trả về true nếu có ít nhất một dòng bị xóa, ngược lại trả về false
            return rowsDeleted > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean themSach(String maSach, String tenSach, String theLoai, String tacGia, String nxb, String namXuatBan, String soLuong, String donGia) {
        try {
            // Chuẩn bị câu lệnh SQL để thêm sách vào cơ sở dữ liệu
           sql = "INSERT INTO SACH (MaSach, TenSach, TheLoai, matg, MaNXB, NamXuatBan, SoLuong, giamua) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
           ps = con.prepareStatement(sql);

            // Thiết lập các tham số cho câu lệnh SQL
            ps.setString(1, maSach);
            ps.setString(2, tenSach);
            ps.setString(3, theLoai);
            ps.setString(4, tacGia);
            ps.setString(5, nxb);
            ps.setString(6, namXuatBan);
            ps.setString(7, soLuong);
            ps.setString(8, donGia);

            // Thực thi câu lệnh SQL để thêm sách
            int rowsAffected = ps.executeUpdate();

            // Kiểm tra xem có sách đã được thêm thành công hay không
            if (rowsAffected > 0) {
                return true; // Trả về true nếu thêm sách thành công
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false; // Trả về false nếu thêm sách không thành công
    }

    public boolean suaSach(String maSach, String tenSach, String theLoai, String tacGia, String nxb, String namXuatBan, String soLuong, String donGia) {
        try {
            // Chuẩn bị câu lệnh SQL để cập nhật thông tin sách trong cơ sở dữ liệu
            sql = "UPDATE SACH SET TenSach = ?, TheLoai = ?, matg= ?, MaNXB = ?, NamXuatBan = ?, SoLuong = ?, giamua = ? WHERE MaSach = ?";
          ps = con.prepareStatement(sql);

            // Thiết lập các tham số cho câu lệnh SQL
            ps.setString(1, tenSach);
            ps.setString(2, theLoai);
            ps.setString(3, tacGia);
            ps.setString(4, nxb);
            ps.setString(5, namXuatBan);
            ps.setString(6, soLuong);
            ps.setString(7, donGia);
            ps.setString(8, maSach);

            // Thực thi câu lệnh SQL để cập nhật sách
            int rowsAffected = ps.executeUpdate();

            // Kiểm tra xem có sách đã được cập nhật thành công hay không
            if (rowsAffected > 0) {
                return true; // Trả về true nếu cập nhật sách thành công
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false; // Trả về false nếu cập nhật sách không thành công
    }

    public boolean xoaSach(String maSach) {
        try {
            // Chuẩn bị câu lệnh SQL để xóa sách khỏi cơ sở dữ liệu
           sql = "DELETE FROM SACH WHERE MaSach = ?";
            ps = con.prepareStatement(sql);

            // Thiết lập tham số cho câu lệnh SQL
            ps.setString(1, maSach);

            // Thực thi câu lệnh SQL để xóa sách
            int rowsAffected = ps.executeUpdate();

            // Kiểm tra xem có sách đã được xóa thành công hay không
            if (rowsAffected > 0) {
                return true; // Trả về true nếu xóa sách thành công
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false; // Trả về false nếu xóa sách không thành công
    }

}
