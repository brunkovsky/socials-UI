package com.example.socials.ui.config;

import java.util.Set;

import static com.example.socials.ui.config.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    ADMIN(Set.of(ADMIN_READ, ADMIN_WRITE, GUEST_READ, GUEST_WRITE)),
    GUEST(Set.of());

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }
}
