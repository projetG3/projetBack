package com.gromed.demo.controller;

import com.gromed.demo.service.ConditionsmedicamenteuseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/conditionsmedicamenteuse")
public class ConditionsmedicamenteuseController {

    @Autowired
    private ConditionsmedicamenteuseService conditionsmedicamenteuseService;

    @PostMapping
    public String save(@Valid @RequestBody ConditionsmedicamenteuseVO vO) {
        return conditionsmedicamenteuseService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        conditionsmedicamenteuseService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody ConditionsmedicamenteuseUpdateVO vO) {
        conditionsmedicamenteuseService.update(id, vO);
    }

    @GetMapping("/{id}")
    public ConditionsmedicamenteuseDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return conditionsmedicamenteuseService.getById(id);
    }

    @GetMapping
    public Page<ConditionsmedicamenteuseDTO> query(@Valid ConditionsmedicamenteuseQueryVO vO) {
        return conditionsmedicamenteuseService.query(vO);
    }
}
