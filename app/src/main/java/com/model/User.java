package com.model;

public class User {
    private String maU;
    private String tenU;
    private String phoneU;

    public User(String maU, String tenU, String phoneU) {
        this.maU = maU;
        this.tenU = tenU;
        this.phoneU = phoneU;
    }

    @Override
    public String toString() {
        return maU + "\t" + tenU + "\t" + phoneU;
    }

    public User() {
    }
}
