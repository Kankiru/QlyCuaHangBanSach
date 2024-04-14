package DAO;


import DTO.KhuyenMaiDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import connection.jdbcHelper;

public class KhuyenMaiDAO extends EduSysDAO<KhuyenMaiDTO, String> {

    final String INSERT_SQL = "INSERT INTO KHUYENMAI (MAKM, TENKHUYENMAI, NGAYBATDAU, NGAYKETTHUC, GIAMGIA, TRANGTHAI) VALUES (?, ?, ?, ?, ?, ?)";
    final String UPDATE_SQL = "UPDATE KHUYENMAI SET TENKHUYENMAI = ?, NGAYBATDAU = ?, NGAYKETTHUC = ?, GIAMGIA = ?, TRANGTHAI = ? WHERE MAKM = ?";
    final String DELETE_SQL = "DELETE FROM KHUYENMAI WHERE MAKM = ?";
    final String SELECT_ALL_SQL = "SELECT MAKM, TENKHUYENMAI, NGAYBATDAU, NGAYKETTHUC, GIAMGIA, TRANGTHAI FROM KHUYENMAI";
    final String SELECT_BY_ID_SQL = "SELECT MAKM, TENKHUYENMAI, NGAYBATDAU, NGAYKETTHUC, GIAMGIA, TRANGTHAI FROM KHUYENMAI WHERE MAKM = ?";
    final String DATE_SQL = "SELECT MAKM, TENKHUYENMAI, NGAYBATDAU, NGAYKETTHUC, GIAMGIA, TRANGTHAI FROM KHUYENMAI WHERE NGAYBATDAU >= ? AND NGAYKETTHUC <= ?";
    final String SELECT_BY_CODE_SQL = "SELECT * FROM KHUYENMAI WHERE MAKM = ?";

    @Override
    public void insert(KhuyenMaiDTO entity) {
        jdbcHelper.update(INSERT_SQL, entity.getMaKM(), entity.getTenKM(), entity.getNgayDB(), entity.getNgayKT(), entity.getGiamGia(), entity.getTrangThai());
    }

    @Override
    public void update(KhuyenMaiDTO entity) {
        jdbcHelper.update(UPDATE_SQL, entity.getTenKM(), entity.getNgayDB(), entity.getNgayKT(), entity.getGiamGia(), entity.getTrangThai(), entity.getMaKM());
    }

    @Override
    public void delete(String id) {
        jdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<KhuyenMaiDTO> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public KhuyenMaiDTO selectById(String id) {
        List<KhuyenMaiDTO> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<KhuyenMaiDTO> selectBySql(String sql, Object... args) {
        List<KhuyenMaiDTO> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                KhuyenMaiDTO entity = new KhuyenMaiDTO();
                entity.setMaKM(rs.getString("MaKM"));
               
                entity.setTenKM(rs.getString("TENKHUYENMAI"));
                entity.setNgayDB(rs.getString("NGAYBATDAU"));
                entity.setNgayKT(rs.getString("NGAYKETTHUC"));
                entity.setGiamGia(rs.getInt("GIAMGIA"));
                entity.setTrangThai(rs.getString("TRANGTHAI"));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        // e.printStackTrace();
        }
        return list;
    }

    public List<KhuyenMaiDTO> find(Date startDate, Date endDate) {
        List<KhuyenMaiDTO> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(DATE_SQL, new java.sql.Date(startDate.getTime()), new java.sql.Date(endDate.getTime()));
            while (rs.next()) {
                KhuyenMaiDTO entity = new KhuyenMaiDTO();
                entity.setMaKM(rs.getString("MaKM"));
                entity.setTenKM(rs.getString("TENKHUYENMAI"));
                entity.setNgayDB(rs.getString("NGAYBATDAU"));
                entity.setNgayKT(rs.getString("NGAYKETTHUC"));
                entity.setGiamGia(rs.getInt("GIAMGIA"));
                entity.setTrangThai(rs.getString("TRANGTHAI"));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public KhuyenMaiDTO getVoucherByMaVoucher(String maVoucher) {
        String query = "SELECT * FROM KHUYENMAI WHERE MAKM = ?";
        try {
            ResultSet rs = jdbcHelper.query(query, maVoucher);
            if (rs.next()) {
                KhuyenMaiDTO voucher = new KhuyenMaiDTO();
                voucher.setMaKM(rs.getString("MaKM"));
                voucher.setTenKM(rs.getString("TENKHUYENMAI"));
                voucher.setNgayDB(rs.getString("NGAYBATDAU"));
                voucher.setNgayKT(rs.getString("NGAYKETTHUC"));
                voucher.setGiamGia(rs.getInt("GIAMGIA"));
                voucher.setTrangThai(rs.getString("TRANGTHAI"));
                return voucher;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}
