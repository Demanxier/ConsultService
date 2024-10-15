package com.demanxier.cunsultService.repository;

import com.demanxier.cunsultService.entity.TicketExterno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketExternoRepository extends JpaRepository<TicketExterno, Long> {

    // Busca todos os tickets sem carregar os atendimentos
    @Query("SELECT t FROM TicketExterno t LEFT JOIN FETCH t.atendimentos a WHERE a.id IS NULL")
    List<TicketExterno> findAllTicketsSemAtendimentos();

    // Busca todos os tickets com seus atendimentos
    @Query("SELECT t FROM TicketExterno t LEFT JOIN FETCH t.atendimentos")
    List<TicketExterno> findAllTicketsComAtendimentos();
}
