package com.flexpag.agendarpagamento.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flexpag.agendarpagamento.entities.Payments;
import com.flexpag.agendarpagamento.repositories.PaymentsRepository;

@Service
public class PaymentsService {
	@Autowired
	private PaymentsRepository repository;

	public List<Payments> findAll() {
		return repository.findAll();
	}
	
	public Payments findById(Long id) {
		Optional<Payments> pay = repository.findById(id);
		return pay.get();
	}

	public Payments save(Payments obj) {
		return repository.save(obj);
	}
}
