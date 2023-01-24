package com.gromed.demo.controller;

import JPA.services.EstrembourseeaService;
import com.gromed.demo.service.EstrembourseeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/estrembourseea")
public class EstrembourseeaController {

    @Autowired
    private EstrembourseeaService estrembourseeaService;

    @PostMapping
    public String save(@Valid @RequestBody EstrembourseeaVO vO) {
        return estrembourseeaService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        estrembourseeaService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody EstrembourseeaUpdateVO vO) {
        estrembourseeaService.update(id, vO);
    }

    @GetMapping("/{id}")
    public EstrembourseeaDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return estrembourseeaService.getById(id);
    }

    @GetMapping
    public Page<EstrembourseeaDTO> query(@Valid EstrembourseeaQueryVO vO) {
        return estrembourseeaService.query(vO);
    }
}
