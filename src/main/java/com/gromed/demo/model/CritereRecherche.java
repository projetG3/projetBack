package com.gromed.demo.model;

import java.util.ArrayList;
import java.util.List;

public class CritereRecherche {
    private String libellePresentation;

    private String libelleMedicament;
    private String generique;
    private List<String> voieAdministrations = new ArrayList<>();

    private String denominationSubstance;

    public String getDenominationSubstance() {
        return denominationSubstance;
    }

    public void setDenominationSubstance(String denominationSubstance) {
        this.denominationSubstance = denominationSubstance;
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

    public List<String> getVoieAdministrations() {
        return voieAdministrations;
    }
    public void setVoieAdministrations(List<String> voieAdministrations) {
        this.voieAdministrations = voieAdministrations;
    }

}

