package com.gromed.demo.controller;

import com.gromed.demo.service.ModedefixationdestarifsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/modedefixationdestarifs")
public class ModedefixationdestarifsController {

    @Autowired
    private ModedefixationdestarifsService modedefixationdestarifsService;

    @PostMapping
    public String save(@Valid @RequestBody ModedefixationdestarifsVO vO) {
        return modedefixationdestarifsService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        modedefixationdestarifsService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody ModedefixationdestarifsUpdateVO vO) {
        modedefixationdestarifsService.update(id, vO);
    }

    @GetMapping("/{id}")
    public ModedefixationdestarifsDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return modedefixationdestarifsService.getById(id);
    }

    @GetMapping
    public Page<ModedefixationdestarifsDTO> query(@Valid ModedefixationdestarifsQueryVO vO) {
        return modedefixationdestarifsService.query(vO);
    }
}
