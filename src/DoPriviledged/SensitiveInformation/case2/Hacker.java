package DoPriviledged.SensitiveInformation.case2;

public class Hacker {
    public static void main(String[] args) {

        var secretReader = new MySecretReader();
        System.out.println(secretReader.getSecret());
        secretReader.getSecret().clear();
        System.out.println(secretReader.getSecret());
    }
}