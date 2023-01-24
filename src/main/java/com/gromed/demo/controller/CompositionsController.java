package com.gromed.demo.controller;

import com.gromed.demo.service.CompositionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/compositions")
public class CompositionsController {

    @Autowired
    private CompositionsService compositionsService;

    @PostMapping
    public String save(@Valid @RequestBody CompositionsVO vO) {
        return compositionsService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        compositionsService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody CompositionsUpdateVO vO) {
        compositionsService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CompositionsDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return compositionsService.getById(id);
    }

    @GetMapping
    public Page<CompositionsDTO> query(@Valid CompositionsQueryVO vO) {
        return compositionsService.query(vO);
    }
}
