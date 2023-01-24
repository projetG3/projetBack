package com.gromed.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ADMINISTREPAR")
public class Administrepar {
    @EmbeddedId
    private AdministreparId id;

    @MapsId("codecis")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CODECIS", nullable = false)
    private Medicament codecis;

    @MapsId("typedevoie")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "TYPEDEVOIE", nullable = false)
    private Voieadministration typedevoie;

    public AdministreparId getId() {
        return id;
    }

    public void setId(AdministreparId id) {
        this.id = id;
    }

    public Medicament getCodecis() {
        return codecis;
    }

    public void setCodecis(Medicament codecis) {
        this.codecis = codecis;
    }

    public Voieadministration getTypedevoie() {
        return typedevoie;
    }

    public void setTypedevoie(Voieadministration typedevoie) {
        this.typedevoie = typedevoie;
    }

}