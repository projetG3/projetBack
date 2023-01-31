package com.gromed.demo.service;

import com.gromed.demo.model.Commande;
import com.gromed.demo.model.Estconstitueede;
import com.gromed.demo.model.Estlivree;
import com.gromed.demo.model.Presentation;
import com.gromed.demo.repository.CommandeRepository;
import com.gromed.demo.repository.EstconstitueedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;
    @Autowired
    private EstconstitueedeService estconstitueedeService;
    @Autowired
    private EstlivreeService estlivreeService;
    @Autowired
    private PresentationService presentationService;
    @Autowired
    private EstconstitueedeRepository estconstitueedeRepository;

    public Optional<Commande> getCommande(Long id) {
        return commandeRepository.findById(id);
    }

    public List<Commande> getAllCommande() {
        return commandeRepository.findAll();
    }

    public void deleteCommande(Long id) {
        commandeRepository.deleteById(id);
    }

    public Commande saveCommande(Commande id){
        return commandeRepository.save(id);
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void getStockForce(Long id){
        List<Estconstitueede> estconstitueedesNoStocks = new ArrayList<>();
        Commande commande = getCommande(id).orElseThrow();
        List<Estconstitueede> estconstitueedes = commande.getEstconstitueedes();

        Long montantTotal = 0L;

        for (Estconstitueede estconstitueede : estconstitueedes) {
            Presentation presentation = estconstitueede.getPresentation();
            Estlivree estlivree = new Estlivree();
            estlivree.setIdcommande(commande);
            estlivree.setPresentation(estconstitueede.getPresentation());
            estlivree.setStatus("envoyer");
            estlivree.setDateenvoi(LocalDate.now());

            if(presentation.getQuantitedispo() == 0){
                estconstitueedesNoStocks.add(estconstitueede);
            }
            else if (estconstitueede.getQuantite() > presentation.getQuantitedispo() && presentation.getQuantitedispo() > 0) {
                estconstitueedesNoStocks.add(estconstitueede);

                estlivree.setQuantite(presentation.getQuantitedispo());
                estlivreeService.saveEstlivree(estlivree);

                presentation.setQuantitedispo(0);
            }
            else if (presentation.getQuantitedispo() >= estconstitueede.getQuantite()){
                estlivree.setQuantite(estconstitueede.getQuantite());
                estlivreeService.saveEstlivree(estlivree);

                int quantite = presentation.getQuantitedispo()-estconstitueede.getQuantite();
                presentation.setQuantitedispo(quantite);

                estconstitueede.setTerminer(true);
                estconstitueedeService.saveEstconstitueede(estconstitueede);
            }
            presentationService.savePresentation(presentation);

            montantTotal+=presentation.getPrix();
        }

        if (estconstitueedesNoStocks.size() != 0) {
            System.out.println(estconstitueedesNoStocks.isEmpty() + " "+estconstitueedesNoStocks.size());
            commande.setStatus("terminer");
            commande.setDateheurecommande(LocalDateTime.now());
            commande.setMontanttotal(montantTotal+"€");
            commande.setDatefacture(LocalDate.now());
            commande.setStatusfacture(true);
            saveCommande(commande);
        }
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public List<Presentation> getStock(Commande commande) {
        List<Presentation> presentations = new ArrayList<>();
        List<Estconstitueede> estconstitueedes = commande.getEstconstitueedes();
        List<Estconstitueede> estconstitueedesNoStock = new ArrayList<>();
        Long montantTotal = 0L;

        for (Estconstitueede estconstitueede : estconstitueedes) {
            Presentation presentation = estconstitueede.getPresentation();
            if (estconstitueede.getQuantite() < presentation.getQuantitedispo()) {
               estconstitueedesNoStock.add(estconstitueede);
            }
            else{
                presentations.add(presentation);
            }
            montantTotal += presentation.getPrix();
        }

        if(presentations.size() == 0){
            for(Estconstitueede estconstitueede : estconstitueedesNoStock){
                Presentation presentation = estconstitueede.getPresentation();

                Estlivree estlivree = new Estlivree();
                estlivree.setIdcommande(commande);
                estlivree.setPresentation(estconstitueede.getPresentation());
                estlivree.setStatus("envoyer");
                estlivree.setDateenvoi(LocalDate.now());
                estlivree.setQuantite(estconstitueede.getQuantite());
                estlivreeService.saveEstlivree(estlivree);

                int quantite = presentation.getQuantitedispo() - estconstitueede.getQuantite();
                presentation.setQuantitedispo(quantite);
                presentationService.savePresentation(presentation);

                estconstitueede.setTerminer(true);
                estconstitueedeService.saveEstconstitueede(estconstitueede);
            }

            commande.setStatus("terminer");
            commande.setDateheurecommande(LocalDateTime.now());
            commande.setMontanttotal(montantTotal+"€");
            commande.setDatefacture(LocalDate.now());
            commande.setStatusfacture(true);
            saveCommande(commande);
        }

        return presentations;
    }
}
