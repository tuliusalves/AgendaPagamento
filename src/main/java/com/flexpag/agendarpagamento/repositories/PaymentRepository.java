package com.flexpag.agendarpagamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flexpag.agendarpagamento.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
	

}
