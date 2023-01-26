package com.gromed.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "MODEDEFIXATIONDESTARIFS")
public class Modedefixationdestarif {
    @Id
    @Column(name = "CODEMFT", nullable = false)
    private Long id;

    @Column(name = "LIBELLE", length = 100)
    private String libelle;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

}