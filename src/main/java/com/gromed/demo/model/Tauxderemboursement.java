package com.gromed.demo.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "TAUXDEREMBOURSEMENT")
public class Tauxderemboursement {
    @Id
    @Column(name = "TAUX", nullable = false)
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}