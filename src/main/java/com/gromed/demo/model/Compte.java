package com.gromed.demo.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@SequenceGenerator(name="COMPTE_SEQ",sequenceName="compteSEQ", initialValue=1, allocationSize = 1)
@Table(name = "COMPTE")
public class Compte {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="COMPTE_SEQ")
    @Column(name="IDCOMPTE", nullable = false)
    private Long id;

    @Column(name = "NOM", nullable = false, length = 50)
    private String nom;

    @Column(name = "PRENOM", nullable = false, length = 50)
    private String prenom;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "FINESSET", nullable = false)
    private Etablissement etablissement;

    @Column(name = "MOTDEPASSE", nullable = false, length = 50)
    private String motDePasse;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "compte")
    private List<Commande> commandes;

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }

    public void addCommande(Commande commande){
        this.commandes.add(commande);
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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