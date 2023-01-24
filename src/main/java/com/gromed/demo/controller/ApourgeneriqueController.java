package com.gromed.demo.controller;

import com.gromed.demo.service.ApourgeneriqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/apourgenerique")
public class ApourgeneriqueController {

    @Autowired
    private ApourgeneriqueService apourgeneriqueService;

    @PostMapping
    public String save(@Valid @RequestBody ApourgeneriqueVO vO) {
        return apourgeneriqueService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        apourgeneriqueService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody ApourgeneriqueUpdateVO vO) {
        apourgeneriqueService.update(id, vO);
    }

    @GetMapping("/{id}")
    public ApourgeneriqueDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return apourgeneriqueService.getById(id);
    }

    @GetMapping
    public Page<ApourgeneriqueDTO> query(@Valid ApourgeneriqueQueryVO vO) {
        return apourgeneriqueService.query(vO);
    }
}
