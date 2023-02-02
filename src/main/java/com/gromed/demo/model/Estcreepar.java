package com.gromed.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ESTCREEPAR")
public class Estcreepar {
    @EmbeddedId
    private EstcreeparId id;

    @MapsId("nom")
    @ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "NOM", nullable = false)
    private Titulaire nom;

    public EstcreeparId getId() {
        return id;
    }

    public void setId(EstcreeparId id) {
        this.id = id;
    }

    public Titulaire getNom() {
        return nom;
    }

    public void setNom(Titulaire nom) {
        this.nom = nom;
    }

}