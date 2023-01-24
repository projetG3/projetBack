package com.gromed.demo.controller;

import com.gromed.demo.service.EstdelivresousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/estdelivresous")
public class EstdelivresousController {

    @Autowired
    private EstdelivresousService estdelivresousService;

    @PostMapping
    public String save(@Valid @RequestBody EstdelivresousVO vO) {
        return estdelivresousService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        estdelivresousService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody EstdelivresousUpdateVO vO) {
        estdelivresousService.update(id, vO);
    }

    @GetMapping("/{id}")
    public EstdelivresousDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return estdelivresousService.getById(id);
    }

    @GetMapping
    public Page<EstdelivresousDTO> query(@Valid EstdelivresousQueryVO vO) {
        return estdelivresousService.query(vO);
    }
}
