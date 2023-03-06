package com.flexpag.agendarpagamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
 
import com.flexpag.agendarpagamento.entities.TesteEntity;

public interface TestRep extends JpaRepository<TesteEntity,Long> {

}
