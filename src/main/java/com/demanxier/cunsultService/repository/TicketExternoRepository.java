package com.demanxier.cunsultService.repository;

import com.demanxier.cunsultService.entity.TicketExterno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketExternoRepository extends JpaRepository<TicketExterno, Long> {
}
