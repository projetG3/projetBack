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

    @Column(name = "NOM", nullable = false, length = 150)
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
    @JoinColumn(name = "etatcommercialisation")
    private EtatCommercialisation etatcommercialisation;

    @Column(name = "dateamm", nullable = false)
    private LocalDate dateamm;

    @Column(name = "statusbdm", length = 150)
    private String statusbdm;

    @Column(name = "numeroautorisationeuropeenne", length = 150)
    private String numeroautorisationeuropeenne;

    @Column(name = "surveillancerenforcee", nullable = false)
    private String surveillancerenforcee;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "typeDeVoie", nullable = false)
    private List<Administrepar> administrepars;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "codecis", nullable = false)
    private List<Estcreepar> estcreepars;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "codecis", nullable = false)
    private List<Estdelivresous> estdelivresous;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "codecis", nullable = false)
    private List<Informe> informes;
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
    public List<Informe> getInforme() {
        return informes;
    }

    public void setInfore(List<Informe> informe) {
        this.informes= informe;
    }

    public void addInforme(Informe informe){informes.add(informe);}

    public void removeInforme(Informe informe){informes.remove(informe);}

    public List<Estdelivresous> getEstdelivresous() {
        return estdelivresous;
    }

    public void setEstdelivresous(List<Estdelivresous> estdelivresous) {
        this.estdelivresous= estdelivresous;
    }

    public void addEstdelivresous(Estdelivresous estdelivresous){this.estdelivresous.add(estdelivresous);}

    public void removeEstdelivresous(Estdelivresous estdelivresous){this.estdelivresous.remove(estdelivresous);}

    public List<Estcreepar> getEstcreepar() {
        return estcreepars;
    }

    public void setEstcreepar(List<Estcreepar> estcreepar) {
        this.estcreepars = estcreepar;
    }

    public void addEstcreepar(Estcreepar estcreepar){estcreepars.add(estcreepar);}

    public void removeEstcreepar(Estcreepar estcreepar){estcreepars.remove(estcreepars);}

    public List<Administrepar> getAdministrepar() {
        return administrepars;
    }

    public void setAdministrepar(List<Administrepar> administrepar) {
        this.administrepars = administrepar;
    }

    public void addAdministrepar(Administrepar administrepar){administrepars.add(administrepar);}

    public void removeAdministrepar(Administrepar administrepar){administrepars.remove(administrepar);}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public FormePharmaceutique getFormepharmaceutique() {
        return formepharmaceutique;
    }

    public void setFormepharmaceutique(FormePharmaceutique formepharmaceutique) {
        this.formepharmaceutique= formepharmaceutique;
    }
    public StatutAdministratif getStatutadministratif() {
        return statutadministratif;
    }

    public void setStatutadministratif(StatutAdministratif statutadministratif) {
        this.statutadministratif = statutadministratif;
    }

    public TypeProcedure getTypeprocedure() {
        return typeprocedure;
    }

    public void setTypeprocedure(TypeProcedure typeprocedure) {
        this.typeprocedure = typeprocedure;
    }

    public EtatCommercialisation getEtatcommercialisation() {
        return etatcommercialisation;
    }

    public void setEtatcommercialisation(EtatCommercialisation etatcommercialisation) {
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

    public String getSurveillancerenforcee() {
        return surveillancerenforcee;
    }

    public void setSurveillancerenforcee(String surveillancerenforcee) {
        this.surveillancerenforcee = surveillancerenforcee;
    }

}