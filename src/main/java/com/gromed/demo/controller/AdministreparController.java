package com.gromed.demo.controller;

import com.gromed.demo.service.AdministreparService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/administrepar")
public class AdministreparController {

    @Autowired
    private AdministreparService administreparService;

    @PostMapping
    public String save(@Valid @RequestBody AdministreparVO vO) {
        return administreparService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        administreparService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody AdministreparUpdateVO vO) {
        administreparService.update(id, vO);
    }

    @GetMapping("/{id}")
    public AdministreparDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return administreparService.getById(id);
    }

    @GetMapping
    public Page<AdministreparDTO> query(@Valid AdministreparQueryVO vO) {
        return administreparService.query(vO);
    }
}
