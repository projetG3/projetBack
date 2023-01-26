package com.gromed.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "COMPTE")
public class Compte {
    @Id
    //@GeneratedValue(Strategy = GenerationType.IDENTITY)
    @Column(name="IDCOMPTE", nullable = false)
    private Integer id;

    @Column(name = "NOM", nullable = false, length = 50)
    private String nom;

    @Column(name = "PRENOM", nullable = false, length = 50)
    private String prenom;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "FINESSET", nullable = false)
    private Etablissement etablissement;

    @Column(name = "MOTDEPASSE", nullable = false, length = 50)
    private String motDePasse;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Etablissement getEtablissement() {
        return etablissement;
    }

    public void setEtablissement(Etablissement etablissement) {
        this.etablissement = etablissement;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;}
}