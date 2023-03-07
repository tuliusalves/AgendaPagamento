package com.flexpag.agendarpagamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flexpag.agendarpagamento.entities.Payments;

public interface PaymentsRepository extends JpaRepository<Payments,Long> {
	

}
