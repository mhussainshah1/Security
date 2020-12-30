package Injection.SQLinjection.case3;

import java.sql.Connection;
import java.sql.SQLException;

public class MyPreparedStatement {
    public int getOpening(Connection conn, String day)
            throws SQLException {
        String sql = "SELECT opens FROM hours WHERE day = ?";
        try (var ps = conn.prepareStatement(sql)) {
            ps.setString(1, day);
            try (var rs = ps.executeQuery()) {
                if (rs.next())
                    return rs.getInt("opens");
            }
        }
        return -1;
    }
}