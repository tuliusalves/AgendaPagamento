package com.flexpag.agendarpagamento.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flexpag.agendarpagamento.entities.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule,Long> {
	List<Schedule> findByName(String name);

}
