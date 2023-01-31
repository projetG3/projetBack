package com.gromed.demo.model;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OptimisticLocking;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PRESENTATION")
@OptimisticLocking
@DynamicUpdate
public class Presentation {
    @Id
    @Column(name = "CODECIP7", nullable = false)
    private Long id;

    @Column(name = "LIBELLE", nullable = false, length = 150)
    private String libelle;

    @Column(name = "STATUS", nullable = false, length = 150)
    private String status;

    @Column(name = "ETATCOMMERCIALISATION", nullable = false, length = 150)
    private String etatcommercialisation;

    @Column(name = "DATECOMMERCIALISATION")
    private LocalDate datecommercialisation;

    @Column(name = "CODECIP13")
    private Long codecip13;

    @Column(name = "AGREMENT", nullable = false, length = 15)
    private String agrement;

    @Column(name = "PRIX", precision = 5, scale = 2, nullable = false)
    private Double prix;

    @Column(name = "INDICATIONS", length = 1000)
    private String indications;

    @Column(name = "QUANTITEDISPO")
    private Integer quantitedispo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CODECIS")
    private Medicament codecis;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "CODECIP7")
    private List<Estrembourseea> estrembourseeas = new ArrayList<>();

    public List<Estrembourseea> getEstremboursea() {
        return estrembourseeas;
    }

    public void setEstremboursea(List<Estrembourseea> estrembourseea) {
        this.estrembourseeas = estrembourseea;
    }

    public void addEstremboursea(Estrembourseea estrembourseea){estrembourseeas.add(estrembourseea);}

    public void removeEstremboursea(Estrembourseea estrembourseea){estrembourseeas.remove(estrembourseea);}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getCodecip13() {
        return codecip13;
    }

    public void setCodecip13(Long codecip13) {
        this.codecip13 = codecip13;
    }

    public String getAgrement() {
        return agrement;
    }

    public void setAgrement(String agrement) {
        this.agrement = agrement;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
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