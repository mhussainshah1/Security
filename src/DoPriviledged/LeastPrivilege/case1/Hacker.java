package DoPriviledged.LeastPrivilege.case1;

public class Hacker {
    public static void main(String[] args) {
//        Properties properties = System.getProperties();
//        properties.list(System.out);

        var r = new MySecretReader();
        System.out.println(r.getSecret("java.home"));
        System.out.println(r.getSecret("user.dir"));
        System.out.println(r.getSecret("os.name"));
    }
}
