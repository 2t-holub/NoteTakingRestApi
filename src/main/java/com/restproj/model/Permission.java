package com.restproj.model;

public enum Permission {
    OWN_NOTES_READ_WRITE("notes:own"),
    ALL_NOTES_READ_WRITE("notes:all");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
