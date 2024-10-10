package com.demanxier.cunsultService.repository;

import com.demanxier.cunsultService.entity.Atendimento;
import com.demanxier.cunsultService.entity.enums.StatusAtendimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AtendimentoRepository extends JpaRepository<Atendimento, Long> {

    //Buscar por titulo contendo uma string específica(case-insensitive)
    List<Atendimento> findByTituloContainingIgnoreCase(String titulo);

    //Buscar por data entre duas datas
    List<Atendimento> findByDataBetween(LocalDate startDate, LocalDate endDate);

    //Combinação de filtros: titulo e período
    List<Atendimento> findByTituloContainingIgnoreCaseAndDataBetween(String titulo, LocalDate startDate, LocalDate endDate);

    List<Atendimento> findByStatusNot(StatusAtendimento statusAtendimento);
}
