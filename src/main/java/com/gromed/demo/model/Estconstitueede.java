package com.gromed.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ESTCONSTITUEEDE")
public class Estconstitueede {
    @EmbeddedId
    private EstconstitueedeId id;

    @MapsId("idcommande")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDCOMMANDE", nullable = false)
    private Commande commande;

    @MapsId("codecip7")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CODECIP7", nullable = false)
    private Presentation presentation;

    @Column(name = "QUANTITE", nullable = false)
    private Integer quantite;

    public EstconstitueedeId getId() {
        return id;
    }

    public void setId(EstconstitueedeId id) {
        this.id = id;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Presentation getPresentation() {
        return presentation;
    }

    public void setPresentation(Presentation presentation) {
        this.presentation = presentation;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

}