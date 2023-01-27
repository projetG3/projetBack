package com.gromed.demo.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "ESTLIVREE")
public class Estlivree {
    @Id
    @Column(name="id")
    private Long id;

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

    @Column(name = "IDCOMMANDE", nullable = false)
    private Long idcommande;

    @Column(name = "CODECIP7", nullable = false)
    private Long codecip7;

    public Long getIdcommande() {
        return idcommande;
    }

    public void setIdcommande(Long idcommande) {
        this.idcommande = idcommande;
    }

    public Long getCodecip7() {
        return codecip7;
    }

    public void setCodecip7(Long codecip7) {
        this.codecip7 = codecip7;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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