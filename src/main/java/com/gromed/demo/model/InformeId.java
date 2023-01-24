package com.gromed.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Embeddable
public class InformeId implements Serializable {
    private static final Long serialVersionUID = -5454294255022796044L;
    @Column(name = "CODECIS", nullable = false)
    private Integer codecis;

    @Column(name = "DATEDEBUTINFO", nullable = false)
    private LocalDate datedebutinfo;

    @Column(name = "DATEFININFO", nullable = false)
    private LocalDate datefininfo;

    @Column(name = "INFORMATION", nullable = false, length = 500)
    private String information;

    public Integer getCodecis() {
        return codecis;
    }

    public void setCodecis(Integer codecis) {
        this.codecis = codecis;
    }

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
        InformeId entity = (InformeId) o;
        return Objects.equals(this.datefininfo, entity.datefininfo) &&
                Objects.equals(this.codecis, entity.codecis) &&
                Objects.equals(this.datedebutinfo, entity.datedebutinfo) &&
                Objects.equals(this.information, entity.information);
    }

    @Override
    public int hashCode() {
        return Objects.hash(datefininfo, codecis, datedebutinfo, information);
    }

}