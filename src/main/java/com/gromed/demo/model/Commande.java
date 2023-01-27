package com.gromed.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@SequenceGenerator(name="COMMANDE_SEQ",sequenceName="commandeSEQ", initialValue=1, allocationSize = 1)
@Table(name = "COMMANDE")
public class Commande {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="COMMANDE_SEQ")
    @Column(name = "IDCOMMANDE", nullable = false)
    private Long id;

    @Column(name = "DATEHEURECOMMANDE")
    private LocalDateTime dateheurecommande;

    @Column(name = "STATUS", length = 50)
    private String status;

    @Column(name = "MONTANTTOTAL", length = 50)
    private String montanttotal;

    @Column(name = "STATUSFACTURE")
    private Boolean statusfacture;

    @Column(name = "DATEFACTURE")
    private LocalDate datefacture;

    @Column(name = "NOM", length = 50)
    private String nom;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDCOMPTE", nullable = false)
    private Compte compte;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateheurecommande() {
        return dateheurecommande;
    }

    public void setDateheurecommande(LocalDateTime dateheurecommande) {
        this.dateheurecommande = dateheurecommande;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMontanttotal() {
        return montanttotal;
    }

    public void setMontanttotal(String montanttotal) {
        this.montanttotal = montanttotal;
    }

    public Boolean getStatusfacture() {
        return statusfacture;
    }

    public void setStatusfacture(Boolean statusfacture) {
        this.statusfacture = statusfacture;
    }

    public LocalDate getDatefacture() {
        return datefacture;
    }

    public void setDatefacture(LocalDate datefacture) {
        this.datefacture = datefacture;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }



}