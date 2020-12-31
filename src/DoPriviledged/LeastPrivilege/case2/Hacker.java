package DoPriviledged.LeastPrivilege.case2;

import java.util.Properties;

public class Hacker {
    public static void main(String[] args) {
//        Properties properties = System.getProperties();
//        properties.list(System.out);

        var r = new MySecretReader();
        System.out.println(r.getSecret());

    }
}
