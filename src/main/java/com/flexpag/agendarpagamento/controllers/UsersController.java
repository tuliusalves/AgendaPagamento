package com.flexpag.agendarpagamento.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flexpag.agendarpagamento.entities.Users;
import com.flexpag.agendarpagamento.services.UsersService;

@RestController
@RequestMapping(value = "/users")
public class UsersController {
	@Autowired
	private UsersService userService;

	@GetMapping
	public ResponseEntity<List<Users>> findAll() {
		List<Users> users = userService.findAll();
		return ResponseEntity.ok().body(users);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Users> findById(@PathVariable Long id) {
		Users user = userService.findById(id);
		return ResponseEntity.ok().body(user);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		userService.delete(id);

		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Users> update(@PathVariable Long id, @RequestBody Users obj) {
		obj = userService.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Users> create(@RequestBody Users obj) {
		try {

			Users savedUser = userService.save(obj);

			return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
		} catch (Exception e) {
			throw new RuntimeException("Erro ao criar usuário", e);
		}
	}
}
