package com.gromed.demo.controller;

import com.gromed.demo.service.VoieAdministrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/voieadministration")
public class VoieAdministrationController {

    @Autowired
    private VoieAdministrationService voieadministrationService;

    @PostMapping
    public String save(@Valid @RequestBody VoieadministrationVO vO) {
        return voieadministrationService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        voieadministrationService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody VoieadministrationUpdateVO vO) {
        voieadministrationService.update(id, vO);
    }

    @GetMapping("/{id}")
    public VoieadministrationDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return voieadministrationService.getById(id);
    }

    @GetMapping
    public Page<VoieadministrationDTO> query(@Valid VoieadministrationQueryVO vO) {
        return voieadministrationService.query(vO);
    }
}
