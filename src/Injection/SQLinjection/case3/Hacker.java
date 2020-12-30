package Injection.SQLinjection.case3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Hacker {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:derby:zoo;create=true";
        try (Connection conn = DriverManager.getConnection(url)) {
            var attack = new MyPreparedStatement();
            int evil = attack.getOpening(conn,
                    "monday' OR day IS NOT NULL OR day = 'sunday"); // -1
            System.out.println(evil);
        }
    }
}
