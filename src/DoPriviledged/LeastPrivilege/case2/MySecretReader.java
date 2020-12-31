package DoPriviledged.LeastPrivilege.case2;

import java.security.*;

public class MySecretReader {
    private static final String KEY = "os.name";//"secret.option";
    public String getSecret() {
        return AccessController.doPrivileged(
                new PrivilegedAction<String>() {
                    public String run() {
                        return System.getProperty(KEY);
                    }
                });
    }
}
