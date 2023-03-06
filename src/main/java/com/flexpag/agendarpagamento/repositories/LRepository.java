package com.flexpag.agendarpagamento.repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import com.flexpag.agendarpagamento.entities.L;

public interface LRepository extends JpaRepository<L,Long> {
	void deleteById(Long id);
}
