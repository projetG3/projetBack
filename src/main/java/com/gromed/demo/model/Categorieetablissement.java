package com.gromed.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CATEGORIEETABLISSEMENT")
public class Categorieetablissement {
    @Id
    @Column(name = "CATEGORIE", nullable = false)
    private Integer id;

    @Column(name = "LIBELLECATEGORIE", nullable = false, length = 100)
    private String libellecategorie;

    @Column(name = "CATEGORIEAGREGAT", nullable = false, length = 4)
    private String categorieagregat;

    @Column(name = "LIBELLEAGREGAT", nullable = false, length = 100)
    private String libelleagregat;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibellecategorie() {
        return libellecategorie;
    }

    public void setLibellecategorie(String libellecategorie) {
        this.libellecategorie = libellecategorie;
    }

    public String getCategorieagregat() {
        return categorieagregat;
    }

    public void setCategorieagregat(String categorieagregat) {
        this.categorieagregat = categorieagregat;
    }

    public String getLibelleagregat() {
        return libelleagregat;
    }

    public void setLibelleagregat(String libelleagregat) {
        this.libelleagregat = libelleagregat;
    }

}