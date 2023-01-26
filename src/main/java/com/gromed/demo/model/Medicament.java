package com.gromed.demo.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "MEDICAMENT")
public class Medicament {
    @Id
    @Column(name = "CODECIS", nullable = false)
    private Long id;

    @Column(name = "NOM", nullable = false, length = 50)
    private String nom;

    @ManyToOne
    @JoinColumn(name = "formepharmaceutique")
    private FormePharmaceutique formepharmaceutique;

    @ManyToOne
    @JoinColumn(name = "statutadministratif")
    private StatutAdministratif statutadministratif;

    @ManyToOne
    @JoinColumn(name = "typeprocedure")
    private TypeProcedure typeprocedure;

    @ManyToOne
    @JoinColumn(name = "ETATCOMMERCIALISATION")
    private EtatCommercialisation etatcommercialisation;

    @Column(name = "DATEAMM", nullable = false)
    private LocalDate dateamm;

    @Column(name = "STATUSBDM", length = 50)
    private String statusbdm;

    public void setTitulaires(List<Titulaire> titulaires) {
        this.titulaires = titulaires;
    }

    @Column(name = "NUMEROAUTORISATIONEUROPEENNE", length = 50)
    private String numeroautorisationeuropeenne;

    @Column(name = "SURVEILLANCERENFORCEE", nullable = false)
    private String surveillancerenforcee;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "typeDeVoie")
    private List<VoieAdministration> voieadministrations;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private List<Titulaire> titulaires;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "conditionsmedicamenteuse")
    private List<Conditionsmedicamenteuse> conditionsmedicamenteuse;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", nullable = false)
    private List<Informationsimportante> informationsimportantes;
/*
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private List<Composition> compositions;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", nullable = false)
    private List<Avis> avis;


    public List<Avis> getAvis() {
        return avis;
    }

    public void setAvis(List<Avis> avis) {
        this.avis= avis;
    }

    public void addAvis(Avis avis){this.avis.add(avis);}

    public void removeAvis(Avis avis){this.avis.remove(avis);}



    public List<Composition> getCompositions() {
        return compositions;
    }

    public void setCompositions(List<Composition> compositions) {
        this.compositions= compositions;
    }


    public void addComposition(Composition composition){compositions.add(composition);}

    public void removeComposition(Composition composition){compositions.remove(composition);}


 */
    public List<Informationsimportante> getInformationsimportantes() {
        return informationsimportantes;
    }

    public void setInformationsimportantes(List<Informationsimportante> informationsimportantes) {
        this.informationsimportantes= informationsimportantes;
    }

    public void addInformationsimportante(Informationsimportante informationsimportante){informationsimportantes.add(informationsimportante);}

    public void removeInformationsimportante(Informationsimportante informationsimportante){informationsimportantes.remove(informationsimportantes);}

    public List<Conditionsmedicamenteuse> getConditionsmedicamenteuses() {
        return conditionsmedicamenteuses;
    }

    public void setConditionsmedicamenteuses(List<Conditionsmedicamenteuse> conditionsmedicamenteuses) {
        this.conditionsmedicamenteuses= conditionsmedicamenteuses;
    }

    public void addConditionsmedicamenteuse(Conditionsmedicamenteuse conditionsmedicamenteuse){conditionsmedicamenteuses.add(conditionsmedicamenteuse);}

    public void removeConditionsmedicamenteuse(Conditionsmedicamenteuse conditionsmedicamenteuse){conditionsmedicamenteuses.remove(conditionsmedicamenteuse);}

    public List<Titulaire> getTitulaires() {
        return titulaires;
    }

    public void setTitulaire(List<Titulaire> titulaires) {
        this.titulaires = titulaires;
    }

    public void addTitulaire(Titulaire titulaire){titulaires.add(titulaire);}

    public void removeTitulaire(Titulaire titulaire){titulaires.remove(titulaire);}

    public List<VoieAdministration> getVoieadministrations() {
        return voieadministrations;
    }

    public void setVoieadministrations(List<VoieAdministration> voieadministrations) {
        this.voieadministrations = voieadministrations;
    }

    public void addVoieadministration(VoieAdministration voieadministration){voieadministrations.add(voieadministration);}

    public void removeVoieadministration(VoieAdministration voieadministration){voieadministrations.remove(voieadministration);}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getFormepharmaceutique() {
        return formepharmaceutique;
    }

    public void setFormepharmaceutique(String formepharmaceutique) {
        this.formepharmaceutique= formepharmaceutique;
    }
    public String getStatutadministratif() {
        return statutadministratif;
    }

    public void setStatutadministratif(String statutadministratif) {
        this.statutadministratif = statutadministratif;
    }

    public String getTypeprocedure() {
        return typeprocedure;
    }

    public void setTypeprocedure(String typeprocedure) {
        this.typeprocedure = typeprocedure;
    }

    public String getEtatcommercialisation() {
        return etatcommercialisation;
    }

    public void setEtatcommercialisation(String etatcommercialisation) {
        this.etatcommercialisation = etatcommercialisation;
    }

    public LocalDate getDateamm() {
        return dateamm;
    }

    public void setDateamm(LocalDate dateamm) {
        this.dateamm = dateamm;
    }

    public String getStatusbdm() {
        return statusbdm;
    }

    public void setStatusbdm(String statusbdm) {
        this.statusbdm = statusbdm;
    }

    public String getNumeroautorisationeuropeenne() {
        return numeroautorisationeuropeenne;
    }

    public void setNumeroautorisationeuropeenne(String numeroautorisationeuropeenne) {
        this.numeroautorisationeuropeenne = numeroautorisationeuropeenne;
    }

    public Boolean getSurveillancerenforcee() {
        return surveillancerenforcee;
    }

    public void setSurveillancerenforcee(Boolean surveillancerenforcee) {
        this.surveillancerenforcee = surveillancerenforcee;
    }

}