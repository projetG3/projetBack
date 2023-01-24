package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EstcreeparId implements Serializable {
    private static final Long serialVersionUID = -4823655492404513331L;
    @Column(name = "CODECIS", nullable = false)
    private Integer codecis;

    @Column(name = "NOM", nullable = false, length = 50)
    private String nom;

    public Integer getCodecis() {
        return codecis;
    }

    public void setCodecis(Integer codecis) {
        this.codecis = codecis;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        EstcreeparId entity = (EstcreeparId) o;
        return Objects.equals(this.codecis, entity.codecis) &&
                Objects.equals(this.nom, entity.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codecis, nom);
    }

}