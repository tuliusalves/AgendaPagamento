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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "schedules")
public class Schedule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	private Integer scheduleStatus;
	@JsonFormat(shape= JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd'T'HH:mm:ss'Z'", timezone="GMT")
	private Instant sheduleDate;

	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
	private User user;
	
	@OneToOne
	@JoinColumn(name = "payment_id", referencedColumnName = "identificationNumber", nullable = false)
	private Payment payment;

	public Schedule() {
	}

	

	public Schedule(Long id, ScheduleStatus scheduleStatus, Instant sheduleDate, User user, Payment payment) {
		super();
		this.id = id;
		setScheduleStatus(scheduleStatus);
		this.sheduleDate = sheduleDate;
		this.user = user;
		this.payment = payment;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Schedule other = (Schedule) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
