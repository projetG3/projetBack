package com.gromed.demo.model;

public class Utilisateur {

    private Long id;

    private String password;

    public Long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Long s) {
        id=s;
    }

    public void setPassword(String password) {
        this.password=password;
    }
}
