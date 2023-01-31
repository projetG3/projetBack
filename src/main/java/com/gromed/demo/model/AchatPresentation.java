package com.gromed.demo.model;

public class AchatPresentation {

    private Long produit;

    private int quantiteCommande;

    public static final Long idCompte = 0L;

    public Long getProduit(){
        return produit;
    }

    public int getQuantiteCommande(){
        return quantiteCommande;
    }

    public Long getIdCompte(){
        return idCompte;
    }
}
