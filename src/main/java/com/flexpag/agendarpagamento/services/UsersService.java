package com.flexpag.agendarpagamento.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flexpag.agendarpagamento.entities.Users;
import com.flexpag.agendarpagamento.repositories.UsersRepository;

@Service
public class UsersService {

	@Autowired
	private UsersRepository repository;

	public List<Users> findAll() {
		return repository.findAll();
	}

	public Users findById(Long id) {
		Optional<Users> user = repository.findById(id);
		return user.get();
	}

	public Users insert(Users obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Users update(Long id, Users obj) {
		Users entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}
	
	private void updateData(Users entity, Users obj) {
		entity.setName(obj.getName());
		entity.setCpf(obj.getCpf());
	}
	
	public Users save(Users obj) {
		return repository.save(obj);
	}
}
