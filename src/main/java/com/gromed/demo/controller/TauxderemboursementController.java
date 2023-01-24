package com.gromed.demo.controller;

import com.gromed.demo.service.TauxderemboursementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/tauxderemboursement")
public class TauxderemboursementController {

    @Autowired
    private TauxderemboursementService tauxderemboursementService;

    @PostMapping
    public String save(@Valid @RequestBody TauxderemboursementVO vO) {
        return tauxderemboursementService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        tauxderemboursementService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody TauxderemboursementUpdateVO vO) {
        tauxderemboursementService.update(id, vO);
    }

    @GetMapping("/{id}")
    public TauxderemboursementDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return tauxderemboursementService.getById(id);
    }

    @GetMapping
    public Page<TauxderemboursementDTO> query(@Valid TauxderemboursementQueryVO vO) {
        return tauxderemboursementService.query(vO);
    }
}
