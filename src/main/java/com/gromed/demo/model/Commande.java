package com.gromed.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "idcompte")
    @JsonIgnore
    private Compte compte;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "idcommande")
    //@JoinColumn(name = "ID")
    //@JsonIgnore
    private List<Estconstitueede> estconstitueedes = new ArrayList<>();

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public List<Estconstitueede> getEstconstitueedes() {
        return estconstitueedes;
    }

    public void setEstconstitueedes(List<Estconstitueede> estconstitueedes) {
        this.estconstitueedes = estconstitueedes;
    }

    public void setEstconstitueede(List<Estconstitueede> estconstitueedes) {
        this.estconstitueedes = estconstitueedes;
    }

    public void addEstConstitueeDe(Estconstitueede estconstitueede){
        this.estconstitueedes.add(estconstitueede);
    }

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
}