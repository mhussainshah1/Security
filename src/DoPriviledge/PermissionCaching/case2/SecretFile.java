package DoPriviledge.PermissionCaching.case2;

import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.ProtectionDomain;
import java.util.HashMap;
import java.util.Map;
import java.util.PropertyPermission;

public final class SecretFile {
    private static Map<String, User> data = new HashMap<>();

    static {
        data.put("12345", new User(new SecretFile(), new PropertyPermission("12345", "read")));
        data.put("67890", new User(new SecretFile(), new PropertyPermission("67890", "write")));
    }

    public SecretFile() {

    }

    public static SecretFile get(String key) {
        var cacheRecord = data.get(key);
        if (cacheRecord != null) {
            AccessController.checkPermission(cacheRecord.getPermission());
            return cacheRecord.getValue();
        }

        final var permission = new PropertyPermission(key, "read");
        AccessController.checkPermission(permission);

        final var permissions = permission.newPermissionCollection();
        permissions.add(permission);

        var secret = AccessController.doPrivileged(
                new PrivilegedAction<SecretFile>() {
                    public SecretFile run() {
                        return new SecretFile();
                    }
                },

                new AccessControlContext(
                        new ProtectionDomain[]{
                                new ProtectionDomain(null, permissions)
                        }
                )
        );

        data.put(key, new User(secret, permission));
        return secret;
    }
}