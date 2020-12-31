package DoPriviledged.SensitiveInformation.case1;

public class Hacker {
    public static void main(String[] args) {

        var secretReader = new MySecretReader();
        System.out.println(secretReader.getSecret());
        secretReader.getSecret().clear();
        System.out.println(secretReader.getSecret());
    }
}
