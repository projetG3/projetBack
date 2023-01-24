package com.gromed.demo.controller;

import com.gromed.demo.service.InformationsimportantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/informationsimportantes")
public class InformationsimportantesController {

    @Autowired
    private InformationsimportantesService informationsimportantesService;

    @PostMapping
    public String save(@Valid @RequestBody InformationsimportantesVO vO) {
        return informationsimportantesService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        informationsimportantesService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody InformationsimportantesUpdateVO vO) {
        informationsimportantesService.update(id, vO);
    }

    @GetMapping("/{id}")
    public InformationsimportantesDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return informationsimportantesService.getById(id);
    }

    @GetMapping
    public Page<InformationsimportantesDTO> query(@Valid InformationsimportantesQueryVO vO) {
        return informationsimportantesService.query(vO);
    }
}
