package DAO;


import DTO.TacGiaDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import connection.jdbcHelper;

public class TacGiaDAO extends EduSysDAO<TacGiaDTO, String> {

    private static final String INSERT_SQL = "INSERT INTO TACGIA (MATG, TENTG, DIACHI, SDT) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_SQL = "UPDATE TACGIA SET TENTG = ?, DIACHI = ?, SDT = ? WHERE MATG = ?";
    private static final String DELETE_SQL = "DELETE FROM TACGIA WHERE MATG = ?";
    private static final String SELECT_ALL_SQL = "SELECT MATG, TENTG, DIACHI, SDT FROM TACGIA";
    private static final String SELECT_BY_ID_SQL = "SELECT MATG, TENTG, DIACHI, SDT FROM TACGIA WHERE MATG = ?";

    @Override
    public void insert(TacGiaDTO entity) {
        jdbcHelper.update(INSERT_SQL, entity.getMaTG(), entity.getTenTG(), entity.getDiaChi(), entity.getSdt());
    }

    @Override
    public void update(TacGiaDTO entity) {
        jdbcHelper.update(UPDATE_SQL, entity.getTenTG(), entity.getDiaChi(), entity.getSdt(), entity.getMaTG());
    }

    @Override
    public void delete(String id) {
        jdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<TacGiaDTO> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public TacGiaDTO selectById(String id) {
        List<TacGiaDTO> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<TacGiaDTO> selectBySql(String sql, Object... args) {
        List<TacGiaDTO> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                TacGiaDTO entity = new TacGiaDTO();
                entity.setMaTG(rs.getString("MATG"));
                entity.setTenTG(rs.getString("TENTG"));
                entity.setDiaChi(rs.getString("DIACHI"));
                entity.setSdt(rs.getString("SDT"));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
