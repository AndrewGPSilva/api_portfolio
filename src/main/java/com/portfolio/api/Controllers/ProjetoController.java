package com.portfolio.api.Controllers;

import com.portfolio.api.Entities.Projeto;
import com.portfolio.api.Repositories.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projetos")
public class ProjetoController {

    @Autowired
    private ProjetoRepository repository;

    @GetMapping
    public List<Projeto> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Projeto create(@RequestBody Projeto projeto) {
        return repository.save(projeto);
    }
}
