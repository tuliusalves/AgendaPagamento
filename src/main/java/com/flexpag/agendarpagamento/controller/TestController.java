package com.flexpag.agendarpagamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flexpag.agendarpagamento.services.TesteService;

@RestController
@RequestMapping(value = "/teste")
public class TestController {
	
	@Autowired
	TesteService service;
	
	@DeleteMapping(value ="/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id){
		
		 try {
		        // código para excluir o usuário com o ID fornecido
			 service.delete(id);
		        
		        return ResponseEntity.ok("Usuário excluído com sucesso");
		    } catch (Exception e) {
		        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
		            .body("Erro ao excluir o usuário: " + e.getMessage());
		    }
	 
		
		 
	}
}
