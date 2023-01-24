package com.example.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "ESTREMBOURSEEA")
public class Estrembourseea {
    @EmbeddedId
    private EstrembourseeaId id;

    @MapsId("codecip7")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CODECIP7", nullable = false)
    private Presentation codecip7;

    @MapsId("taux")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "TAUX", nullable = false)
    private Tauxderemboursement taux;

    public EstrembourseeaId getId() {
        return id;
    }

    public void setId(EstrembourseeaId id) {
        this.id = id;
    }

    public Presentation getCodecip7() {
        return codecip7;
    }

    public void setCodecip7(Presentation codecip7) {
        this.codecip7 = codecip7;
    }

    public Tauxderemboursement getTaux() {
        return taux;
    }

    public void setTaux(Tauxderemboursement taux) {
        this.taux = taux;
    }

}