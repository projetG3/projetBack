package com.gromed.demo.controller;

import com.gromed.demo.service.PresentationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/presentation")
public class PresentationController {

    @Autowired
    private PresentationService presentationService;

    @PostMapping
    public String save(@Valid @RequestBody PresentationVO vO) {
        return presentationService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        presentationService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody PresentationUpdateVO vO) {
        presentationService.update(id, vO);
    }

    @GetMapping("/{id}")
    public PresentationDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return presentationService.getById(id);
    }

    @GetMapping
    public Page<PresentationDTO> query(@Valid PresentationQueryVO vO) {
        return presentationService.query(vO);
    }
}
