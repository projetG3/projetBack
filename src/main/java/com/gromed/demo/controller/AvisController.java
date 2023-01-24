package com.gromed.demo.controller;

import com.gromed.demo.service.AvisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/avis")
public class AvisController {

    @Autowired
    private AvisService avisService;

    @PostMapping
    public String save(@Valid @RequestBody AvisVO vO) {
        return avisService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        avisService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody AvisUpdateVO vO) {
        avisService.update(id, vO);
    }

    @GetMapping("/{id}")
    public AvisDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return avisService.getById(id);
    }

    @GetMapping
    public Page<AvisDTO> query(@Valid AvisQueryVO vO) {
        return avisService.query(vO);
    }
}
