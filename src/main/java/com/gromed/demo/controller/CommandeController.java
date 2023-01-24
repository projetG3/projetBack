package com.gromed.demo.controller;

import com.gromed.demo.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/commande")
public class CommandeController {

    @Autowired
    private CommandeService commandeService;

    @PostMapping
    public String save(@Valid @RequestBody CommandeVO vO) {
        return commandeService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        commandeService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody CommandeUpdateVO vO) {
        commandeService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CommandeDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return commandeService.getById(id);
    }

    @GetMapping
    public Page<CommandeDTO> query(@Valid CommandeQueryVO vO) {
        return commandeService.query(vO);
    }
}
