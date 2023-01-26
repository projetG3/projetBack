package com.gromed.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EstrembourseeaId implements Serializable {
    private static final Long serialVersionUID = 8749687658988860075L;
    @Column(name = "CODECIP7", nullable = false)
    private Long codecip7;

    @Column(name = "TAUX", nullable = false)
    private Long taux;

    public Long getCodecip7() {
        return codecip7;
    }

    public void setCodecip7(Long codecip7) {
        this.codecip7 = codecip7;
    }

    public Long getTaux() {
        return taux;
    }

    public void setTaux(Long taux) {
        this.taux = taux;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        EstrembourseeaId entity = (EstrembourseeaId) o;
        return Objects.equals(this.codecip7, entity.codecip7) &&
                Objects.equals(this.taux, entity.taux);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codecip7, taux);
    }

}