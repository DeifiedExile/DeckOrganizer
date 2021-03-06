import java.sql.*;

public class DatabaseUtils {

    public static final String DRIVER_NAME = "jdbc:derby:";
    public static final String DATABASE_PATH = "/WEB-INF/lib/deckdb";
    public static final String USERNAME = "wolf";
    public static final String PASSWORD = "wolf";

    public static void closeAll(Connection conn, Statement stmt, ResultSet rset) {
        if (rset != null) {
            try {
                rset.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void closePstmt(PreparedStatement pstmt)
    {
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}

