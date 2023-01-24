package com.gromed.demo.controller;

import com.gromed.demo.service.InformeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/informe")
public class InformeController {

    @Autowired
    private InformeService informeService;

    @PostMapping
    public String save(@Valid @RequestBody InformeVO vO) {
        return informeService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        informeService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody InformeUpdateVO vO) {
        informeService.update(id, vO);
    }

    @GetMapping("/{id}")
    public InformeDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return informeService.getById(id);
    }

    @GetMapping
    public Page<InformeDTO> query(@Valid InformeQueryVO vO) {
        return informeService.query(vO);
    }
}
