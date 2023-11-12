package com.portfolio.api.Controllers;

import com.portfolio.api.Entities.Projeto;
import com.portfolio.api.Repositories.ProjetoRepository;
import jakarta.transaction.Transactional;
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
    public ResponseEntity<List<Projeto>> getAll() {
        var Projetos = repository.findAll();
        return ResponseEntity.ok(Projetos);
    }

    @PostMapping("/api/projetos")
    @Transactional
    public ResponseEntity<Projeto> create(@RequestBody Projeto projeto) {
        repository.save(projeto);
        return ResponseEntity.ok(projeto);
    }

    @GetMapping("/api/projetos/{id}")
    public ResponseEntity<Projeto> show(@PathVariable Long id) {
        var projeto = repository.findById(id).orElse(null);

        if(projeto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(projeto);
    }

    @DeleteMapping("/api/projetos/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        var projeto = repository.findById(id);

        if(projeto.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
