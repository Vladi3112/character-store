package com.ejemplo.characterstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.ejemplo.characterstore.service.SimpsonsMigrationService;
import com.ejemplo.characterstore.service.RickAndMortyMigrationService;

@Controller
@RequestMapping("/admin/migraciones")
public class MigrationController {

    private final SimpsonsMigrationService simpsonsMigrationService;
    private final RickAndMortyMigrationService rickAndMortyMigrationService;

    public MigrationController(
            SimpsonsMigrationService simpsonsMigrationService,
            RickAndMortyMigrationService rickAndMortyMigrationService) {
        this.simpsonsMigrationService = simpsonsMigrationService;
        this.rickAndMortyMigrationService = rickAndMortyMigrationService;
    }

    @GetMapping
    public String pantalla() {
        return "migraciones";
    }

    @PostMapping("/simpsons")
    public String migrarSimpsons(Model model) {
        int insertados = simpsonsMigrationService.migrarTodos();
        model.addAttribute("mensaje",
            "Migración Simpsons terminada. Nuevos registros: " + insertados);
        return "migraciones";
    }

    @PostMapping("/rickandmorty")
    public String migrarRickAndMorty(Model model) {
        int insertados = rickAndMortyMigrationService.migrarTodos();
        model.addAttribute("mensaje",
            "Migración Rick and Morty terminada. Nuevos registros: " + insertados);
        return "migraciones";
    }
}