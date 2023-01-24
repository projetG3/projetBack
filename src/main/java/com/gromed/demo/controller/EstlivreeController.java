package com.gromed.demo.controller;

import com.gromed.demo.service.EstlivreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/estlivree")
public class EstlivreeController {

    @Autowired
    private EstlivreeService estlivreeService;

    @PostMapping
    public String save(@Valid @RequestBody EstlivreeVO vO) {
        return estlivreeService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        estlivreeService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody EstlivreeUpdateVO vO) {
        estlivreeService.update(id, vO);
    }

    @GetMapping("/{id}")
    public EstlivreeDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return estlivreeService.getById(id);
    }

    @GetMapping
    public Page<EstlivreeDTO> query(@Valid EstlivreeQueryVO vO) {
        return estlivreeService.query(vO);
    }
}
