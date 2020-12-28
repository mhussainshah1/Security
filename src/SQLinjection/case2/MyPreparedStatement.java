package SQLinjection.case2;

import java.sql.Connection;
import java.sql.SQLException;

public class MyPreparedStatement {

    public int getOpening(Connection conn, String day)
            throws SQLException {
        String sql = "SELECT opens FROM hours WHERE day = '" + day + "'";
        try (var ps = conn.prepareStatement(sql);
             var rs = ps.executeQuery()) {
            if (rs.next())
                return rs.getInt("opens");
        }
        return -1;
    }
}