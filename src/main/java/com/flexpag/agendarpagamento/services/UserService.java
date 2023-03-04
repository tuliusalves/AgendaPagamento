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
	
	//Retornando todos os pagamentos
	public List<User> findAll(){
		return repository.findAll();
	}
	
	//Retornando pagamento por Id
	public User findById(Long id) {
		Optional<User> user = repository.findById(id);
		return user.get();
	}
	
	//Método de inserir user
	public User insert(User obj) {
		return repository.save(obj);
	}
}
