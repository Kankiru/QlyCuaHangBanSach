/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1.NhaCungCap.service;

/**
 *
 * @author pc
 */
import Service1.DBConnect;
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
                NhaCungCap ncc = new NhaCungCap(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6), rs.getString(7));
                ListNCC.add(ncc);

            }
            return ListNCC;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
