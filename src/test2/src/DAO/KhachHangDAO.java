package DAO;

import DTO.KhachHangDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import connection.jdbcHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class KhachHangDAO extends EduSysDAO<KhachHangDTO, String> {
    

    final String INSERT_SQL = "INSERT INTO KHACHHANG (MAKH, TENKH, DIACHI, EMAIL, SDT, NgaySinh) VALUES (?, ?, ?, ?, ?, ?)";
    final String UPDATE_SQL = "UPDATE KHACHHANG SET TENKH = ?, EMAIL = ?, DIACHI = ?, SDT = ?,  NgaySinh = ? WHERE MAKH = ?";
    final String DELETE_SQL = "DELETE FROM KHACHHANG WHERE MAKH = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM KHACHHANG";
    final String SELECT_BY_ID_SQL = "SELECT * FROM KHACHHANG WHERE MAKH = ?";

    @Override
    public void insert(KhachHangDTO entity) {
        jdbcHelper.update(INSERT_SQL, entity.getMaKH(), entity.getTenKH(), entity.getEmail(), entity.getDiaChi(), entity.getSdt(),  entity.getNgaySinh());
    }

    @Override
    public void update(KhachHangDTO entity) {
        jdbcHelper.update(UPDATE_SQL, entity.getTenKH(), entity.getEmail(), entity.getDiaChi(), entity.getSdt(),  entity.getNgaySinh(), entity.getMaKH());
    }

    @Override
    public void delete(String id) {
        jdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<KhachHangDTO> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public KhachHangDTO selectById(String id) {
        List<KhachHangDTO> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<KhachHangDTO> selectBySql(String sql, Object... args) {
        List<KhachHangDTO> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                KhachHangDTO entity = new KhachHangDTO();
                entity.setMaKH(rs.getString("MAKH"));
                
                entity.setTenKH(rs.getString("TENKH"));
                entity.setDiaChi(rs.getNString("DIACHI"));
                entity.setEmail(rs.getString("EMAIL"));
               
                entity.setSdt(rs.getString("SDT"));
                entity.setNgaySinh(rs.getString("NgaySinh"));
                list.add(entity);
            }
        } catch (Exception e) {
//            throw new RuntimeException(e);
           e.printStackTrace();
        }
        return list;
    }
    
   
}
