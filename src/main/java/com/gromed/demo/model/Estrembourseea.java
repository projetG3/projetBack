package com.gromed.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ESTREMBOURSEEA")
public class Estrembourseea {
    @EmbeddedId
    private EstrembourseeaId id;

    @MapsId("taux")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "TAUX", nullable = false)
    private Tauxderemboursement taux;

    public EstrembourseeaId getId() {
        return id;
    }

    public void setId(EstrembourseeaId id) {
        this.id = id;
    }

}