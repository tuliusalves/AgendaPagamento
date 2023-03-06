package com.flexpag.agendarpagamento.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flexpag.agendarpagamento.entities.TesteEntity;
import com.flexpag.agendarpagamento.repositories.TestRep;

@Service
public class TesteService {
	@Autowired
	TestRep repository;

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public List<TesteEntity> findAll() {
		return repository.findAll();
	}

	// Retornando pagamento por Id
	public TesteEntity findById(Long id) {
		Optional<TesteEntity> testeEntity = repository.findById(id);
		return testeEntity.get();
	}

	public TesteEntity update(Long id, TesteEntity obj) {
		TesteEntity entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);

	}

	private void updateData(TesteEntity entity, TesteEntity obj) {
		entity.setName(obj.getName());
	}

	public TesteEntity save(TesteEntity obj) {
		return repository.save(obj);
	}
	
	 public List<TesteEntity> findByTesteName(String name) {
	        return repository.findByName(name);
	    }
}
