package com.demanxier.cunsultService.repository;

import com.demanxier.cunsultService.entity.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    @Query("SELECT t FROM Tarefa t WHERE t.status = 'CONCLUIDO' AND MONTH(t.dataConcluido) = MONTH(CURRENT_DATE) AND YEAR(t.dataConcluido) = YEAR(CURRENT_DATE)")
    List<Tarefa> findConcluidasNoMesAtual();
}
