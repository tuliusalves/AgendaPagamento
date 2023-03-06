package com.flexpag.agendarpagamento.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flexpag.agendarpagamento.repositories.TestRep;

@Service
public class TesteService {
	@Autowired
	TestRep repository;
	
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
