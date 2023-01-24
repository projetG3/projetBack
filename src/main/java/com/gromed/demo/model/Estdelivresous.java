package com.gromed.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ESTDELIVRESOUS")
public class Estdelivresous {
    @EmbeddedId
    private EstdelivresousId id;

    @MapsId("codecis")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CODECIS", nullable = false)
    private Medicament codecis;

    @MapsId("prescription")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PRESCRIPTION", nullable = false)
    private Conditionsmedicamenteuse prescription;

    public EstdelivresousId getId() {
        return id;
    }

    public void setId(EstdelivresousId id) {
        this.id = id;
    }

    public Medicament getCodecis() {
        return codecis;
    }

    public void setCodecis(Medicament codecis) {
        this.codecis = codecis;
    }

    public Conditionsmedicamenteuse getPrescription() {
        return prescription;
    }

    public void setPrescription(Conditionsmedicamenteuse prescription) {
        this.prescription = prescription;
    }

}