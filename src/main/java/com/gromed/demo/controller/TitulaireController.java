package com.gromed.demo.controller;

import com.gromed.demo.service.TitulaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/titulaire")
public class TitulaireController {

    @Autowired
    private TitulaireService titulaireService;

    @PostMapping
    public String save(@Valid @RequestBody TitulaireVO vO) {
        return titulaireService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        titulaireService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody TitulaireUpdateVO vO) {
        titulaireService.update(id, vO);
    }

    @GetMapping("/{id}")
    public TitulaireDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return titulaireService.getById(id);
    }

    @GetMapping
    public Page<TitulaireDTO> query(@Valid TitulaireQueryVO vO) {
        return titulaireService.query(vO);
    }
}
