package com.gromed.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "INFORME")
public class Informe {
    @EmbeddedId
    private InformeId id;

    @MapsId("codecis")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CODECIS", nullable = false)
    private Medicament codecis;

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumns({
            @JoinColumn(name = "DATEDEBUTINFO", referencedColumnName = "DATEDEBUTINFO", nullable = false),
            @JoinColumn(name = "DATEFININFO", referencedColumnName = "DATEFININFO", nullable = false),
            @JoinColumn(name = "INFORMATION", referencedColumnName = "INFORMATION", nullable = false)
    })
    private Informationsimportante informationsimportantes;

    public InformeId getId() {
        return id;
    }

    public void setId(InformeId id) {
        this.id = id;
    }

    public Medicament getCodecis() {
        return codecis;
    }

    public void setCodecis(Medicament codecis) {
        this.codecis = codecis;
    }

    public Informationsimportante getInformationsimportantes() {
        return informationsimportantes;
    }

    public void setInformationsimportantes(Informationsimportante informationsimportantes) {
        this.informationsimportantes = informationsimportantes;
    }

}