package com.restproj.model;

public enum Permission {
    OWN_READ_WRITE("own"),
    ALL_READ_WRITE("all");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
