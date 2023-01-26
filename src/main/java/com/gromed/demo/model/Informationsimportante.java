package com.gromed.demo.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "INFORMATIONSIMPORTANTES")
public class Informationsimportante {
    @EmbeddedId
    private InformationsimportanteId id;

    public InformationsimportanteId getId() {
        return id;
    }

    public void setId(InformationsimportanteId id) {
        this.id = id;
    }
}