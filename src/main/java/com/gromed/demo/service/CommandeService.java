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

        Integer quantite;
        Long montantTotal = Long.valueOf(0);

        /*Connection con = DbConnection.getConnection();
        con.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        String sql;
        PreparedStatement statement;
         */

        for (Estconstitueede estconstitueede : estconstitueedes) {
            Presentation presentation = estconstitueede.getPresentation();
            if (estconstitueede.getQuantite() > presentation.getQuantitedispo()) {
                estconstitueedesNoStocks.add(estconstitueede);
                quantite = estconstitueede.getQuantite() - presentation.getQuantitedispo();

                Estlivree estlivree = new Estlivree();
                System.out.println(commande.get().getId() + "  " + estconstitueede.getPresentation().getId());
                System.out.println(LocalDate.now() + "  " + Long.valueOf(presentation.getQuantitedispo()));
                estlivree.setIdcommande(commande.get());
                estlivree.setPresentation(estconstitueede.getPresentation());
                estlivree.setStatus("envoyer");
                estlivree.setDateenvoi(LocalDate.now());
                estlivree.setQuantite(presentation.getQuantitedispo());
                try{
                    estlivreeService.saveEstlivree(estlivree);
                }catch (Exception e){
                    throw e;
                }
                /*sql = "INSERT INTO estlivree (idcommande, codecip7, status, dateenvoi, quantite) VALUES (?, ?, ?, ?, ?)";
                statement = con.prepareStatement(sql);
                statement.setLong(1, commande.get().getId());
                statement.setLong(2, estconstitueede.getPresentation().getId());
                statement.setString(3, "envoyer");
                statement.setDate(4, Date.valueOf(LocalDate.now()));
                statement.setInt(5, presentation.getQuantitedispo());
                statement.executeUpdate();
                sql = "UPDATE estconstitueede SET quantite = ? WHERE id = ?";
                statement = con.prepareStatement(sql);
                statement.setInt(1, quantite);
                statement.setLong(2, estconstitueede.getId());
                statement.executeUpdate();
                */

                presentation.setQuantitedispo(0);
                try{
                    presentationService.savePresentation(presentation);
                }catch (Exception e){
                    throw e;
                }
                /*sql = "UPDATE presentation SET quantitedispo = ? WHERE codecip7 = ?";
                statement = con.prepareStatement(sql);
                statement.setInt(1, 0);
                statement.setLong(2, presentation.getId());
                statement.executeUpdate();
                 */

            } else {
                Estlivree estlivree = new Estlivree();
                estlivree.setIdcommande(commande.get());
                estlivree.setPresentation(estconstitueede.getPresentation());
                estlivree.setStatus("envoyer");
                estlivree.setDateenvoi(LocalDate.now());
                estlivree.setQuantite(estconstitueede.getQuantite());
                try{
                    estlivreeService.saveEstlivree(estlivree);
                }catch (Exception e){
                    throw e;
                }
                /*sql = "INSERT INTO estlivree (idcommande, codecip7, status, dateenvoi, quantite) VALUES (?, ?, ?, ?, ?)";
                statement = con.prepareStatement(sql);
                statement.setLong(1, commande.get().getId());
                statement.setLong(2, estconstitueede.getPresentation().getId());
                statement.setString(3, "envoyer");
                statement.setDate(4, Date.valueOf(LocalDate.now()));
                statement.setInt(5, estconstitueede.getQuantite());
                statement.executeUpdate();
                 */

                presentation.setQuantitedispo(presentation.getQuantitedispo()-estconstitueede.getQuantite());
                try {
                    presentationService.savePresentation(presentation);
                }catch (Exception e){
                    throw e;
                }
                /*sql = "UPDATE presentation SET quantitedispo = ? WHERE codecip7 = ?";
                statement = con.prepareStatement(sql);
                statement.setInt(1, presentation.getQuantitedispo()-estconstitueede.getQuantite());
                statement.setLong(2, presentation.getId());
                statement.executeUpdate();
                 */

                estconstitueede.setTerminer(true);
                try {
                    estconstitueedeService.saveEstconstitueede(estconstitueede);
                }catch (Exception e){
                    throw e;
                }
                /*sql = "UPDATE estconstitueede SET quantite = ?, terminer = ? WHERE id = ?";
                statement = con.prepareStatement(sql);
                statement.setInt(1, 0);
                statement.setBoolean(2, true);
                statement.setLong(3, estconstitueede.getId());
                statement.executeUpdate();
                 */
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
                saveCommande(commande.get());
            }catch (Exception e){
                throw e;
            }
            /*sql = "UPDATE commande SET status = ? WHERE idcommande = ?";
            statement = con.prepareStatement(sql);
            statement.setString(1, "terminer");
            statement.setLong(2, commande.get().getId());
            statement.executeUpdate();
             */
        }

        return estconstitueedesNoStocks;
    }
}
