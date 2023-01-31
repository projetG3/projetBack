package com.gromed.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ADMINISTREPAR")
public class Administrepar {
    @EmbeddedId
    private AdministreparId id;

    @MapsId("voieadministration")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "TYPEDEVOIE", nullable = false)
    private VoieAdministration voieadministration;

    public AdministreparId getId() {
        return id;
    }

    public void setId(AdministreparId id) {
        this.id = id;
    }

    public VoieAdministration getVoieadministration() {
        return this.voieadministration;
    }
}