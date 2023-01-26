package com.gromed.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AdministreparId implements Serializable {
    private static final Long serialVersionUID = -3612089949395029532L;
    @Column(name = "CODECIS", nullable = false)
    private Long codecis;

    @Column(name = "TYPEDEVOIE", nullable = false, length = 50)
    private String typedevoie;

    public Long getCodecis() {
        return codecis;
    }

    public void setCodecis(Long codecis) {
        this.codecis = codecis;
    }

    public String getTypedevoie() {
        return typedevoie;
    }

    public void setTypedevoie(String typedevoie) {
        this.typedevoie = typedevoie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AdministreparId entity = (AdministreparId) o;
        return Objects.equals(this.codecis, entity.codecis) &&
                Objects.equals(this.typedevoie, entity.typedevoie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codecis, typedevoie);
    }

}