package DoPriviledged.SensitiveInformation.case2;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.List;

public class MySecretReader {
    //Immutable List
    private final List<Integer> codes = List.of(12345, 67890);

    public List<Integer> getSecret() {
        return AccessController.doPrivileged(
                new PrivilegedAction<List<Integer>>() {
                    public List<Integer> run() {
                        return codes;  // DON'T DO THIS!
                    }
                });
    }
}
