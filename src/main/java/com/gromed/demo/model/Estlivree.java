package com.gromed.demo.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "ESTLIVREE")
public class Estlivree {
    @EmbeddedId
    private EstlivreeId id;

    @MapsId("idcommande")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDCOMMANDE", nullable = false)
    private Commande commande;

    @MapsId("codecip7")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CODECIP7", nullable = false)
    private Presentation presentation;

    @Column(name = "STATUS", nullable = false, length = 50)
    private String status;

    @Column(name = "DATEENVOI", nullable = false)
    private LocalDate dateenvoi;

    @Column(name = "QUANTITE", nullable = false)
    private Long quantite;

    public EstlivreeId getId() {
        return id;
    }

    public void setId(EstlivreeId id) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDateenvoi() {
        return dateenvoi;
    }

    public void setDateenvoi(LocalDate dateenvoi) {
        this.dateenvoi = dateenvoi;
    }

    public Long getQuantite() {
        return quantite;
    }

    public void setQuantite(Long quantite) {
        this.quantite = quantite;
    }

}