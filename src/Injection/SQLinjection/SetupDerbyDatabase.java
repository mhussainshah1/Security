package Injection.SQLinjection;

import java.sql.*;

public class SetupDerbyDatabase {

    public static void main(String[] args) throws Exception {
        String url = "jdbc:derby:zoo;create=true";
        try (Connection conn = DriverManager.getConnection(url)) {

            run(conn, "DROP TABLE hours");

            run(conn, "CREATE TABLE hours ("
                    + "id INTEGER PRIMARY KEY, "
                    + "day VARCHAR(20), "
                    + "opens INTEGER, "
                    + "closes INTEGER)");

            run(conn, "INSERT INTO hours VALUES (1, 'sunday', 9, 6)");
            run(conn, "INSERT INTO hours VALUES (2, 'monday', 10, 4)");
            run(conn, "INSERT INTO hours VALUES (3, 'tuesday', 10, 4)");
            run(conn, "INSERT INTO hours VALUES (4, 'wednesday', 10, 5)");
            run(conn, "INSERT INTO hours VALUES (5, 'thursday', 10, 4)");
            run(conn, "INSERT INTO hours VALUES (6, 'friday', 10, 6)");
            run(conn, "INSERT INTO hours VALUES (7, 'saturday', 9, 6)");

            printCount(conn, "SELECT count(*) FROM hours");
        }
    }

    private static void run(Connection conn, String sql) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.executeUpdate();
        }
    }

    private static void printCount(Connection conn, String sql) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            rs.next();
            System.out.println(rs.getInt(1));
        }
    }
}