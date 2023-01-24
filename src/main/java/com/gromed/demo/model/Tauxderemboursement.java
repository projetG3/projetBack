package com.example.demo.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "TAUXDEREMBOURSEMENT")
public class Tauxderemboursement {
    @Id
    @Column(name = "TAUX", nullable = false)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}