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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flexpag.agendarpagamento.entities.Schedules;
import com.flexpag.agendarpagamento.entities.enums.ScheduleStatus;
import com.flexpag.agendarpagamento.services.SchedulesService;

@RestController
@RequestMapping(value = "/schedules")
public class SchedulesController {

	@Autowired
	SchedulesService scheduleService;

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		try {
			Schedules scheduleEntity = scheduleService.findById(id);
			if (scheduleEntity == null) {
				return ResponseEntity.notFound().build();
			}
			if (scheduleEntity.getScheduleStatus() == ScheduleStatus.PENDING) {
				scheduleService.delete(id);
				return ResponseEntity.ok("Agendamento excluído com sucesso");
			} else {
				return ResponseEntity.status(HttpStatus.FORBIDDEN)
						.body("O agendamento não pode ser excluído porque está como PAID");
			}

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Erro ao excluir o agendamento: " + e.getMessage());
		}

	}

	@DeleteMapping
	public ResponseEntity<String> deleteAll() {
		List<Schedules> scheduleEntity = scheduleService.findAll();

		try {
			for (Schedules aux : scheduleEntity) {
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
	public ResponseEntity<Schedules> create(@RequestBody Schedules obj) {
		try {

			Schedules savedSchedule = scheduleService.save(obj);

			return ResponseEntity.status(HttpStatus.CREATED).body(savedSchedule);
		} catch (Exception e) {
			throw new RuntimeException("Erro ao criar agendamento", e);
		}
	}

	@GetMapping
	public ResponseEntity<List<Schedules>> findAll() {
		List<Schedules> scheduleEntitys = scheduleService.findAll();
		return ResponseEntity.ok().body(scheduleEntitys);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Schedules> findById(@PathVariable Long id) {
		Schedules scheduleEntity = scheduleService.findById(id);
		return ResponseEntity.ok().body(scheduleEntity);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Schedules> update(@PathVariable Long id, @RequestBody Schedules obj) {
		obj = scheduleService.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping("/search")
	public List<Schedules> searchScheduleByStatus(@RequestParam String status) {
		return scheduleService.findAllByScheduleStatus(Integer.parseInt(status));
	}

}
