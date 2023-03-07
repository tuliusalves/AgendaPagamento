package com.flexpag.agendarpagamento.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flexpag.agendarpagamento.entities.Schedules;

public interface SchedulesRepository extends JpaRepository<Schedules,Long> {
	List<Schedules> findAllByScheduleStatus(int statusId);
}
