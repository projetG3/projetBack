package com.gromed.demo.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "AVIS")
public class Avis {
    @EmbeddedId
    private AvisId id;

    @Column(name = "MOTIFEVALUATION", length = 50)
    private String motifevaluation;

    @Column(name = "DATEAVIS")
    private LocalDate dateavis;

    @Column(name = "LIEN", length = 40)
    private String lien;

    @Column(name = "TYPEAVIS")
    private Boolean typeavis;

    public AvisId getId() {
        return id;
    }

    public void setId(AvisId id) {
        this.id = id;
    }

    public String getMotifevaluation() {
        return motifevaluation;
    }

    public void setMotifevaluation(String motifevaluation) {
        this.motifevaluation = motifevaluation;
    }

    public LocalDate getDateavis() {
        return dateavis;
    }

    public void setDateavis(LocalDate dateavis) {
        this.dateavis = dateavis;
    }

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    public Boolean getTypeavis() {
        return typeavis;
    }

    public void setTypeavis(Boolean typeavis) {
        this.typeavis = typeavis;
    }
}