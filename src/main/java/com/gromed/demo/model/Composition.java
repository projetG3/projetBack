package com.gromed.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "COMPOSITIONS")
public class Composition {
    @Id
    @Column(name = "IDCOMPO", nullable = false)
    private Long id;

    @Column(name = "CODESUBSTANCE")
    private Long codesubstance;

    @Column(name = "DESIGNATIONPHARMACEUTIQUE", nullable = false, length = 50)
    private String designationpharmaceutique;

    @Column(name = "DENOMINATIONSUBSTANCE", length = 50)
    private String denominationsubstance;

    @Column(name = "DOSAGE", length = 100)
    private String dosage;

    @Column(name = "REFERENCEDOSAGE", length = 50)
    private String referencedosage;

    @Column(name = "NATURE", length = 2)
    private String nature;

    @Column(name = "NUMEROLIER")
    private Integer numerolier;

    public Medicament getCodecis() {
        return codecis;
    }

    public void setCodecis(Medicament codecis) {
        this.codecis = codecis;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CODECIS")
    private Medicament codecis;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCodesubstance() {
        return codesubstance;
    }

    public void setCodesubstance(Long codesubstance) {
        this.codesubstance = codesubstance;
    }

    public String getDesignationpharmaceutique() {
        return designationpharmaceutique;
    }

    public void setDesignationpharmaceutique(String designationpharmaceutique) {
        this.designationpharmaceutique = designationpharmaceutique;
    }

    public String getDenominationsubstance() {
        return denominationsubstance;
    }

    public void setDenominationsubstance(String denominationsubstance) {
        this.denominationsubstance = denominationsubstance;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getReferencedosage() {
        return referencedosage;
    }

    public void setReferencedosage(String referencedosage) {
        this.referencedosage = referencedosage;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public Integer getNumerolier() {
        return numerolier;
    }

    public void setNumerolier(Integer numerolier) {
        this.numerolier = numerolier;
    }
}