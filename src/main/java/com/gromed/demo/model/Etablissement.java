package com.gromed.demo.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "ETABLISSEMENT")
public class Etablissement {
    @Id
    @Column(name = "FINESSET", nullable = false)
    private Long id;

    @Column(name = "FINESSEJ", nullable = false)
    private Long finessej;

    @Column(name = "LIGNEACHEMINEMENT", length = 33)
    private String ligneacheminement;

    @Column(name = "SIRET")
    private Long siret;

    @Column(name = "DATEOUVERTURE")
    private LocalDate dateouverture;

    @Column(name = "DATEAUTORISATION")
    private LocalDate dateautorisation;

    @Column(name = "DATEMAJSTRUCTURE")
    private LocalDate datemajstructure;

    @Column(name = "NUMEROUAI", length = 8)
    private String numerouai;

    @Column(name = "COORDSOURCE")
    private String coordsource;

    @Column(name = "TELEPHONE", length = 10)
    private String telephone;

    @Column(name = "TELECOPIE", length = 10)
    private String telecopie;

    @Column(name = "RAISONSOCIALE", nullable = false, length = 38)
    private String raisonsociale;

    @Column(name = "RAISONSOCIALELONGUE", length = 100)
    private String raisonsocialelongue;

    @Column(name = "COMPLEMENTRAISONSOCIALE", length = 32)
    private String complementraisonsociale;

    @Column(name = "COMPLEMENTDISTRIBUTION", length = 32)
    private String complementdistribution;

    @Column(name = "COORDX", nullable = false, precision = 8, scale = 1)
    private Long coordx;

    @Column(name = "COORDY", nullable = false, precision = 8, scale = 1)
    private Long coordy;

    @Column(name = "NUMEROVOIE")
    private Integer numerovoie;

    @Column(name = "NOMVOIE", length = 27)
    private String nomvoie;

    @Column(name = "COMPLEMENTVOIE")
    private Character complementvoie;

    @Column(name = "LIEUDIT", length = 32)
    private String lieudit;

    @Column(name = "CODECOMMUNE")
    private Integer codecommune;

    @Column(name = "DATEMAJCOORD")
    private LocalDate datemajcoord;

    @Column(name = "CODEDEPARTEMENT", length = 2)
    private String codedepartement;

    @Column(name = "NOMDEPARTEMENT", length = 24)
    private String nomdepartement;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CODESPH")
    private Servicepublichospitalier codesph;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "CODEMFT", nullable = false)
    private Modedefixationdestarif codemft;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "CODEAPE", nullable = false)
    private Codeape codeape;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "CATEGORIE", nullable = false)
    private Categorieetablissement categorie;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFinessej() {
        return finessej;
    }

    public void setFinessej(Long finessej) {
        this.finessej = finessej;
    }

    public String getLigneacheminement() {
        return ligneacheminement;
    }

    public void setLigneacheminement(String ligneacheminement) {
        this.ligneacheminement = ligneacheminement;
    }

    public Long getSiret() {
        return siret;
    }

    public void setSiret(Long siret) {
        this.siret = siret;
    }

    public LocalDate getDateouverture() {
        return dateouverture;
    }

    public void setDateouverture(LocalDate dateouverture) {
        this.dateouverture = dateouverture;
    }

    public LocalDate getDateautorisation() {
        return dateautorisation;
    }

    public void setDateautorisation(LocalDate dateautorisation) {
        this.dateautorisation = dateautorisation;
    }

    public LocalDate getDatemajstructure() {
        return datemajstructure;
    }

    public void setDatemajstructure(LocalDate datemajstructure) {
        this.datemajstructure = datemajstructure;
    }

    public String getNumerouai() {
        return numerouai;
    }

    public void setNumerouai(String numerouai) {
        this.numerouai = numerouai;
    }

    public String getCoordsource() {
        return coordsource;
    }

    public void setCoordsource(String coordsource) {
        this.coordsource = coordsource;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTelecopie() {
        return telecopie;
    }

    public void setTelecopie(String telecopie) {
        this.telecopie = telecopie;
    }

    public String getRaisonsociale() {
        return raisonsociale;
    }

    public void setRaisonsociale(String raisonsociale) {
        this.raisonsociale = raisonsociale;
    }

    public String getRaisonsocialelongue() {
        return raisonsocialelongue;
    }

    public void setRaisonsocialelongue(String raisonsocialelongue) {
        this.raisonsocialelongue = raisonsocialelongue;
    }

    public String getComplementraisonsociale() {
        return complementraisonsociale;
    }

    public void setComplementraisonsociale(String complementraisonsociale) {
        this.complementraisonsociale = complementraisonsociale;
    }

    public String getComplementdistribution() {
        return complementdistribution;
    }

    public void setComplementdistribution(String complementdistribution) {
        this.complementdistribution = complementdistribution;
    }

    public Long getCoordx() {
        return coordx;
    }

    public void setCoordx(Long coordx) {
        this.coordx = coordx;
    }

    public Long getCoordy() {
        return coordy;
    }

    public void setCoordy(Long coordy) {
        this.coordy = coordy;
    }

    public Integer getNumerovoie() {
        return numerovoie;
    }

    public void setNumerovoie(Integer numerovoie) {
        this.numerovoie = numerovoie;
    }

    public String getNomvoie() {
        return nomvoie;
    }

    public void setNomvoie(String nomvoie) {
        this.nomvoie = nomvoie;
    }

    public Character getComplementvoie() {
        return complementvoie;
    }

    public void setComplementvoie(Character complementvoie) {
        this.complementvoie = complementvoie;
    }

    public String getLieudit() {
        return lieudit;
    }

    public void setLieudit(String lieudit) {
        this.lieudit = lieudit;
    }

    public Integer getCodecommune() {
        return codecommune;
    }

    public void setCodecommune(Integer codecommune) {
        this.codecommune = codecommune;
    }

    public LocalDate getDatemajcoord() {
        return datemajcoord;
    }

    public void setDatemajcoord(LocalDate datemajcoord) {
        this.datemajcoord = datemajcoord;
    }

    public String getCodedepartement() {
        return codedepartement;
    }

    public void setCodedepartement(String codedepartement) {
        this.codedepartement = codedepartement;
    }

    public String getNomdepartement() {
        return nomdepartement;
    }

    public void setNomdepartement(String nomdepartement) {
        this.nomdepartement = nomdepartement;
    }

    public Servicepublichospitalier getCodesph() {
        return codesph;
    }

    public void setCodesph(Servicepublichospitalier codesph) {
        this.codesph = codesph;
    }

    public Modedefixationdestarif getCodemft() {
        return codemft;
    }

    public void setCodemft(Modedefixationdestarif codemft) {
        this.codemft = codemft;
    }

    public Codeape getCodeape() {
        return codeape;
    }

    public void setCodeape(Codeape codeape) {
        this.codeape = codeape;
    }

    public Categorieetablissement getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorieetablissement categorie) {
        this.categorie = categorie;
    }
}