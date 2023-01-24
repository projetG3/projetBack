package com.gromed.demo.controller;

import com.gromed.demo.service.ServicepublichospitalierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/servicepublichospitalier")
public class ServicepublichospitalierController {

    @Autowired
    private ServicepublichospitalierService servicepublichospitalierService;

    @PostMapping
    public String save(@Valid @RequestBody ServicepublichospitalierVO vO) {
        return servicepublichospitalierService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        servicepublichospitalierService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody ServicepublichospitalierUpdateVO vO) {
        servicepublichospitalierService.update(id, vO);
    }

    @GetMapping("/{id}")
    public ServicepublichospitalierDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return servicepublichospitalierService.getById(id);
    }

    @GetMapping
    public Page<ServicepublichospitalierDTO> query(@Valid ServicepublichospitalierQueryVO vO) {
        return servicepublichospitalierService.query(vO);
    }
}
