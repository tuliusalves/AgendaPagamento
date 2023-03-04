package com.flexpag.agendarpagamento.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flexpag.agendarpagamento.entities.Payment;
import com.flexpag.agendarpagamento.repositories.PaymentRepository;

@Service
public class PaymentService {
	@Autowired
	private PaymentRepository repository;

	// Retornando todos os pagamentos
	public List<Payment> findAll() {
		return repository.findAll();
	}

	// Retornando pagamento por Id
	public Payment findById(Long id) {
		Optional<Payment> pay = repository.findById(id);
		return pay.get();
	}

	// Método de inserir user
	public Payment insert(Payment obj) {
		return repository.save(obj);
	}
}
