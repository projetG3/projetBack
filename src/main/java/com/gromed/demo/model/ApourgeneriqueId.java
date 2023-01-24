package com.gromed.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ApourgeneriqueId implements Serializable {
    private static final Long serialVersionUID = -6634534253477997448L;
    @Column(name = "CODECIS", nullable = false)
    private Integer codecis;

    @Column(name = "IDGENERIQUE", nullable = false)
    private Integer idgenerique;

    public Integer getCodecis() {
        return codecis;
    }

    public void setCodecis(Integer codecis) {
        this.codecis = codecis;
    }

    public Integer getIdgenerique() {
        return idgenerique;
    }

    public void setIdgenerique(Integer idgenerique) {
        this.idgenerique = idgenerique;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ApourgeneriqueId entity = (ApourgeneriqueId) o;
        return Objects.equals(this.idgenerique, entity.idgenerique) &&
                Objects.equals(this.codecis, entity.codecis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idgenerique, codecis);
    }

}