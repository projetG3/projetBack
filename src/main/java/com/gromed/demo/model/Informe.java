package com.gromed.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "INFORME")
public class Informe {
    @EmbeddedId
    private InformeId id;

    @MapsId
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "DATEDEBUTINFO", referencedColumnName = "DATEDEBUTINFO", nullable = false)
    @JoinColumn(name = "DATEFININFO", referencedColumnName = "DATEFININFO", nullable = false)
    @JoinColumn(name = "INFORMATION", referencedColumnName = "INFORMATION", nullable = false)
    private Informationsimportante informationsimportantes;

    public InformeId getId() {
        return id;
    }

    public void setId(InformeId id) {
        this.id = id;
    }

    public Informationsimportante getInformationsimportantes() {
        return this.informationsimportantes;
    }
}