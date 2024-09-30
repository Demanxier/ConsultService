package com.demanxier.cunsultService.repository;

import com.demanxier.cunsultService.entity.Consultor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultorRepository extends JpaRepository<Consultor, Long> {
}
