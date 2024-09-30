package com.demanxier.cunsultService.repository;

import com.demanxier.cunsultService.entity.Atendimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtendimentoRepository extends JpaRepository<Atendimento, Long> {
}
