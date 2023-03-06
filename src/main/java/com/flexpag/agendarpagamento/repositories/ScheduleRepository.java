package com.flexpag.agendarpagamento.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.flexpag.agendarpagamento.entities.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule,Long> {
	void deleteById(Long id);
}
