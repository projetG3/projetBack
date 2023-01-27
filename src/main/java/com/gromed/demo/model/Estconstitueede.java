package com.gromed.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@SequenceGenerator(name="ESTCONSTITUEEDE_SEQ",sequenceName="estconstitueede_SEQ", initialValue=1, allocationSize = 1)
@Table(name = "ESTCONSTITUEEDE")
public class Estconstitueede {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="ESTCONSTITUEEDE_SEQ")
    @Column(name="id")
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "CODECIP7", nullable = false)
    private Presentation presentation;

    @Column(name = "QUANTITE", nullable = false)
    private Integer quantite;

    @Column(name = "terminer")
    private Boolean terminer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinColumn(name="idcommande")
    private Commande idcommande;

    public Integer getId() {
        return id;
    }

    public Commande getIdcommande() {
        return idcommande;
    }

    public void setIdcommande(Commande idcommande) {
        this.idcommande = idcommande;
    }

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