package com.gromed.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "FORMEPHARMACEUTIQUE")
public class FormePharmaceutique {

    @Id
    @Column(name = "FORMEPHARMACEUTIQUE", nullable = false, length = 100)
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
