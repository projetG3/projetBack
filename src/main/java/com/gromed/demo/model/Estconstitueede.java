package com.gromed.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ESTCONSTITUEEDE")
public class Estconstitueede {

    @Id
    @Column(name="id")
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "CODECIP7", nullable = false)
    private Presentation presentation;

    @Column(name = "QUANTITE", nullable = false)
    private Integer quantite;

    @Column(name = "terminer")
    private Boolean terminer;

    public Boolean getTerminer() {
        return terminer;
    }

    public void setTerminer(Boolean terminer) {
        this.terminer = terminer;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Presentation getPresentation() {
        return presentation;
    }

    public void setPresentation(Presentation presentation) {
        this.presentation = presentation;
    }
}