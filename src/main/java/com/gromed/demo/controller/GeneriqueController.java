package com.gromed.demo.controller;

import com.gromed.demo.service.GeneriqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/generique")
public class GeneriqueController {

    @Autowired
    private GeneriqueService generiqueService;

    @PostMapping
    public String save(@Valid @RequestBody GeneriqueVO vO) {
        return generiqueService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        generiqueService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody GeneriqueUpdateVO vO) {
        generiqueService.update(id, vO);
    }

    @GetMapping("/{id}")
    public GeneriqueDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return generiqueService.getById(id);
    }

    @GetMapping
    public Page<GeneriqueDTO> query(@Valid GeneriqueQueryVO vO) {
        return generiqueService.query(vO);
    }
}
