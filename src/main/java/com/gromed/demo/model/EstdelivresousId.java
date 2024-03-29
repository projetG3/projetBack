package com.gromed.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EstdelivresousId implements Serializable {
    private static final Long serialVersionUID = -3697857833895638616L;
    @Column(name = "CODECIS", nullable = false)
    private Long codecis;

    @Column(name = "PRESCRIPTION", nullable = false, length = 500)
    private String prescription;

    public Long getCodecis() {
        return codecis;
    }

    public void setCodecis(Long codecis) {
        this.codecis = codecis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        EstdelivresousId entity = (EstdelivresousId) o;
        return Objects.equals(this.codecis, entity.codecis) &&
                Objects.equals(this.prescription, entity.prescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codecis, prescription);
    }
}