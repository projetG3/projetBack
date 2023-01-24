package com.gromed.demo.controller;

import com.gromed.demo.service.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/compte")
public class CompteController {

    @Autowired
    private CompteService compteService;

    @PostMapping
    public String save(@Valid @RequestBody CompteVO vO) {
        return compteService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        compteService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody CompteUpdateVO vO) {
        compteService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CompteDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return compteService.getById(id);
    }

    @GetMapping
    public Page<CompteDTO> query(@Valid CompteQueryVO vO) {
        return compteService.query(vO);
    }
}
