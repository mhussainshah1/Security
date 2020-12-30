package DoPriviledged;

import java.security.*;

public class MySecretReader {
    private static final String KEY = "secret.option";
    public String getSecret() {
        return AccessController.doPrivileged(
                new PrivilegedAction<String>() {
                    public String run() {
                        return System.getProperty(KEY);
                    }
                });
    }

    public static void main(String[] args) {
        var r = new MySecretReader();
        System.out.println(r.getSecret());
    }
}
