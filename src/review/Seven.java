package review;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Seven {
    String url = "jdbc:derby:zoo";
    Connection conn = DriverManager.getConnection(url);

    public Seven() throws SQLException {
    }

    public boolean isValid(String hashedPassword)
            throws SQLException {
        var sql = "SELECT * FROM users WHERE password = ?";
        try (var stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, hashedPassword);
            try (var rs = stmt.executeQuery(sql)) {
                return rs.next();
            }
        }
    }
}
