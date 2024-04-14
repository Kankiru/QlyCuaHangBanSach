package DAO;

import DTO.HoaDonDTO;
import connection.jdbcHelper;
import java.sql.*;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.List;

public class HoaDonDAO {

    Connection conn;
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;

    public HoaDonDAO() {
        conn = jdbcHelper.getConnection();
    }

    public ArrayList<HoaDonDTO> List() {
        ArrayList<HoaDonDTO> DSHoaDon = new ArrayList<>();
        try {
            String sql = "select * from HOADON";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String MaHD = rs.getString("MAHD");
                String MaKH = rs.getString("MAKH");
                String MaNV = rs.getString("IDNV");
                String MaGG = rs.getString("NGAYLAP");
                String NgayLap = rs.getString("MAKM");
                int TongTien = Integer.parseInt(rs.getString("TONGTIEN"));
                int GiamGia = Integer.parseInt(rs.getString("GIAMGIA"));
                int ThanhTien = Integer.parseInt(rs.getString("THANHTIEN"));
                HoaDonDTO hd = new HoaDonDTO(MaHD, MaKH, MaNV,  NgayLap,MaGG, TongTien, GiamGia, ThanhTien);
                DSHoaDon.add(hd);
            }
            rs.close();
        } catch (Exception ex) {
            System.out.print("HoaDonDAO khong tai duoc");
        }

        return DSHoaDon;
    }

    public void Sua(HoaDonDTO hd) {

        try {
            String maKM = hd.getMaKM().equals("") ? null : "'" + hd.getMaKM()+ "'";
            String sql = "UPDATE HOADON SET ";
            sql += "MAHD='" + hd.getMaHD()+ "',";
            sql += "MAKH='" + hd.getMaKH() + "',";
            sql += "IDNV='" + hd.getIdNV()+ "',";
             sql += "NGAYLAP='" + hd.getNgayLap()+ "',";
            sql += "MAKM=" + maKM + ",";
            sql += "TONGTIEN='" + hd.getTongTien() + "',";
            sql += "GIAMGIA='" + hd.getGiamGia() + "',";
            sql += "THANHTIEN='" + hd.getThanhTien() + "' ";
            sql += "WHERE MAHD='" + hd.getMaHD()+ "'";
            PreparedStatement stmt = conn.prepareStatement(sql);
            int n = stmt.executeUpdate();
        } catch (Exception ex) {
            System.out.print("HDDAO sua that bai");
        }
    }

    public void Xoa(String MaHD) {
        String sql = "DELETE FROM HOADON WHERE MAHD='" + MaHD + "'";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            int n = stmt.executeUpdate();
        } catch (Exception ex) {
            System.out.print("HoaDonDAO xoa khong duoc.");
        }
        System.out.println(sql);
    }

    public void Them(HoaDonDTO hd) {
        String maVoucher = "VC1";
        String sql = "INSERT INTO HOADON([MAHD], [MAKH],[IDNV], [NGAYLAP], [MAKM], [TONGTIEN], [GIAMGIA], [THANHTIEN]) VALUES (";
        sql += "'" + hd.getMaHD()+ "',";
        sql += "'" + hd.getMaKH() + "',";
        sql += "'" + hd.getIdNV()+ "',";
        sql += "'" + hd.getNgayLap() + "',";
        sql += "'" + maVoucher + "',";
        sql += "'" + hd.getTongTien() + "',";
        sql += "'" + hd.getGiamGia() + "',";
        sql += "'" + hd.getThanhTien() + "')";
        try {
            System.out.print("Them." + sql);
            PreparedStatement stmt = conn.prepareStatement(sql);
            int n = stmt.executeUpdate();
        } catch (Exception ex) {
            System.out.print("HDDAO khong them duoc.");
        }

    }

    public String AutoMaHD() {
        int max = 0;
        String s = "";
        for (HoaDonDTO hd : List()) {
            int id = Integer.parseInt(hd.getMaHD().replace("HD", "").trim());
            if (id > max) {
                max = id;
            }
        }

        return s + (max + 1);
    }

    public int set(HoaDonDTO hd) {
        List<HoaDonDTO> ls = List();
        for (int i = 0; i < ls.size(); i++) {
            if (ls.get(i).getMaHD().equals(hd.getMaHD())) {
                ls.set(i, hd);
                HoaDonDAO HDDAO = new HoaDonDAO();
                HDDAO.Sua(hd);
                return i;
            }
        }
        return -1;
    }
//     public static void main(String []args){
//           MySQLConnect c=new MySQLConnect("localhost","root","","bookstore");
//           String sql="UPDATE hoadon SET MaHD='HD03',MaKH='a11',MaNV='A01',MaGG='GG01',NgayLapHD='2020-04-04',TongTien='12',GiamGia='11',ThanhTien='1' WHERE MaHD='HD03'";
//           try {
//               c.excuteUpdate(sql);
//           } catch (Exception ex) {
//               System.out.print("abc");
//           }
//   }
    public List<HoaDonDTO> timkiemMHD(String maHD){
        try {
            List<HoaDonDTO> ListH = new ArrayList<>();
            sql = "select * from HOADON where MAHD like ?";
            con = jdbcHelper.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, "%" + maHD + "%");
            rs = ps.executeQuery();
             while (rs.next()) {
               HoaDonDTO bs = new HoaDonDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), 
                       rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8));
                ListH.add(bs);
            }
             return ListH;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
     
    public List<HoaDonDTO> timkiemMKH(String maKH){
        try {
            List<HoaDonDTO> ListH = new ArrayList<>();
            sql = "select * from HOADON where MAKH like ?";
            con = jdbcHelper.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, "%" + maKH + "%");
            rs = ps.executeQuery();
             while (rs.next()) {
              HoaDonDTO bs = new HoaDonDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), 
                       rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8));
                ListH.add(bs);
            }
             return ListH;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
     public List<HoaDonDTO> timkiemMNV(String maNV){
        try {
            List<HoaDonDTO> ListH = new ArrayList<>();
            sql = "select * from HOADON where IDNV like ?";
            con = jdbcHelper.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, "%" + maNV + "%");
            rs = ps.executeQuery();
             while (rs.next()) {
               HoaDonDTO bs = new HoaDonDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), 
                       rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8));
                ListH.add(bs);
            }
             return ListH;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
