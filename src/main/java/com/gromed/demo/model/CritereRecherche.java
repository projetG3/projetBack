package com.gromed.demo.model;

import java.util.ArrayList;
import java.util.List;

public class CritereRecherche {
    private String nom;
    private String libelle;
    private List<String> voieAdministrations = new ArrayList<>();
    private String generique;

    public String getNom() {
        return nom;
    }

    public String getLibelle() {
        return libelle;
    }

    public List<String> getVoieAdministrations() {
        return voieAdministrations;
    }

    public String getGenerique() {
        return generique;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setVoieAdministrations(List<String> voieAdministrations) {
        this.voieAdministrations = voieAdministrations;
    }

    public void setGenerique(String generique) {
        this.generique = generique;
    }
}

