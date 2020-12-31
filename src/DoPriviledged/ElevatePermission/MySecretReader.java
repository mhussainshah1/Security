package DoPriviledged.ElevatePermission;

import java.security.*;
public class MySecretReader {
    public void readData(Runnable task, String path) {
        // Check permission
        Permission permission = new java.io.FilePermission(path,"read");
        AccessController.checkPermission(permission);

        // Execute task with limited permission
        final var permissions = permission.newPermissionCollection();
        permissions.add(permission);
        AccessController.doPrivileged(
                new PrivilegedAction<Void>() {
                    public Void run() {
                        task.run();
                        return null;
                    }
                },
                // Using a limited context prevents privilege elevation
                new AccessControlContext(
                        new ProtectionDomain[] {
                                new ProtectionDomain(null, permissions)
                        })
        );
    }
}