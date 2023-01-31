package com.gromed.demo.service;

import com.gromed.demo.model.*;
import com.gromed.demo.repository.PresentationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        ResultSet rs = SqlService.getPresentationByCritere(critereRecherche);
        List<ResultatRecherche> resultat = new ArrayList<>();
        ResultatRecherche resultatRecherche;
        while(rs.next()){
            resultatRecherche = new ResultatRecherche();
            resultatRecherche.setLibellePresentation(rs.getString("libelle"));
            resultatRecherche.setLibelleMedicament(rs.getString("nom"));
            resultatRecherche.setQuantite(rs.getInt("quantitedispo"));
            resultatRecherche.setTypeDeVoie(rs.getString("typedevoie"));
            resultatRecherche.setId(rs.getLong("codecip7"));
            resultatRecherche.setGenerique(rs.getString("generique"));
            resultatRecherche.setPrix(rs.getDouble("prix"));
            resultat.add(resultatRecherche);
        }
        return resultat;
    }

}

