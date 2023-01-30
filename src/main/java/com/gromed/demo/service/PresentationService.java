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

    public List<ResultatRecherche> getPresentationsByCriteria(CritereRecherche critereRecherche) throws SQLException {
        String nom = critereRecherche.getNom();
        String libelle = critereRecherche.getLibelle();
        String generique = critereRecherche.getGenerique();
        List<String> voieAdministrations = critereRecherche.getVoieAdministrations();
        List<String> params = new ArrayList<String>() ;
        String myQuery = "SELECT P.CODECIP7, P.QUANTITEDISPO, M.NOM, A2.TYPEDEVOIE, P.LIBELLE  FROM PRESENTATION P " +
                "LEFT JOIN MEDICAMENT M ON P.CODECIS = M.CODECIS " +
                "LEFT JOIN APOURGENERIQUE A1 on M.CODECIS = A1.CODECIS " +
                "LEFT JOIN GENERIQUE G on A1.IDGENERIQUE = G.IDGENERIQUE " +
                "LEFT JOIN ADMINISTREPAR A2 on M.CODECIS = A2.CODECIS " +
                "WHERE P.ETATCOMMERCIALISATION='Déclaration de commercialisation' ";

        if (nom != null) {
            myQuery+="AND (UPPER(M.NOM) LIKE ?) ";
            params.add("%"+nom.toUpperCase()+"%");

        }
        if (libelle != null && generique != null) {
            myQuery+="AND (UPPER(P.LIBELLE) LIKE ? OR UPPER(G.LIBELLE) LIKE ?) ";
            params.add("%"+libelle.toUpperCase()+"%");
            params.add("%"+generique.toUpperCase()+"%");
        } else if (libelle != null && generique == null) {
            myQuery+="AND (UPPER(P.LIBELLE) LIKE ?) ";
            params.add("%"+libelle.toUpperCase()+"%");
        } else if (libelle == null && generique != null) {
            myQuery+="OR UPPER(G.LIBELLE) LIKE ?) ";
            params.add("%"+generique.toUpperCase()+"%");
        }
        if(voieAdministrations.size()!=0){
            for (int i = 0; i < voieAdministrations.size(); i++) {
                if(i==0){
                    myQuery+="AND (UPPER(A2.TYPEDEVOIE) LIKE ? ";
                }else{
                    myQuery+="OR UPPER(A2.TYPEDEVOIE) LIKE ? ";
                }
                params.add("%"+voieAdministrations.get(i).toUpperCase()+"%");
                myQuery+=")";

            }

        }

        Connection con = DbConnection.getConnection();
        PreparedStatement pst = con.prepareStatement(myQuery);
        System.out.println(myQuery);
        for(int i = 0; i < params.size(); i++){
            pst.setString(i+1, params.get(i));
        }
        ResultSet rs = pst.executeQuery();
        List<ResultatRecherche> resultat = new ArrayList<>();
        ResultatRecherche resultatRecherche;
        while(rs.next()){
            resultatRecherche = new ResultatRecherche();
            resultatRecherche.setLibellePresentation(rs.getString("libelle"));
            resultatRecherche.setNomMedicament(rs.getString("nom"));
            resultatRecherche.setQuantite(rs.getInt("quantitedispo"));
            resultatRecherche.setTypedevoie(rs.getString("typedevoie"));
            resultatRecherche.setCodeCIP7(rs.getLong("codecip7"));
            resultat.add(resultatRecherche);
        }
        pst.close();
        return resultat;
    }

}

