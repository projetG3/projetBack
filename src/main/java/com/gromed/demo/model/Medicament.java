package com.gromed.demo.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "MEDICAMENT")
public class Medicament {
    @Id
    @Column(name = "CODECIS", nullable = false)
    private Long id;

    @Column(name = "NOM", nullable = false, length = 150)
    private String nom;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "formepharmaceutique")
    private FormePharmaceutique formepharmaceutique;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "statutadministratif")
    private StatutAdministratif statutadministratif;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "typeprocedure")
    private TypeProcedure typeprocedure;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "etatcommercialisation")
    private EtatCommercialisation etatcommercialisation;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "codecis")
    private List<Informe> informes = new ArrayList<>();

    @Column(name = "dateamm", nullable = false)
    private LocalDate dateamm;

    @Column(name = "statusbdm", length = 150)
    private String statusbdm;

    @Column(name = "numeroautorisationeuropeenne", length = 150)
    private String numeroautorisationeuropeenne;

    @Column(name = "surveillancerenforcee", nullable = false)
    private String surveillancerenforcee;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "codecis")
    private List<Administrepar> administrepars = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "codecis")
    private List<Estcreepar> estcreepars = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "codecis")
    private List<Estdelivresous> estdelivresous = new ArrayList<>();

    public List<Estcreepar> getEstcreepars() {
        return estcreepars;
    }

    public void setEstcreepars(List<Estcreepar> estcreepars) {
        this.estcreepars = estcreepars;
    }

    public List<Estdelivresous> getEstdelivresous() {
        return estdelivresous;
    }

    public void setEstdelivresous(List<Estdelivresous> estdelivresous) {
        this.estdelivresous = estdelivresous;
    }

    public List<Informe> getInformes() {
        return informes;
    }

    public void setInformes(List<Informe> informe) {
        this.informes = informe;
    }

    public void addInforme(Informe informe){informes.add(informe);}

    public void removeInforme(Informe informe){informes.remove(informe);}

    public void addEstcreepars(Estcreepar estcreepar){estcreepars.add(estcreepar);}

    public void removeEstcreepar(Estcreepar estcreepar){estcreepars.remove(estcreepar);}

    public List<Administrepar> getAdministrepars() {
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