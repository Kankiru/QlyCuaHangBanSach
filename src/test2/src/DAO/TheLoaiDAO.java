package DAO;

import DTO.TheLoaiDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import connection.jdbcHelper;


public class TheLoaiDAO {

    final String INSERT_SQL = "INSERT INTO THELOAI (MATL, THELOAI) VALUES (?, ?)";
    final String UPDATE_SQL = "UPDATE THELOAI SET THELOAI = ? WHERE MATL = ?";
    final String DELETE_SQL = "DELETE FROM THELOAI WHERE MATL = ?";
    final String SELECT_ALL_SQL = "SELECT MATL, THELOAI FROM THELOAI";
    final String SELECT_BY_ID_SQL = "SELECT MATL, THELOAI FROM THELOAI WHERE MATL = ?";

    public void insert(TheLoaiDTO entity) {
        jdbcHelper.update(INSERT_SQL, entity.getMaTL(), entity.getTenTL());
    }

    public void update(TheLoaiDTO entity) {
        jdbcHelper.update(UPDATE_SQL, entity.getTenTL(), entity.getMaTL());
    }

    public void delete(String id) {
        jdbcHelper.update(DELETE_SQL, id);
    }

    public List<TheLoaiDTO> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    public TheLoaiDTO selectById(String id) {
        List<TheLoaiDTO> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public List<TheLoaiDTO> selectBySql(String sql, Object... args) {
        List<TheLoaiDTO> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                TheLoaiDTO entity = new TheLoaiDTO();
                entity.setMaTL(rs.getString("MaTheLoai"));
                entity.setTenTL(rs.getString("TenTheLoai"));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
