package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EstconstitueedeId implements Serializable {
    private static final Long serialVersionUID = 8234432470181781601L;
    @Column(name = "IDCOMMANDE", nullable = false)
    private Integer idcommande;

    @Column(name = "CODECIP7", nullable = false)
    private Integer codecip7;

    public Integer getIdcommande() {
        return idcommande;
    }

    public void setIdcommande(Integer idcommande) {
        this.idcommande = idcommande;
    }

    public Integer getCodecip7() {
        return codecip7;
    }

    public void setCodecip7(Integer codecip7) {
        this.codecip7 = codecip7;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        EstconstitueedeId entity = (EstconstitueedeId) o;
        return Objects.equals(this.codecip7, entity.codecip7) &&
                Objects.equals(this.idcommande, entity.idcommande);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codecip7, idcommande);
    }

}