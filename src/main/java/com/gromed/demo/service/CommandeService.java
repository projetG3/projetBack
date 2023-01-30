package com.gromed.demo.service;

import com.gromed.demo.model.Commande;
import com.gromed.demo.model.Estconstitueede;
import com.gromed.demo.model.Estlivree;
import com.gromed.demo.model.Presentation;
import com.gromed.demo.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
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

    @Transactional()
    public List<Estconstitueede> getStock(Optional<Commande> commande){
        List<Estconstitueede> estconstitueedesNoStocks = new ArrayList<>();
        List<Estconstitueede> estconstitueedes = commande.get().getEstconstitueedes();

        Long montantTotal = Long.valueOf(0);

        for (Estconstitueede estconstitueede : estconstitueedes) {
            Presentation presentation = estconstitueede.getPresentation();
            if (estconstitueede.getQuantite() > presentation.getQuantitedispo()) {
                estconstitueedesNoStocks.add(estconstitueede);

                Estlivree estlivree = new Estlivree();
                estlivree.setIdcommande(commande.get());
                estlivree.setPresentation(estconstitueede.getPresentation());
                estlivree.setStatus("envoyer");
                estlivree.setDateenvoi(LocalDate.now());
                estlivree.setQuantite(presentation.getQuantitedispo());
                try{
                    System.out.println("try est livree");
                    estlivreeService.saveEstlivree(estlivree);
                }catch (Exception e){
                    System.out.println("catch est livree");
                    throw e;
                }

                presentation.setQuantitedispo(0);
                try{
                    System.out.println("try presentation");
                    presentationService.savePresentation(presentation);
                }catch (Exception e){
                    System.out.println("catch presentation");
                    throw e;
                }

            } else {
                Estlivree estlivree = new Estlivree();
                estlivree.setIdcommande(commande.get());
                estlivree.setPresentation(estconstitueede.getPresentation());
                estlivree.setStatus("envoyer");
                estlivree.setDateenvoi(LocalDate.now());
                estlivree.setQuantite(estconstitueede.getQuantite());
                try{
                    System.out.println("try est livree");
                    estlivreeService.saveEstlivree(estlivree);
                }catch (Exception e){
                    System.out.println("catch est livree");
                    throw e;
                }

                presentation.setQuantitedispo(presentation.getQuantitedispo()-estconstitueede.getQuantite());
                try {
                    System.out.println("try presentation");
                    presentationService.savePresentation(presentation);
                }catch (Exception e){
                    System.out.println("catch presentation");
                    throw e;
                }

                estconstitueede.setTerminer(true);
                try {
                    System.out.println("try estconstituteede");
                    estconstitueedeService.saveEstconstitueede(estconstitueede);
                }catch (Exception e){
                    System.out.println("catch estconstituteede");
                    throw e;
                }
            }
            montantTotal+=presentation.getPrix();
        }

        if (estconstitueedesNoStocks.isEmpty()) {
            commande.get().setStatus("terminer");
            commande.get().setDateheurecommande(LocalDateTime.now());
            commande.get().setMontanttotal(montantTotal+"€");
            commande.get().setDatefacture(LocalDate.now());
            commande.get().setStatusfacture(true);
            try {
                System.out.println("try commande");
                saveCommande(commande.get());
            }catch (Exception e){
                System.out.println("catch commande");
                throw e;
            }
        }
        estconstitueedesNoStocks.forEach(s->System.out.println(s.getId()));
        return estconstitueedesNoStocks;
    }
}
