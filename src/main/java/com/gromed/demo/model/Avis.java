package com.gromed.demo.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "AVIS")
public class Avis{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idavis;

    @Column(name = "MOTIFEVALUATION", length = 50)
    private String motifevaluation;

    @Column(name = "DATEAVIS")
    private LocalDate dateavis;

    public Medicament getCodecis() {
        return codecis;
    }

    public void setCodecis(Medicament codecis) {
        this.codecis = codecis;
    }

    @Column(name = "LIEN", length = 40)
    private String lien;

    @Column(name = "TYPEAVIS")
    private Boolean typeavis;

    @Column(name = "CODEHAS")
    private Long codehas;

    @Column(name = "VALEUR")
    private String valeur;

    @Column(name = "LIBELLE")
    private String libelle;

    @OneToOne()
    Medicament codecis;

    public Long getCodehas() {
        return codehas;
    }

    public void setCodehas(Long codehas) {
        this.codehas = codehas;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    public Long getId() {
        return idavis;
    }

    public void setId(Long idavis) {
        this.idavis = idavis;
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