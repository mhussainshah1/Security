package DoPriviledge.PermissionCaching.case2;

public class Hacker {
    public static void main(String[] args) {
        System.out.println(SecretFile.get("12345"));
    }
}
