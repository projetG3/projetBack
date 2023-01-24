package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "MODEDEFIXATIONDESTARIFS")
public class Modedefixationdestarif {
    @Id
    @Column(name = "CODEMFT", nullable = false)
    private Integer id;

    @Column(name = "LIBELLE", length = 100)
    private String libelle;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

}