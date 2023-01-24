package com.example.demo.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "PRESENTATION")
public class Presentation {
    @Id
    @Column(name = "CODECIP7", nullable = false)
    private Integer id;

    @Column(name = "LIBELLE", nullable = false, length = 50)
    private String libelle;

    @Column(name = "STATUS", nullable = false, length = 50)
    private String status;

    @Column(name = "ETATCOMMERCIALISATION", nullable = false, length = 50)
    private String etatcommercialisation;

    @Column(name = "DATECOMMERCIALISATION")
    private LocalDate datecommercialisation;

    @Column(name = "CODECIP13")
    private Integer codecip13;

    @Column(name = "AGREMENT", nullable = false, length = 15)
    private String agrement;

    @Column(name = "PRIX", precision = 5, scale = 2)
    private BigDecimal prix;

    @Column(name = "INDICATIONS", length = 50)
    private String indications;

    @Column(name = "QUANTITEDISPO")
    private Integer quantitedispo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CODECIS", nullable = false)
    private Medicament codecis;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", nullable = false)
    private List<Tauxderemboursement> tauxderemboursements;

    public List<Tauxderemboursement> getTauxderemboursements() {
        return tauxderemboursements;
    }

    public void setTauxderemboursements(List<Tauxderemboursement> tauxderemboursements) {
        this.tauxderemboursements = tauxderemboursements;
    }

    public void addTauxderemboursement(Tauxderemboursement tauxderemboursement){tauxderemboursements.add(tauxderemboursement);}

    public void removeTauxderemboursement(Tauxderemboursement tauxderemboursement){tauxderemboursements.remove(tauxderemboursement);}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEtatcommercialisation() {
        return etatcommercialisation;
    }

    public void setEtatcommercialisation(String etatcommercialisation) {
        this.etatcommercialisation = etatcommercialisation;
    }

    public LocalDate getDatecommercialisation() {
        return datecommercialisation;
    }

    public void setDatecommercialisation(LocalDate datecommercialisation) {
        this.datecommercialisation = datecommercialisation;
    }

    public Integer getCodecip13() {
        return codecip13;
    }

    public void setCodecip13(Integer codecip13) {
        this.codecip13 = codecip13;
    }

    public String getAgrement() {
        return agrement;
    }

    public void setAgrement(String agrement) {
        this.agrement = agrement;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    public String getIndications() {
        return indications;
    }

    public void setIndications(String indications) {
        this.indications = indications;
    }

    public Integer getQuantitedispo() {
        return quantitedispo;
    }

    public void setQuantitedispo(Integer quantitedispo) {
        this.quantitedispo = quantitedispo;
    }

    public Medicament getCodecis() {
        return codecis;
    }

    public void setCodecis(Medicament codecis) {
        this.codecis = codecis;
    }

}