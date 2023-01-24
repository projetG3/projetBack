package com.gromed.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AvisId implements Serializable {
    private static final Long serialVersionUID = -6540586047864385997L;
    @Column(name = "CODEHAS", nullable = false)
    private Integer codehas;

    @Column(name = "VALEUR", nullable = false, length = 500)
    private String valeur;

    @Column(name = "LIBELLE", nullable = false, length = 500)
    private String libelle;

    public Integer getCodehas() {
        return codehas;
    }

    public void setCodehas(Integer codehas) {
        this.codehas = codehas;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AvisId entity = (AvisId) o;
        return Objects.equals(this.valeur, entity.valeur) &&
                Objects.equals(this.libelle, entity.libelle) &&
                Objects.equals(this.codehas, entity.codehas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valeur, libelle, codehas);
    }

}