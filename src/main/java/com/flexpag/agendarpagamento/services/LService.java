package com.flexpag.agendarpagamento.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flexpag.agendarpagamento.entities.L;
import com.flexpag.agendarpagamento.repositories.LRepository;
@Service
public class LService {
	@Autowired
	private LRepository repository;
	
	/*Retornando todos os agendamentos
	 * É preciso retornar todos os pagamentos de acordo com o id
	 * do usuário*/
	public List<L> findAll(){
		return repository.findAll();
	}
	
	//Retornando pagamento por Id
	public L findById(Long id) {
		Optional<L> schedule = repository.findById(id);
		return schedule.get();
	}

	//Método de inserir schedule
		public L insert(L obj) {
			return repository.save(obj);
		}
		
	//Método de deletar	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public L update(Long id, L obj) {
		L entity = repository.getReferenceById(id);
		if(entity.checkStatus(entity.getScheduleStatus()) !=true) {
			updateData(entity, obj);
		}
		return repository.save(entity);	
		
	}
	
	private void updateData(L entity, L obj) {
		entity.setSheduleDate(obj.getSheduleDate());
	}
	
	
}
