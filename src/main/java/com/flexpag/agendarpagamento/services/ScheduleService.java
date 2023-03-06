package com.flexpag.agendarpagamento.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flexpag.agendarpagamento.entities.Schedule;
import com.flexpag.agendarpagamento.repositories.ScheduleRepository;
@Service
public class ScheduleService {
	@Autowired
	private ScheduleRepository repository;
	
	/*Retornando todos os agendamentos
	 * É preciso retornar todos os pagamentos de acordo com o id
	 * do usuário*/
	public List<Schedule> findAll(){
		return repository.findAll();
	}
	
	//Retornando pagamento por Id
	public Schedule findById(Long id) {
		Optional<Schedule> schedule = repository.findById(id);
		return schedule.get();
	}

	//Método de inserir schedule
		public Schedule insert(Schedule obj) {
			return repository.save(obj);
		}
		
	//Método de deletar	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Schedule update(Long id, Schedule obj) {
		Schedule entity = repository.getReferenceById(id);
		if(entity.checkStatus(entity.getScheduleStatus()) !=true) {
			updateData(entity, obj);
		}
		return repository.save(entity);	
		
	}
	
	private void updateData(Schedule entity, Schedule obj) {
		entity.setSheduleDate(obj.getSheduleDate());
	}
	
	
}
