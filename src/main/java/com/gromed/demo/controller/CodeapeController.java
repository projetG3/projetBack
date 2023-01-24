package com.gromed.demo.controller;

import com.gromed.demo.service.CodeapeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/codeape")
public class CodeapeController {

    @Autowired
    private CodeapeService codeapeService;

    @PostMapping
    public String save(@Valid @RequestBody CodeapeVO vO) {
        return codeapeService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        codeapeService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody CodeapeUpdateVO vO) {
        codeapeService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CodeapeDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return codeapeService.getById(id);
    }

    @GetMapping
    public Page<CodeapeDTO> query(@Valid CodeapeQueryVO vO) {
        return codeapeService.query(vO);
    }
}
