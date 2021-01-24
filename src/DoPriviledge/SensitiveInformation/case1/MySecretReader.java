package DoPriviledge.SensitiveInformation.case1;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;

public class MySecretReader {
    //final does not prevent modification of inner object
    private final List<Integer> codes = new ArrayList<>(List.of(12345,67890));

    public List<Integer> getSecret() {
        return AccessController.doPrivileged(
                new PrivilegedAction<List<Integer>>() {
                    public List<Integer> run() {
                        return codes;  // DON'T DO THIS!
                    }
                });
    }
}