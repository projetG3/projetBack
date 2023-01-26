package com.gromed.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "APOURGENERIQUE")
public class Apourgenerique {
    @EmbeddedId
    private ApourgeneriqueId id;

    @MapsId("codecis")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "CODECIS", nullable = false)
    private Medicament medicament;

    @MapsId("idgenerique")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "IDGENERIQUE", nullable = false)
    private Generique generique;

    @Column(name = "TYPE", nullable = false)
    private Integer type;

    @Column(name = "TRIE", nullable = false)
    private Integer trie;

    public ApourgeneriqueId getId() {
        return id;
    }

    public void setId(ApourgeneriqueId id) {
        this.id = id;
    }

    public Medicament getMedicament() {
        return medicament;
    }

    public void setMedicament(Medicament medicament) {
        this.medicament = medicament;
    }

    public Generique getGenerique() {
        return generique;
    }

    public void setGenerique(Generique idgenerique) {
        this.generique = idgenerique;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getTrie() {
        return trie;
    }

    public void setTrie(Integer trie) {
        this.trie = trie;
    }

}