package SQLinjection.case1;

import java.sql.Connection;
import java.sql.DriverManager;

public class Hacker {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:derby:zoo;create=true";
        try (Connection conn = DriverManager.getConnection(url)) {
            var attack = new MyStatement();
            int opening = attack.getOpening(conn, "monday"); // 10
            System.out.println(opening);

            int evil = attack.getOpening(conn,
                    "monday' OR day IS NOT NULL OR day = 'sunday"); // 9
            System.out.println(evil);
        }
    }
}
