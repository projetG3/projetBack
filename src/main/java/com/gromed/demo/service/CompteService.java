package com.gromed.demo.service;

import com.gromed.demo.DbConnection;
import com.gromed.demo.model.Commande;
import com.gromed.demo.model.Compte;
import com.gromed.demo.repository.CommandeRepository;
import com.gromed.demo.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class CompteService {

    @Autowired
    private CompteRepository compteRepository;

    @Autowired
    private CommandeService commandeService;

    public Optional<Compte> getCompte(Long id) {
        return compteRepository.findById(id);
    }

    public List<Compte> getAllComptes() {
        return compteRepository.findAll();
    }

    public void deleteCompte(Long id) {
        compteRepository.deleteById(id);
    }

    public Compte saveCompte(Compte id){
        return compteRepository.save(id);
    }

    //RETURN un compte. Pour vérifier si il y a bien une commande en cours, il faut vérifier si l'id est null ou pas
    public Commande getCommandeEnCours(Long idCompte) throws SQLException {
        String myQuery = "select IDCOMMANDE from commande where idcompte =? and status = 'en cours'";
        Connection con = DbConnection.getConnection();
        PreparedStatement pst = con.prepareStatement(myQuery);
        pst.setLong(1, idCompte);
        ResultSet rs = pst.executeQuery();
        Commande commande = new Commande();
        boolean fini = false;
        Commande resultCommande = new Commande();
        while(rs.next() && !fini){
            fini = true;
            Optional<Commande> optionalCommande = commandeService.getCommande(rs.getLong("IDCOMMANDE"));
            resultCommande = optionalCommande.get();
        }
        return resultCommande;
    }
}
