package com.gromed.demo.model;

public class AchatPresentation {

    private Long produit;

    private int quantiteCommande;

    public void setProduit(Long produit) {
        this.produit = produit;
    }

    public void setQuantiteCommande(int quantiteCommande) {
        this.quantiteCommande = quantiteCommande;
    }

    public void setIdCompte(Long idCompte) {
        this.idCompte = idCompte;
    }

    public Long idCompte;

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
