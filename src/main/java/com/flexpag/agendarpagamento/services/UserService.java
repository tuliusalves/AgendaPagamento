package com.flexpag.agendarpagamento.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flexpag.agendarpagamento.entities.User;
import com.flexpag.agendarpagamento.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	// Retornando todos os pagamentos
	public List<User> findAll() {
		return repository.findAll();
	}

	// Retornando pagamento por Id
	public User findById(Long id) {
		Optional<User> user = repository.findById(id);
		return user.get();
	}

	// Método de inserir user
	public User insert(User obj) {
		return repository.save(obj);
	}

	// Método de deletar
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public User update(Long id, User obj) {
		User entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}
	
	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setCpf(obj.getCpf());
	}
}
