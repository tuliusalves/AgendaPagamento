package com.flexpag.agendarpagamento.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.flexpag.agendarpagamento.entities.User;
import com.flexpag.agendarpagamento.services.UserService;

@RestController
@RequestMapping(value ="/tb_user")
public class UserResource {
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>>findAll(){
		List<User> users= service.findAll();
		return ResponseEntity.ok().body(users);
	}
	
	//EndPoint findById
	@GetMapping(value ="/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User user= service.findById(id);
		return ResponseEntity.ok().body(user);
	}
	
	//EndPoint Post user
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj){
		obj = service.insert(obj);
		//Convertendo para o objeto uri
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(null);
	}
}
