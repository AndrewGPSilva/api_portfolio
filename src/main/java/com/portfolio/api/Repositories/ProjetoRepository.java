package com.portfolio.api.Repositories;

import com.portfolio.api.Entities.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
}
