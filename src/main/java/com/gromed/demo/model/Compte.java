package com.example.demo.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "COMPTE")
public class Compte {
    @Id
    @GeneratedValue(Strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NOM", nullable = false, length = 50)
    private String nom;

    @Column(name = "PRENOM", nullable = false, length = 50)
    private String prenom;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "FINESSET", nullable = false)
    private Etablissement etablissement;

    @Column(name = "MOTDEPASSE", nullable = false, length = 50)
    private String motDePasse;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCommand", nullable = false)
    private List<Commande> commandes;

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

    public Etablissement getEetablissement() {
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

    public List<Commande> getCommandes(){return commandes;}

    public void setCommandes(List<Commande> commandes){this.commandes = commandes;}

    public void addCommandes(Commande commande){commandes.add(commande);}

    public void removeCommandes(Commande commande){commandes.remove(commande);}


}