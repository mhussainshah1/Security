package DoPriviledge.LeastPrivilege.case2;

public class Hacker {
    public static void main(String[] args) {
//        Properties properties = System.getProperties();
//        properties.list(System.out);

        var r = new MySecretReader();
        System.out.println(r.getSecret());

    }
}
