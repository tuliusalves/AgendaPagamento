package com.flexpag.agendarpagamento.controller;

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

import com.flexpag.agendarpagamento.entities.Schedule;
import com.flexpag.agendarpagamento.services.ScheduleService;

@RestController
@RequestMapping(value = "/teste")
public class ScheduleController {

	@Autowired
	ScheduleService testeService;

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {

		try {
			// código para excluir o usuário com o ID fornecido
			testeService.delete(id);

			return ResponseEntity.ok("Usuário excluído com sucesso");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Erro ao excluir o usuário: " + e.getMessage());
		}

	}
	
	@PostMapping
	public ResponseEntity<Schedule> create(@RequestBody Schedule obj){
		Schedule saveTesteEntity= testeService.save(obj);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveTesteEntity);
	}
	
	@GetMapping
	public ResponseEntity<List<Schedule>>findAll(){
		List<Schedule> TesteEntitys= testeService.findAll();
		return ResponseEntity.ok().body(TesteEntitys);
	}
	
	@GetMapping(value ="/{id}")
	public ResponseEntity<Schedule> findById(@PathVariable Long id){
		Schedule TesteEntity= testeService.findById(id);
		return ResponseEntity.ok().body(TesteEntity);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Schedule> update(@PathVariable Long id,@RequestBody Schedule obj ){
		obj = testeService.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping("/name/{name}")
    public ResponseEntity<List<Schedule>> findByTesteName(@PathVariable String name) {
        List<Schedule> testes = testeService.findByTesteName(name);
        if (testes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(testes);
    }
}
