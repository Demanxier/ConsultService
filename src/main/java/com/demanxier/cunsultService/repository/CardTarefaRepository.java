package com.demanxier.cunsultService.repository;

import com.demanxier.cunsultService.entity.CardTarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardTarefaRepository extends JpaRepository<CardTarefa, Long> {
}
