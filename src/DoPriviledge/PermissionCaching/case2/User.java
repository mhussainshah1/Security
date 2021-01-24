package DoPriviledge.PermissionCaching.case2;

import java.util.PropertyPermission;

public class User {
    SecretFile value;
    PropertyPermission permission;

    public User(SecretFile value, PropertyPermission permission) {
        this.value = value;
        this.permission = permission;
    }

    public SecretFile getValue() {
        return value;
    }

    public PropertyPermission getPermission() {
        return permission;
    }
}
