package com.portfolio.api.Controllers;

import com.portfolio.api.Entities.Projeto;
import com.portfolio.api.Repositories.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ProjetoController {

    @Autowired
    private ProjetoRepository repository;

    @GetMapping("/api/projetos")
    public List<Projeto> getAll() {
        return repository.findAll();
    }

    @PostMapping("/api/projetos")
    public Projeto create(@RequestBody Projeto projeto) {
        return repository.save(projeto);
    }

    @GetMapping("/api/projetos/{id}")
    public Projeto show(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @DeleteMapping("/api/projetos/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
