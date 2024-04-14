package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class jdbcHelper {

    private static final String USERNAME = "sa";
    private static final String PASSWORD = "123";
    private static final String SERVER = "localhost";
    private static final String PORT = "1433";
    private static final String DATABASE_NAME = "DA1";
    private static final boolean USING_SSL = true;

    private static String CONNECT_STRING;

    static {
        StringBuilder connectStringBuilder = new StringBuilder();
        connectStringBuilder.append("jdbc:sqlserver://")
                .append(SERVER).append(":").append(PORT).append(";")
                .append("databaseName=").append(DATABASE_NAME).append(";")
                .append("user=").append(USERNAME).append(";")
                .append("password=").append(PASSWORD).append(";");
        if (USING_SSL) {
            connectStringBuilder.append("encrypt=true;trustServerCertificate=true;");
        }
        CONNECT_STRING = connectStringBuilder.toString();
        System.out.println("Connect String có dạng: " + CONNECT_STRING);
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(CONNECT_STRING);
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(jdbcHelper.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static PreparedStatement getStmt(String sql, Object... args) throws SQLException {
        Connection conn = getConnection();
        PreparedStatement stmt;
        if (sql.trim().startsWith("[")) {
            stmt = conn.prepareCall(sql); // PROC
        } else {
            stmt = conn.prepareStatement(sql); // SQL
        }
        for (int i = 0; i < args.length; i++) {
            stmt.setObject(i + 1, args[i]);
        }
        return stmt;
    }

    public static ResultSet query(String sql, Object... args) throws SQLException {
        PreparedStatement stmt = jdbcHelper.getStmt(sql, args);
        return stmt.executeQuery();
    }

    public static int update(String sql, Object... args) {
        try (PreparedStatement stmt = jdbcHelper.getStmt(sql, args)) {
            return stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Object value(String sql, Object... args) {
        try (ResultSet rs = jdbcHelper.query(sql, args)) {
            if (rs.next()) {
                return rs.getObject(1);
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        try {

            Connection connection = jdbcHelper.getConnection();

            if (connection != null) {
                System.out.println("Kết nối thành công đến cơ sở dữ liệu!");

                connection.close();
            } else {
                System.out.println("Không thể kết nối đến cơ sở dữ liệu.");
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi khi kết nối đến cơ sở dữ liệu: " + ex.getMessage());
        }
    }

}
