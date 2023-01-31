package com.gromed.demo.model;

public class ResultatRecherche {

    private Long id;

    private String libellePresentation;

    private String libelleMedicament;

    private String generique;

    private int quantite;

    private double prix;

    private String typeDeVoie;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibellePresentation() {
        return libellePresentation;
    }

    public void setLibellePresentation(String libellePresentation) {
        this.libellePresentation = libellePresentation;
    }

    public String getLibelleMedicament() {
        return libelleMedicament;
    }

    public void setLibelleMedicament(String libelleMedicament) {
        this.libelleMedicament = libelleMedicament;
    }

    public String getGenerique() {
        return generique;
    }

    public void setGenerique(String generique) {
        this.generique = generique;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getTypeDeVoie() {
        return typeDeVoie;
    }

    public void setTypeDeVoie(String typeDeVoie) {
        this.typeDeVoie = typeDeVoie;
    }
}
