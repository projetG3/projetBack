package com.gromed.demo.controller;

import com.gromed.demo.service.EstcreeparService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/estcreepar")
public class EstcreeparController {

    @Autowired
    private EstcreeparService estcreeparService;

    @PostMapping
    public String save(@Valid @RequestBody EstcreeparVO vO) {
        return estcreeparService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        estcreeparService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody EstcreeparUpdateVO vO) {
        estcreeparService.update(id, vO);
    }

    @GetMapping("/{id}")
    public EstcreeparDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return estcreeparService.getById(id);
    }

    @GetMapping
    public Page<EstcreeparDTO> query(@Valid EstcreeparQueryVO vO) {
        return estcreeparService.query(vO);
    }
}
