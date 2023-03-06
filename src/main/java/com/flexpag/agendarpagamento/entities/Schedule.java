package com.flexpag.agendarpagamento.entities;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.flexpag.agendarpagamento.entities.enums.ScheduleStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "schedules")
public class Schedule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	
	private Integer scheduleStatus;
	@JsonFormat(shape= JsonFormat.Shape.STRING, pattern ="yyyy:MM:dd'T'HH:mm:ss'Z'", timezone="GMT")
	private Instant sheduleDate;

	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "payment_id", referencedColumnName = "identificationNumber", nullable = false)
	private Payment payment;

	public Schedule() {
	}

	

	public Schedule(Long id, String name,ScheduleStatus scheduleStatus, Instant sheduleDate, User user, Payment payment) {
		super();
		this.id = id;
		setScheduleStatus(scheduleStatus);
		this.sheduleDate = sheduleDate;
		this.name = name;
		this.user = user;
		this.payment = payment;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Instant getSheduleDate() {
		return sheduleDate;
	}



	public void setSheduleDate(Instant sheduleDate) {
		this.sheduleDate = sheduleDate;
	}



	public ScheduleStatus getScheduleStatus() {
		return ScheduleStatus.valueOf(scheduleStatus);
	}

	public void setScheduleStatus(ScheduleStatus scheduleStatus) {
		if(scheduleStatus != null) {
			this.scheduleStatus = scheduleStatus.getCode();
		}
	}
	
	public boolean checkStatus( ScheduleStatus scheduleStatus) {
		if(scheduleStatus.getCode()==1) {
			return true;
		}else {
			return false;
		}
	}

}
