package com.gromed.demo.service;

import com.gromed.demo.model.Commande;
import com.gromed.demo.model.Compte;
import com.gromed.demo.model.Estconstitueede;
import com.gromed.demo.model.Presentation;
import com.gromed.demo.repository.CompteRepository;
import com.gromed.demo.repository.EstconstitueedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class CompteService {

    @Autowired
    private CompteRepository compteRepository;

    @Autowired
    private CommandeService commandeService;

    @Autowired
    private EstconstitueedeService estconstitueedeService;
    @Autowired
    private EstconstitueedeRepository estconstitueedeRepository;

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

    public Commande getCommandeEnCours(Long idCompte) throws SQLException {
        ResultSet rs = SqlService.getCommandeEnCours(idCompte);
        while(rs.next()){
            Optional<Commande> optionalCommande = commandeService.getCommande(rs.getLong("IDCOMMANDE"));
            return optionalCommande.get();
        }
        return null;
    }

    public Commande createCommande(Compte compte) {
        Commande newCommande = new Commande();
        newCommande.setStatus("en cours");
        //ajouter le compte qui fait la commande
        newCommande.setCompte(compte);
        newCommande = commandeService.saveCommande(newCommande);
        //compte.addCommande(newCommande); //IL EST POSSIBLE QUE JE DOIVE ENLEVER CA
        return newCommande;
    }

    public Commande addProduct(Commande commandeEnCours, Presentation presentation, int quantite) throws SQLException {

        //il faut vérifier si le produit a déjà été ajouté au panier pour modifier la quantité
        int i = 0;
        while(i < commandeEnCours.getEstconstitueedes().size()){
            Estconstitueede estconstitueedeCourant = commandeEnCours.getEstconstitueedes().get(i);
            if(estconstitueedeCourant.getPresentation().getId() == presentation.getId()){
                estconstitueedeCourant.setQuantite(estconstitueedeCourant.getQuantite() + quantite);
                estconstitueedeService.saveEstconstitueede(estconstitueedeCourant);
                return commandeEnCours;
            }
            i++;
        }

        Estconstitueede estconstitueede = new Estconstitueede();
        estconstitueede.setTerminer(false);
        estconstitueede.setQuantite(quantite);
        estconstitueede.setPresentation(presentation);
        estconstitueede.setIdcommande(commandeEnCours);
        estconstitueede = estconstitueedeService.saveEstconstitueede(estconstitueede);
        commandeEnCours.addEstConstitueeDe(estconstitueede);
        return  commandeEnCours;
    }

    public List<Commande> getCommandeType(Compte compte) throws SQLException {
        ResultSet result = SqlService.getCommandeType(compte.getEtablissement().getId());
        List<Commande> commandeTypeList = new ArrayList<>();
        while (result.next()){
            Commande commande = commandeService.getCommande(result.getLong("IDCOMMANDE")).get();
            commandeTypeList.add(commande);
        }
        return commandeTypeList;
    }

    public Commande ajoutercommandeType(Commande commandeEnCours, Commande commandeType){
        System.out.println(commandeEnCours.getId() + " "+commandeType.getId());
        List<Estconstitueede> estconstitueedesType = commandeType.getEstconstitueedes();
        List<Estconstitueede> estconstitueedesCommande = commandeEnCours.getEstconstitueedes();
        HashMap<Long, Estconstitueede> dictionnaireCode = new HashMap<>();

        for (Estconstitueede estconstitueede: estconstitueedesCommande) {
            Presentation presentation = estconstitueede.getPresentation();
            System.out.println(estconstitueede.getId());
            dictionnaireCode.put(presentation.getId(), estconstitueede);
        }

        for (Estconstitueede estconstitueede: estconstitueedesType) {
            Presentation presentation = estconstitueede.getPresentation();
            if(dictionnaireCode.get(presentation.getId()) == null){
                Estconstitueede e = new Estconstitueede();
                e.setTerminer(false);
                e.setQuantite(estconstitueede.getQuantite());
                e.setPresentation(presentation);
                e.setIdcommande(commandeEnCours);
                estconstitueedeService.saveEstconstitueede(e);

                estconstitueedesCommande.add(e);
            }
            else {
                Estconstitueede e = dictionnaireCode.get(presentation.getId());
                System.out.println(e.getId());

                e.setQuantite(e.getQuantite()+estconstitueede.getQuantite());
                estconstitueedeService.saveEstconstitueede(e);
            }
        }
        commandeService.saveCommande(commandeEnCours);

        return commandeEnCours;
    }
}
