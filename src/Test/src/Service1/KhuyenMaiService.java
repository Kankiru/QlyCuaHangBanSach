/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1.GiamGia.Service;

import Service1.DBConnect;
import duan1.GiamGia.model.KhuyenMai;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class KhuyenMaiService {

    List<KhuyenMai> ListKM;
    Connection con = DBConnect.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public List<KhuyenMai> getAll() {
        ListKM = new ArrayList<>();
        sql = "select * from khuyenmai";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                KhuyenMai km = new KhuyenMai(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getDate(4), rs.getInt(6), rs.getString(5));
                ListKM.add(km);
            }
            return ListKM;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<KhuyenMai> add(String MAKM, String tenKM, Timestamp NBD, Timestamp NKT, int GG, String TT) {
        sql = "insert into khuyenmai (MAKM,tenkhuyenmai,ngaybatdau,ngayketthuc,giamgia,trangthai) values (?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, MAKM);
            ps.setString(2, tenKM);

            SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
            String NBDStr = SDF.format(NBD);
            String NKTStr = SDF.format(NKT);
            ps.setString(3, NBDStr);
            ps.setString(4, NKTStr);
            ps.setInt(5, GG);
            ps.setString(6, TT);
            int add = ps.executeUpdate();
            if (add > 0) {

                KhuyenMai km = new KhuyenMai(MAKM, tenKM, NBD, NKT, GG, TT);
                ListKM.add(km);
            }
            return ListKM;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<KhuyenMai> updateKhuyenMai(KhuyenMai khuyenMai) {
        sql = "UPDATE KHUYENMAI SET TENKHUYENMAI = ?, NGAYBATDAU = ?, NGAYKETTHUC = ?,GIAMGIA = ?, TRANGTHAI = ? WHERE MAKM = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, khuyenMai.getTENKHUYENMAI());

            ps.setDate(2, new Date(khuyenMai.getNGAYBATDAU().getTime()));
            ps.setDate(3, new Date(khuyenMai.getNGAYKETTHUC().getTime()));
            ps.setInt(4, khuyenMai.getGIAMGIA());
            ps.setString(5, khuyenMai.getTRANGTHAI());

            ps.setString(6, khuyenMai.getMAKM());

            int update = ps.executeUpdate();
            if (update > 0) {
                for (KhuyenMai km : ListKM) {
                    if (km.getMAKM().equals(khuyenMai.getMAKM())) {
                        km.setTENKHUYENMAI(khuyenMai.getTENKHUYENMAI());
                        
                        km.setNGAYBATDAU(khuyenMai.getNGAYBATDAU());
                        km.setNGAYKETTHUC(khuyenMai.getNGAYKETTHUC());
                        km.setGIAMGIA(khuyenMai.getGIAMGIA());
                        km.setTRANGTHAI(khuyenMai.getTRANGTHAI());
                        break;
                    }
                }
            }
            return ListKM;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<KhuyenMai> Delete(String MAKM) {
        sql = "delete from khuyenmai where makm = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, MAKM);
            int i = ps.executeUpdate();
            if (i > 0) {
                ListKM.removeIf(kh -> kh.getMAKM().equals(MAKM));

            }
            return ListKM;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<KhuyenMai> getAllMaKhuyenMai() {
        ListKM = new ArrayList<>();
        sql = "select MAKM from Khuyenmai";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String makm = rs.getString(1);
                KhuyenMai km = new KhuyenMai();
                km.setMAKM(makm);
                ListKM.add(km);
            }
            return ListKM;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<KhuyenMai> Search(Date NBD, Date NKT) {
        ListKM = new ArrayList<>();
        sql = "SELECT * FROM Khuyenmai WHERE (ngaybatdau BETWEEN ? AND ?) OR (ngayketthuc BETWEEN ? AND ?) OR (ngaybatdau <= ? AND ngayketthuc >= ?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setDate(1, NBD);
            ps.setDate(2, NKT);
            ps.setDate(3, NBD);
            ps.setDate(4, NBD);
            ps.setDate(5, NKT);
            ps.setDate(6, NKT);
            rs = ps.executeQuery();
            while (rs.next()) {
                KhuyenMai km = new KhuyenMai(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getDate(4), rs.getInt(5), rs.getString(6));
                ListKM.add(km);

            }
            return ListKM;
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }

    }

    public int count() {
        int count = 0;
        sql = "select count(*) from khuyenmai ";
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

}
