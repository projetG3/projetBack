package com.gromed.demo.controller;

import com.gromed.demo.service.MedicamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/medicament")
public class MedicamentController {

    @Autowired
    private MedicamentService medicamentService;

    @PostMapping
    public String save(@Valid @RequestBody MedicamentVO vO) {
        return medicamentService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        medicamentService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody MedicamentUpdateVO vO) {
        medicamentService.update(id, vO);
    }

    @GetMapping("/{id}")
    public MedicamentDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return medicamentService.getById(id);
    }

    @GetMapping
    public Page<MedicamentDTO> query(@Valid MedicamentQueryVO vO) {
        return medicamentService.query(vO);
    }
}
