package com.gromed.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CONDITIONSMEDICAMENTEUSE")
public class Conditionsmedicamenteuse {
    @Id
    @Column(name = "PRESCRIPTION", nullable = false, length = 500)
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}