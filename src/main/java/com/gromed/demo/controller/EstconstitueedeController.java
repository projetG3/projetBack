package com.gromed.demo.controller;

import com.gromed.demo.service.EstconstitueedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/estconstitueede")
public class EstconstitueedeController {

    @Autowired
    private EstconstitueedeService estconstitueedeService;

    @PostMapping
    public String save(@Valid @RequestBody EstconstitueedeVO vO) {
        return estconstitueedeService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        estconstitueedeService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody EstconstitueedeUpdateVO vO) {
        estconstitueedeService.update(id, vO);
    }

    @GetMapping("/{id}")
    public EstconstitueedeDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return estconstitueedeService.getById(id);
    }

    @GetMapping
    public Page<EstconstitueedeDTO> query(@Valid EstconstitueedeQueryVO vO) {
        return estconstitueedeService.query(vO);
    }
}
