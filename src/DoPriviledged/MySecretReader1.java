package DoPriviledged;

import java.security.AccessController;
import java.security.PrivilegedAction;

public class MySecretReader1 {
    public String getSecret(String magicWord) {
        return AccessController.doPrivileged(
                new PrivilegedAction<String>() {
                    public String run() {
                        return System.getProperty(magicWord);  // DON'T DO THIS!
                    }
                });
    }
}