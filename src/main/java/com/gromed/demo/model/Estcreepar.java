package com.gromed.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ESTCREEPAR")
public class Estcreepar {
    @EmbeddedId
    private EstcreeparId id;

    @MapsId("codecis")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CODECIS", nullable = false)
    private Medicament codecis;

    @MapsId("nom")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "NOM", nullable = false)
    private Titulaire nom;

    public EstcreeparId getId() {
        return id;
    }

    public void setId(EstcreeparId id) {
        this.id = id;
    }

    public Medicament getCodecis() {
        return codecis;
    }

    public void setCodecis(Medicament codecis) {
        this.codecis = codecis;
    }

    public Titulaire getNom() {
        return nom;
    }

    public void setNom(Titulaire nom) {
        this.nom = nom;
    }

}