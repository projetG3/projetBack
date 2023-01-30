package com.gromed.demo.service;

import com.gromed.demo.model.Commande;
import com.gromed.demo.model.Estconstitueede;
import com.gromed.demo.model.Estlivree;
import com.gromed.demo.model.Presentation;
import com.gromed.demo.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    @Transactional
    public Boolean getStockForce(Long id){
        List<Estconstitueede> estconstitueedesNoStocks = new ArrayList<>();
        Commande commande = getCommande(id).orElseThrow();
        List<Estconstitueede> estconstitueedes = commande.getEstconstitueedes();

        Long montantTotal = 0L;

        for (Estconstitueede estconstitueede : estconstitueedes) {
            Presentation presentation = estconstitueede.getPresentation();
            if (estconstitueede.getQuantite() > presentation.getQuantitedispo()) {
                estconstitueedesNoStocks.add(estconstitueede);

                Estlivree estlivree = new Estlivree();
                estlivree.setIdcommande(commande);
                estlivree.setPresentation(estconstitueede.getPresentation());
                estlivree.setStatus("envoyer");
                estlivree.setDateenvoi(LocalDate.now());
                estlivree.setQuantite(presentation.getQuantitedispo());
                estlivreeService.saveEstlivree(estlivree);

                presentation.setQuantitedispo(0);
                presentationService.savePresentation(presentation);

            } else {
                Estlivree estlivree = new Estlivree();
                estlivree.setIdcommande(commande);
                estlivree.setPresentation(estconstitueede.getPresentation());
                estlivree.setStatus("envoyer");
                estlivree.setDateenvoi(LocalDate.now());
                estlivree.setQuantite(estconstitueede.getQuantite());
                estlivreeService.saveEstlivree(estlivree);

                int quantite = presentation.getQuantitedispo()-estconstitueede.getQuantite();
                presentation.setQuantitedispo(quantite);
                presentationService.savePresentation(presentation);

                estconstitueede.setTerminer(true);
                estconstitueedeService.saveEstconstitueede(estconstitueede);
            }
            montantTotal+=presentation.getPrix();
        }

        if (estconstitueedesNoStocks.isEmpty()) {
            commande.setStatus("terminer");
            commande.setDateheurecommande(LocalDateTime.now());
            commande.setMontanttotal(montantTotal+"€");
            commande.setDatefacture(LocalDate.now());
            commande.setStatusfacture(true);
            saveCommande(commande);
        }
        estconstitueedesNoStocks.forEach(s->System.out.println(s.getId()));
        return true;
    }

    @Transactional
    public List<Presentation> getStock(Commande commande) {
        List<Presentation> presentations = new ArrayList<>();
        List<Estconstitueede> estconstitueedes = commande.getEstconstitueedes();
        Long montantTotal = 0L;

        for (Estconstitueede estconstitueede : estconstitueedes) {
            Presentation presentation = estconstitueede.getPresentation();
            if (estconstitueede.getQuantite() < presentation.getQuantitedispo()) {
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
            else{
                presentations.add(presentation);
            }
            montantTotal += presentation.getPrix();
        }

        if(presentations.isEmpty()){
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
