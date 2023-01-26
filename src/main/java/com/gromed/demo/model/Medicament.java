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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "formepharmaceutique")
    private FormePharmaceutique formepharmaceutique;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "statutadministratif")
    private StatutAdministratif statutadministratif;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "typeprocedure")
    private TypeProcedure typeprocedure;

    @ManyToOne(fetch = FetchType.LAZY)
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "medicament", cascade = CascadeType.ALL)
    private List<Administrepar> administrepars;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "codecis", cascade = CascadeType.ALL)
    private List<Estcreepar> estcreepars;

    /*
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "codecis", cascade = CascadeType.ALL)
    private List<Estdelivresous> estdelivresous;
*/
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "codecis", cascade = CascadeType.ALL)
    private List<Informe> informes;

    public List<Informe> getInforme() {
        return informes;
    }

    public void setInfore(List<Informe> informe) {
        this.informes= informe;
    }

    public void addInforme(Informe informe){informes.add(informe);}

    public void removeInforme(Informe informe){informes.remove(informe);}
/*
    public List<Estdelivresous> getEstdelivresous() {
        return estdelivresous;
    }

    public void setEstdelivresous(List<Estdelivresous> estdelivresous) {
        this.estdelivresous= estdelivresous;
    }

    public void addEstdelivresous(Estdelivresous estdelivresous){this.estdelivresous.add(estdelivresous);}

    public void removeEstdelivresous(Estdelivresous estdelivresous){this.estdelivresous.remove(estdelivresous);}
*/
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