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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flexpag.agendarpagamento.entities.Schedule;
import com.flexpag.agendarpagamento.entities.enums.ScheduleStatus;
import com.flexpag.agendarpagamento.services.ScheduleService;

@RestController
@RequestMapping(value = "/schedules")
public class ScheduleController {

	@Autowired
	ScheduleService scheduleService;

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		try {
			Schedule scheduleEntity = scheduleService.findById(id);
			if(scheduleEntity == null) {
				return ResponseEntity.notFound().build();
			}
			if(scheduleEntity.getScheduleStatus() == ScheduleStatus.PENDING) {
				scheduleService.delete(id);
				return ResponseEntity.ok("Agendamento excluído com sucesso");
			}else {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).
						body("O agendamento não pode ser excluído porque está como PAID");
			}
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Erro ao excluir o agendamento: " + e.getMessage());
		}

	}

	@DeleteMapping
	public ResponseEntity<String> deleteAll() {
		List<Schedule> scheduleEntity = scheduleService.findAll();
		
		try {
			for (Schedule aux : scheduleEntity) {
				if (aux.getScheduleStatus() == ScheduleStatus.PENDING) {
					scheduleService.delete(aux.getId());
				}
			}

			return ResponseEntity.ok("Agendamento 'PENDING' excluídos com sucesso!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Erro ao excluir o agendamento: " + e.getMessage());
		}
	}

	@PostMapping
	public ResponseEntity<Schedule> create(@RequestBody Schedule obj) {
		try {
			

			      Schedule savedSchedule = scheduleService.save(obj);
	        
	        return ResponseEntity.status(HttpStatus.CREATED).body(savedSchedule);
	    } catch (Exception e) {
	        throw new RuntimeException("Erro ao criar agendamento",e);
	    }
	}

	@GetMapping
	public ResponseEntity<List<Schedule>> findAll() {
		List<Schedule> scheduleEntitys = scheduleService.findAll();
		return ResponseEntity.ok().body(scheduleEntitys);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Schedule> findById(@PathVariable Long id) {
		Schedule scheduleEntity = scheduleService.findById(id);
		return ResponseEntity.ok().body(scheduleEntity);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Schedule> update(@PathVariable Long id, @RequestBody Schedule obj) {
		obj = scheduleService.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	@GetMapping("/search")
	public List<Schedule> searchScheduleByStatus(@RequestParam String status) {
		return scheduleService.findAllByScheduleStatus(Integer.parseInt(status));
	}
	

}
