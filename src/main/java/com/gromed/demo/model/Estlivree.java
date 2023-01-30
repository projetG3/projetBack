package com.gromed.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@SequenceGenerator(name="ESTLIVREE_SEQ",sequenceName="estlivree_SEQ", initialValue=1, allocationSize = 1)
@Table(name = "ESTLIVREE")
public class Estlivree {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="ESTLIVREE_SEQ")
    @Column(name="id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="IDCOMMANDE")
    @JsonIgnore
    private Commande idcommande;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "CODECIP7", nullable = false)
    private Presentation presentation;

    @Column(name = "STATUS", nullable = false, length = 50)
    private String status;

    @Column(name = "DATEENVOI", nullable = false)
    private LocalDate dateenvoi;

    @Column(name = "QUANTITE", nullable = false)
    private Integer quantite;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Commande getIdcommande() {
        return idcommande;
    }

    public void setIdcommande(Commande idcommande) {
        this.idcommande = idcommande;
    }
}