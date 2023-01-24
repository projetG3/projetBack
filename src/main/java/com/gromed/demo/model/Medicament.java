package com.gromed.demo.model;

import jakarta.persistence.*;

import javax.annotation.processing.ProcessingEnvironment;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "MEDICAMENT")
public class Medicament {
    @Id
    @Column(name = "CODECIS", nullable = false)
    private Integer id;

    @Column(name = "NOM", nullable = false, length = 50)
    private String nom;

    @Column(name = "FORMEPHARMACEUTIQUE", nullable = false, length = 50)
    private String formepharmaceutique;

    @Column(name = "STATUTADMINISTRATIF", nullable = false, length = 50)
    private String statutadministratif;

    @Column(name = "TYPEPROCEDURE", nullable = false, length = 50)
    private String typeprocedure;

    @Column(name = "ETATCOMMERCIALISATION", length = 50)
    private String etatcommercialisation;

    @Column(name = "DATEAMM", nullable = false)
    private LocalDate dateamm;

    @Column(name = "STATUSBDM", length = 50)
    private String statusbdm;

    @Column(name = "NUMEROAUTORISATIONEUROPEENNE", length = 50)
    private String numeroautorisationeuropeenne;

    @Column(name = "SURVEILLANCERENFORCEE", nullable = false)
    private Boolean surveillancerenforcee = false;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "typeDeVoie")
    private List<Voieadministration> voieadministrations;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private List<Titulaire> titulaires;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private List<Conditionsmedicamenteuse> conditionsmedicamenteuses;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", nullable = false)
    private List<Informationsimportante> informationsimportantes;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private List<Composition> compositions;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", nullable = false)
    private List<Avis> avis;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", nullable = false)
    private List<Presentation> presentations;

    public List<Presentation> getPresentations() {
        return presentations;
    }

    public void setPresentations(List<Presentation> presentations) {
        this.presentations= presentations;
    }

    public void addPresentation(Presentation presentation){presentations.add(presentation);}

    public void removePresentation(Presentation presentation){this.presentations.remove(presentation);}

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

    public List<Voieadministration> getVoieadministrations() {
        return voieadministrations;
    }

    public void setVoieadministrations(List<Voieadministration> voieadministrations) {
        this.voieadministrations = voieadministrations;
    }

    public void addVoieadministration(Voieadministration voieadministration){voieadministrations.add(voieadministration);}

    public void removeVoieadministration(Voieadministration voieadministration){voieadministrations.remove(voieadministration);}

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
        this.formepharmaceutique = formepharmaceutique;
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