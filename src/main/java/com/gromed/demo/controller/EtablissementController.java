package com.gromed.demo.controller;

import com.gromed.demo.service.EtablissementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/etablissement")
public class EtablissementController {

    @Autowired
    private EtablissementService etablissementService;

    @PostMapping
    public String save(@Valid @RequestBody EtablissementVO vO) {
        return etablissementService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        etablissementService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody EtablissementUpdateVO vO) {
        etablissementService.update(id, vO);
    }

    @GetMapping("/{id}")
    public EtablissementDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return etablissementService.getById(id);
    }

    @GetMapping
    public Page<EtablissementDTO> query(@Valid EtablissementQueryVO vO) {
        return etablissementService.query(vO);
    }
}
