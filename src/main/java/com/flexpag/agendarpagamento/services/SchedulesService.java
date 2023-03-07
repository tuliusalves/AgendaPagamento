package com.flexpag.agendarpagamento.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flexpag.agendarpagamento.entities.Schedules;
import com.flexpag.agendarpagamento.repositories.SchedulesRepository;

@Service
public class SchedulesService {
	@Autowired
	SchedulesRepository repository;

	public void delete(Long id) {
		repository.deleteById(id);

	}
	public void deleteAll() {
		repository.deleteAll();
	}

	public List<Schedules> findAll() {
		return repository.findAll();
	}

	public Schedules findById(Long id) {
		Optional<Schedules> testeEntity = repository.findById(id);
		return testeEntity.get();
	}

	public Schedules update(Long id, Schedules obj) {
		Schedules entity = repository.getReferenceById(id);
		if (entity.checkStatus(entity.getScheduleStatus()) != true) {
			updateData(entity, obj);
		}
		return repository.save(entity);

	}

	private void updateData(Schedules entity, Schedules obj) {
		entity.setSheduleDate(obj.getSheduleDate());
	}

	public Schedules save(Schedules obj) {
		return repository.save(obj);
	}
	
	public List<Schedules> findAllByScheduleStatus(int status) {
		return repository.findAllByScheduleStatus(status);
	}

	
}
