package com.jobhunter24.UserDataManagementAPI.api.controller;

import com.jobhunter24.UserDataManagementAPI.api.entity.Technology;
import com.jobhunter24.UserDataManagementAPI.api.service.ITechnologyService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/technology")
public class TechnologyController {
    private final ITechnologyService technologyService;

    public TechnologyController(ITechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    @PostMapping
    public ResponseEntity<Technology> addTechnology(@RequestBody @Valid Technology technology) {
        Technology responseTechnology = technologyService.addTechnology(technology);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseTechnology);
    }

    @GetMapping
    public ResponseEntity<List<Technology>> getAllTechnologies() {
        return ResponseEntity.status(HttpStatus.OK).body(technologyService.getAllTechnologies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Technology> getTechnologyById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(technologyService.getTechnologyById(id));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<Technology>> getTechnologyByUserId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(technologyService.getTechnologiesByUser(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTechnologyById(@PathVariable Long id) {
        technologyService.removeTechnology(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
