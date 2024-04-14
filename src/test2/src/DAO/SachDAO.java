package DAO;

import DTO.SachDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import connection.jdbcHelper;

import javax.swing.*;

public class SachDAO extends EduSysDAO<SachDTO, String> {
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;
    
    final String INSERT_SQL = "INSERT INTO SACH (MASACH, MANXB, THELOAI, MATG, TENSACH, NAMXUATBAN, SOLUONG, GIAMUA, ANH) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    final String UPDATE_SQL = "UPDATE SACH SET MANXB = ?, THELOAI = ?, MATG = ?, TENSACH = ?, NAMXUATBAN = ?, SOLUONG = ?, GIAMUA = ?,ANH = ? WHERE MASACH = ?";
    final String DELETE_SQL = "DELETE FROM SACH WHERE MASACH = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM SACH";
    final String SELECT_BY_ID_SQL = "SELECT * FROM SACH WHERE MASACH = ?";
    final String DELETE_BY_ID_SQL = "DELETE FROM SACH WHERE MASACH = ?";

    @Override
    public void insert(SachDTO entity) {
        jdbcHelper.update(INSERT_SQL, entity.getMaSach(), entity.getMaNxb(), entity.getTheLoai(), entity.getMaTG(), entity.getTenSach(), entity.getNamXuatBan(), entity.getSoLuong(), entity.getGiaMua(),entity.getAnh());
    }

    @Override
    public void update(SachDTO entity) {
        jdbcHelper.update(UPDATE_SQL, entity.getMaNxb(), entity.getTheLoai(), entity.getMaTG(), entity.getTenSach(), entity.getNamXuatBan(), entity.getSoLuong(), entity.getGiaMua(),entity.getAnh(), entity.getMaSach());
    }

    @Override
    public void delete(String id) {
        jdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<SachDTO> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public SachDTO selectById(String id) {
        List<SachDTO> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<SachDTO> selectBySql(String sql, Object... args) {
        List<SachDTO> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                SachDTO entity = new SachDTO();
                entity.setMaSach(rs.getString("MASACH"));
                entity.setTenSach(rs.getString("TENSACH"));
                entity.setGiaMua(rs.getInt("GIAMUA"));
                entity.setAnh(rs.getString("ANH"));
                entity.setSoLuong(rs.getInt("SOLUONG"));
                entity.setNamXuatBan(rs.getInt("NAMXUATBAN"));
                entity.setMaNxb(rs.getString("MaNXB"));
                entity.setTheLoai(rs.getString("THELOAI"));
                entity.setMaTG(rs.getString("MATG"));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public boolean CheckSL(String masp, int sl) {
        for (SachDTO sp : selectAll()) {
            if (sp.getMaSach().equals(masp)) {
                if (sl > sp.getSoLuong()) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean updateSL(String MaSP, int SoLuong) {
        for (SachDTO sach : selectAll()) {
            if (sach.getMaSach().equals(MaSP)) {

                int old = sach.getSoLuong();
                if (SoLuong > old) {
                    JOptionPane.showMessageDialog(null, "Không đủ hàng");
                    return false;
                }
                old -= SoLuong;
                sach.setSoLuong(old);

                try {
                    SachDAO sachDAO = new SachDAO();
                    sachDAO.update(sach);
                } catch (Exception ex) {
                    System.out.println("Không thể cập nhật số Lượng.");
                }

                return true;
            }
        }
        return false;
    }

    public void deleteByMaSach(String maSach) {
        jdbcHelper.update(DELETE_BY_ID_SQL, maSach);
    }

    // Method to search for books based on multiple criteria
    public List<SachDTO> searchSach(String maSach, String maNXB, String maTG, String maTL,
            String tenSach, int namXBMin, int namXBMax, float minDonGia,
            float maxDonGia) {
        // Construct SQL query to search for books based on multiple criteria
        String SEARCH_SQL = "SELECT * FROM SACH WHERE MASACH LIKE ? AND MANXB LIKE ? AND MATG LIKE ? "
                + "AND THELOAI LIKE ? AND TENSACH LIKE ? AND NAMXUATBAN >= ? AND NAMXUATBAN <= ? "
                + "AND GIAMUA >= ? AND GIAMUA <= ?";

        // Initialize list to store search results
        List<SachDTO> searchResults = new ArrayList<>();

        try {
            // Execute SQL query with provided parameters
            ResultSet rs = jdbcHelper.query(SEARCH_SQL, "%" + maSach + "%", "%" + maNXB + "%",
                    "%" + maTG + "%", "%" + maTL + "%", "%" + tenSach + "%",
                    namXBMin, namXBMax, minDonGia, maxDonGia);

            // Iterate through the result set
            while (rs.next()) {
                SachDTO entity = new SachDTO();
                entity.setMaSach(rs.getString("MASACH"));
                entity.setTenSach(rs.getString("TENSACH"));
                entity.setGiaMua(rs.getInt("GIAMUA"));
                entity.setAnh(rs.getString("ANH"));
                entity.setSoLuong(rs.getInt("SOLUONG"));
                entity.setMaNxb(rs.getString("NAMXUATBAN"));
                entity.setTheLoai(rs.getString("THELOAI"));
                entity.setMaTG(rs.getString("MATG"));
                searchResults.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Return the search results
        return searchResults;
    }
       public int upDatee(String ma, SachDTO s){
        sql = "UPDATE SACH SET MANXB = ?, THELOAI = ?, MATG = ?, TENSACH = ?, NAMXUATBAN = ?, SOLUONG = ?, GIAMUA = ?,ANH = ? WHERE MASACH = ?";
        try {
            con = jdbcHelper.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, s.getMaNxb());
            ps.setObject(2, s.getTheLoai());
            ps.setObject(3, s.getMaTG());
            ps.setObject(4, s.getTenSach());
            ps.setObject(5, s.getNamXuatBan());
            ps.setObject(6, s.getSoLuong());
            ps.setObject(7, s.getGiaMua());
            ps.setObject(8, s.getAnh());
            ps.setObject(9, ma);
            
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
public List<SachDTO> timkiem(String ten){
        try {
            
            List<SachDTO> ListS = new ArrayList<>();
            sql = "SELECT MASACH,MANXB,THELOAI,MATG,TENSACH,NAMXUATBAN,SOLUONG,GIAMUA,ANH FROM SACH WHERE TENSACH LIKE ?";
             con = jdbcHelper.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, "%" + ten + "%");
            rs = ps.executeQuery();
            while(rs.next()){
                 SachDTO qls = new SachDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), 
                        rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getString(9));
                ListS.add(qls);
            }
            return ListS;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
