package com.gromed.demo.model;

public class ResultatRecherche {
    private int quantite;

    private String nomMedicament;

    private String typedevoie;

    private String libellePresentation;

    private Long codeCIP7;


    public int getQuantite() {
        return quantite;
    }

    public String getNomMedicament() {
        return nomMedicament;
    }

    public String getTypedevoie() {
        return typedevoie;
    }

    public String getLibellePresentation() {
        return libellePresentation;
    }

    public Long getCodeCIP7(){
        return codeCIP7;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setNomMedicament(String nomMedicament) {
        this.nomMedicament = nomMedicament;
    }

    public void setTypedevoie(String typedevoie) {
        this.typedevoie = typedevoie;
    }

    public void setLibellePresentation(String libellePresentation) {
        this.libellePresentation = libellePresentation;
    }

    public void setCodeCIP7(Long codeCIP7){
        this.codeCIP7 = codeCIP7;
    }
}
