package com.flexpag.agendarpagamento.entities;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.flexpag.agendarpagamento.entities.enums.ScheduleStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Agendamento")
public class Schedule implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	private Long id;
	private Integer scheduleStatus;
	@JsonFormat(shape= JsonFormat.Shape.STRING, pattern ="yyyy:MM:dd'T'HH:mm:ss'Z'", timezone="GMT")
	private Instant sheduleDate;
	
	//Associação
	@ManyToOne
	@JoinColumn(name= "client_id")
	private User client;
	
	@OneToOne
	@MapsId
	private Payment payment;
	
	
	
	public Schedule() {}

	public Schedule(Long id, ScheduleStatus scheduleStatus, Instant sheduleDate, User client, Payment payment) {
		this.id = id;
		setScheduleStatus(scheduleStatus);
		this.sheduleDate = sheduleDate;
		this.client = client;
		this.payment= payment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ScheduleStatus getScheduleStatus() {
		return ScheduleStatus.valueOf(scheduleStatus);
	}

	public void setScheduleStatus(ScheduleStatus scheduleStatus) {
		if(scheduleStatus != null) {
			this.scheduleStatus = scheduleStatus.getCode();
		}
	}

	public Instant getSheduleDate() {
		return sheduleDate;
	}

	public void setSheduleDate(Instant sheduleDate) {
		this.sheduleDate = sheduleDate;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}
	
	

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
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