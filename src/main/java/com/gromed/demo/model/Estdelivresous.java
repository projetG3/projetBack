package com.gromed.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ESTDELIVRESOUS")
public class Estdelivresous {
    @EmbeddedId
    private EstdelivresousId id;

    @MapsId("PRESCRIPTION")
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "PRESCRIPTION", nullable = false)
    private Conditionsmedicamenteuse prescription;

    public EstdelivresousId getId() {
        return id;
    }

    public void setId(EstdelivresousId id) {
        this.id = id;
    }

}