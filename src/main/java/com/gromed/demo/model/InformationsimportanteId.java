package com.gromed.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Embeddable
public class InformationsimportanteId implements Serializable {
    private static final long serialVersionUID = 3621409816554154803L;
    @Column(name = "DATEDEBUTINFO", nullable = false)
    private LocalDate datedebutinfo;

    @Column(name = "DATEFININFO", nullable = false)
    private LocalDate datefininfo;

    @Column(name = "INFORMATION", nullable = false, length = 500)
    private String information;

    public LocalDate getDatedebutinfo() {
        return datedebutinfo;
    }

    public void setDatedebutinfo(LocalDate datedebutinfo) {
        this.datedebutinfo = datedebutinfo;
    }

    public LocalDate getDatefininfo() {
        return datefininfo;
    }

    public void setDatefininfo(LocalDate datefininfo) {
        this.datefininfo = datefininfo;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        InformationsimportanteId entity = (InformationsimportanteId) o;
        return Objects.equals(this.datefininfo, entity.datefininfo) &&
                Objects.equals(this.datedebutinfo, entity.datedebutinfo) &&
                Objects.equals(this.information, entity.information);
    }

    @Override
    public int hashCode() {
        return Objects.hash(datefininfo, datedebutinfo, information);
    }

}