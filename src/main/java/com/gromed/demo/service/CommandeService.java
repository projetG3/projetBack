package com.gromed.demo.service;

import com.gromed.demo.model.Commande;
import com.gromed.demo.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;

    public Optional<Commande> getCommande(Integer id) {
        return commandeRepository.findById(id);
    }

    public List<Commande> getAllCommande() {
        return commandeRepository.findAll();
    }

    public void deleteCommande(Integer id) {
        commandeRepository.deleteById(id);
    }

    public Commande saveCommande(Commande id){
        return commandeRepository.save(id);
    }
}
