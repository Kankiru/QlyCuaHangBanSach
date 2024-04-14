package DAO;

import DTO.NhaXuatBanDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import connection.jdbcHelper;


public class NhaXuatBanDAO extends EduSysDAO<NhaXuatBanDTO, String> {

    final String INSERT_SQL = "INSERT INTO NHAXUATBAN (MANXB, TENNXB, DIACHI, EMAIL, SDT) VALUES (?, ?, ?, ? ,?)";
    final String UPDATE_SQL = "UPDATE NHAXUATBAN SET TENNXB=?, DIACHI=?, EMAIL=? ,SDT=? WHERE MANXB=?";
    final String DELETE_SQL = "DELETE FROM NHAXUATBAN WHERE MANXB=?";
    final String SELECT_ALL_SQL = "SELECT * FROM NHAXUATBAN";
    final String SELECT_BY_ID_SQL = "SELECT * FROM NHAXUATBAN WHERE MANXB=?";

    @Override
    public void insert(NhaXuatBanDTO entity) {
        jdbcHelper.update(INSERT_SQL, entity.getMaNXB(), entity.getTenNXB(), entity.getDiaChi(),entity.getEmail(), entity.getSDT());
    }

    @Override
    public void update(NhaXuatBanDTO entity) {
        jdbcHelper.update(UPDATE_SQL, entity.getTenNXB(), entity.getDiaChi(),entity.getEmail(), entity.getSDT(), entity.getMaNXB());
    }

    @Override
    public void delete(String id) {
        jdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<NhaXuatBanDTO> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public NhaXuatBanDTO selectById(String id) {
        List<NhaXuatBanDTO> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<NhaXuatBanDTO> selectBySql(String sql, Object... args) {
        List<NhaXuatBanDTO> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                NhaXuatBanDTO entity = new NhaXuatBanDTO();
                entity.setMaNXB(rs.getString("MANXB"));
                entity.setTenNXB(rs.getNString("TENNXB"));
                entity.setDiaChi(rs.getNString("DIACHI"));
                entity.setEmail(rs.getString("EMAIL"));
                entity.setSDT(rs.getString("SDT"));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
