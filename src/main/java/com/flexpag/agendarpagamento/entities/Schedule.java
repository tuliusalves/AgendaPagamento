package com.flexpag.agendarpagamento.entities;

import java.io.Serializable;
import java.util.Date;

//import com.flexpag.agendarpagamento.entities.enums.ScheduleStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Agendamento")
public class Schedule implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	private Long id;
	private boolean scheduleStatus;
	private Date sheduleDate;
	
	//Associação
	@ManyToOne
	@JoinColumn(name= "client_id")
	private User client;
	
	public Schedule() {}

	public Schedule(Long id, Boolean scheduleStatus, Date sheduleDate, User client) {
		this.id = id;
		this.scheduleStatus = scheduleStatus;
		this.sheduleDate = sheduleDate;
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getScheduleStatus() {
		return scheduleStatus;
	}

	public void setScheduleStatus(Boolean scheduleStatus) {
		this.scheduleStatus = scheduleStatus;
	}

	public Date getSheduleDate() {
		return sheduleDate;
	}

	public void setSheduleDate(Date sheduleDate) {
		this.sheduleDate = sheduleDate;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
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