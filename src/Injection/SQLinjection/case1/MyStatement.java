package Injection.SQLinjection.case1;

import java.sql.Connection;
import java.sql.SQLException;

public class MyStatement {

    public int getOpening(Connection conn, String day)
            throws SQLException {
        String sql = "SELECT opens FROM hours WHERE day = '" + day +"'";
        try (var stmt = conn.createStatement();
             var rs = stmt.executeQuery(sql)) {
            if (rs.next())
                return rs.getInt("opens");
        }
        return -1;
    }
}
