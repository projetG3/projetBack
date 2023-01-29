package com.gromed.demo.service;

import com.gromed.demo.DbConnection;
import com.gromed.demo.model.*;
import com.gromed.demo.repository.PresentationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PresentationService {

    @Autowired
    private PresentationRepository presentationRepository;

    public Optional<Presentation> getPresentation(final Long id) {
        return presentationRepository.findById(id);
    }

    public List<Presentation> getAllPresentation() {
        return presentationRepository.findAll();
    }

    public void deletePresentation(final Long id) {
        presentationRepository.deleteById(id);
    }

    public Presentation savePresentation(Presentation presentation) {
        return presentationRepository.save(presentation);
    }

    public List<Presentation> getPresentationsByCriteria(CritereRecherche critereRecherche) throws SQLException {
        System.out.println("MES CRITERES RECU : ");
        System.out.println("- "+critereRecherche.getNom());
        System.out.println("- "+critereRecherche.getLibelle());
        System.out.println("- "+critereRecherche.getVoieAdministrations());
        System.out.println("- "+critereRecherche.getGenerique());
        String nom = critereRecherche.getNom();
        String libelle = critereRecherche.getLibelle();
        String generique = critereRecherche.getGenerique();
        List<String> voieAdministrations = critereRecherche.getVoieAdministrations();

        String myQuery = "SELECT P.* FROM PRESENTATION P " +
                "LEFT JOIN MEDICAMENT M ON P.CODECIS = M.CODECIS " +
                "LEFT JOIN APOURGENERIQUE A1 on M.CODECIS = A1.CODECIS " +
                "LEFT JOIN GENERIQUE G on A1.IDGENERIQUE = G.IDGENERIQUE " +
                "LEFT JOIN ADMINISTREPAR A2 on M.CODECIS = A2.CODECIS " +
                "WHERE (P.ETATCOMMERCIALISATION='Déclaration de commercialisation' " +
                "OR P.ETATCOMMERCIALISATION='D��claration de commercialisation') ";

        if (nom != null) {
            myQuery+="AND (UPPER(M.NOM) LIKE '%"+nom.toUpperCase()+"%') ";
        }
        if (libelle != null && generique != null) {
            myQuery+="AND (UPPER(P.LIBELLE) LIKE '%"+libelle.toUpperCase()+"%' ";
            myQuery+="OR UPPER(G.LIBELLE) LIKE '%"+generique.toUpperCase()+"%') ";
        } else if (libelle != null && generique == null) {
            myQuery+="AND (UPPER(P.LIBELLE) LIKE '%"+libelle.toUpperCase()+"%') ";
        } else if (libelle == null && generique != null) {
            myQuery+="OR UPPER(G.LIBELLE) LIKE '%"+generique.toUpperCase()+"%') ";
        }
        if(voieAdministrations.size()!=0){
            System.out.println("JE PASSE Là");
            for (int i = 0; i < voieAdministrations.size(); i++) {
                if(i==0){
                    myQuery+="AND (UPPER(A2.TYPEDEVOIE) LIKE '%"+voieAdministrations.get(i).toUpperCase()+"%' ";
                }else{
                    myQuery+="OR UPPER(A2.TYPEDEVOIE) LIKE '%"+voieAdministrations.get(i).toUpperCase()+"%' ";
                }
                myQuery+=")";

            }

        }

        System.out.println("REQUETE :"+myQuery);
        Connection con = DbConnection.getConnection();
        PreparedStatement pst = con.prepareStatement(myQuery);
/*
        if(nom != null){
            nom=nom.toUpperCase();
            pst.setString(1, nom);
        }
        if(libelle != null){
            libelle=libelle.toUpperCase();
            pst.setString(2, libelle);
        }
        if(generique != null){
            generique=generique.toUpperCase();
            pst.setString(3, generique);

        }
        if(voieAdministrations.size()!=0){
            for (int i = 0; i < voieAdministrations.size(); i++) {
                pst.setString(4+i, voieAdministrations.get(i).toUpperCase());
            }
        }
*/
        ResultSet rs = pst.executeQuery();
        List<Presentation> presentations = new ArrayList<>();
        Optional<Presentation> presentation;
        Presentation resultatPresentation;
        boolean fini = false;
        while(rs.next() && !fini){
            fini = true;
            presentation = this.getPresentation(rs.getLong("CODECIP7"));
            resultatPresentation = presentation.get();
            presentations.add(resultatPresentation);
            System.out.println(rs.getLong("CODECIP7"));
        }
        return presentations;
    }


}

