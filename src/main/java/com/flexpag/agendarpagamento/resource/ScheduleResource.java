package com.flexpag.agendarpagamento.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flexpag.agendarpagamento.entities.Schedule;
import com.flexpag.agendarpagamento.services.ScheduleService;

@RestController
@RequestMapping(value = "/schedule")
public class ScheduleResource {
	
	@Autowired
	private ScheduleService service;
	
	@GetMapping
	public ResponseEntity<List<Schedule>>findAll(){
		List<Schedule> schedules= service.findAll();
		return ResponseEntity.ok().body(schedules);
	}
	
	//EndPoint findById
	@GetMapping(value ="/{id}")
	public ResponseEntity<Schedule> findById(@PathVariable Long id){
		Schedule schedule= service.findById(id);
		return ResponseEntity.ok().body(schedule);
	}
}
