package com.gromed.demo.service;

import com.gromed.demo.DbConnection;
import com.gromed.demo.model.CritereRecherche;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SqlService {

    Connection con = DbConnection.getConnection();

    public SqlService() throws SQLException {
        //do nothing
    }

    public static ResultSet getCommandeEnCours(Long idCompte) throws SQLException {
        Connection con = DbConnection.getConnection();
        String myQuery = "select IDCOMMANDE from commande where idcompte =? and status = 'en cours'";
        try(PreparedStatement pst = con.prepareStatement(myQuery)){
            pst.setLong(1, idCompte);
            return pst.executeQuery();
        }catch (Exception e){
            throw e;
        }
    }

    public static ResultSet getCommandeType(Long finesset) throws SQLException {
        Connection con = DbConnection.getConnection();
        String requete = "select commande.IDCOMMANDE from commande, compte where commande.nom is not null and commande.idcompte = compte.idcompte and compte.finesset = ?" ;
        try (PreparedStatement prepare = con.prepareStatement(requete)){
            prepare.setLong(1, finesset);
            return prepare.executeQuery();
        }catch (Exception e){
            throw e;
        }
    }

    public static ResultSet getPresentationByCritere(CritereRecherche critereRecherche) throws SQLException {
        Connection con = DbConnection.getConnection();

        String nom = critereRecherche.getLibellePresentation();
        String libelle = critereRecherche.getLibelleMedicament();
        String generique = critereRecherche.getGenerique();
        List<String> voieAdministrations = critereRecherche.getVoieAdministrations();
        List<String> params = new ArrayList<>() ;
        String myQuery = "SELECT P.CODECIP7, P.QUANTITEDISPO, M.NOM, A2.TYPEDEVOIE, P.LIBELLE, G.LIBELLE as generique, P.PRIX  FROM PRESENTATION P " +
                "LEFT JOIN MEDICAMENT M ON P.CODECIS = M.CODECIS " +
                "LEFT JOIN APOURGENERIQUE A1 on M.CODECIS = A1.CODECIS " +
                "LEFT JOIN GENERIQUE G on A1.IDGENERIQUE = G.IDGENERIQUE " +
                "LEFT JOIN ADMINISTREPAR A2 on M.CODECIS = A2.CODECIS " +
                "WHERE P.ETATCOMMERCIALISATION='Déclaration de commercialisation' ";

        if (critereRecherche.getLibellePresentation() != null) {
            myQuery+="AND (UPPER(M.NOM) LIKE ?) ";
            params.add("%"+nom.toUpperCase()+"%");

        }
        if (libelle != null && generique != null) {
            myQuery+="AND (UPPER(P.LIBELLE) LIKE ? OR UPPER(G.LIBELLE) LIKE ?) ";
            params.add("%"+libelle.toUpperCase()+"%");
            params.add("%"+generique.toUpperCase()+"%");
        } else if (libelle != null) {
            myQuery+="AND (UPPER(P.LIBELLE) LIKE ?) ";
            params.add("%"+libelle.toUpperCase()+"%");
        } else if (generique != null) {
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
        try(PreparedStatement pst = con.prepareStatement(myQuery)){
            for(int i = 0; i < params.size(); i++){
                pst.setString(i+1, params.get(i));
            }
            return pst.executeQuery();
        }catch (Exception e){
            throw e;
        }
    }
}
