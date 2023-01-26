package com.gromed.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ADMINISTREPAR")
public class Administrepar {
    @EmbeddedId
    private AdministreparId id;

    @MapsId("medicament")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CODECIS", nullable = false)
    private Medicament medicament;

    @MapsId("voieadministration")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "TYPEDEVOIE", nullable = false)
    private VoieAdministration voieadministration;

    public AdministreparId getId() {
        return id;
    }

    public void setId(AdministreparId id) {
        this.id = id;
    }

    public Medicament getMedicament() {
        return medicament;
    }

    public void setMedicament(Medicament medicament) {
        this.medicament = medicament;
    }

    public VoieAdministration getVoieadministration() {
        return voieadministration;
    }

    public void setVoieadministration(VoieAdministration voieadministration) {
        this.voieadministration = voieadministration;
    }

}