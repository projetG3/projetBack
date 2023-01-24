package com.gromed.demo.controller;

import com.gromed.demo.service.CategorieetablissementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/categorieetablissement")
public class CategorieetablissementController {

    @Autowired
    private CategorieetablissementService categorieetablissementService;

    @PostMapping
    public String save(@Valid @RequestBody CategorieetablissementVO vO) {
        return categorieetablissementService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        categorieetablissementService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody CategorieetablissementUpdateVO vO) {
        categorieetablissementService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CategorieetablissementDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return categorieetablissementService.getById(id);
    }

    @GetMapping
    public Page<CategorieetablissementDTO> query(@Valid CategorieetablissementQueryVO vO) {
        return categorieetablissementService.query(vO);
    }
}
