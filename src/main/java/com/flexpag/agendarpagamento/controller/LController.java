package com.flexpag.agendarpagamento.controller;

import java.net.URI;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.flexpag.agendarpagamento.entities.L;
import com.flexpag.agendarpagamento.services.LService;

@RestController
@RequestMapping(value = "/schedule")
public class LController {
	
	@Autowired
	private LService sheduleService;
	
	@GetMapping
	public ResponseEntity<List<L>>findAll(){
		List<L> schedules= sheduleService.findAll();
		return ResponseEntity.ok().body(schedules);
	}
	@GetMapping(value ="/{id}")
	public ResponseEntity<L> findById(@PathVariable Long id){
		L schedule= sheduleService.findById(id);
		return ResponseEntity.ok().body(schedule);
	}
	
		@PostMapping
		public ResponseEntity<L> insert(@RequestBody L obj){
			obj = sheduleService.insert(obj);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(obj.getId()).toUri();
			return ResponseEntity.created(uri).body(null);
		}
		
		@DeleteMapping(value ="/{id}")
		public ResponseEntity<String> delete(@PathVariable Long id){
			
			 try {
			        // código para excluir o usuário com o ID fornecido
				 sheduleService.delete(id);
			        
			        return ResponseEntity.ok("Usuário excluído com sucesso");
			    } catch (Exception e) {
			        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
			            .body("Erro ao excluir o usuário: " + e.getMessage());
			    } 
		}
		
		@PutMapping(value = "/{id}")
		public ResponseEntity<L> update(@PathVariable Long id,@RequestBody L obj ){
			obj = sheduleService.update(id, obj);
			return ResponseEntity.ok().body(obj);
		}
}
