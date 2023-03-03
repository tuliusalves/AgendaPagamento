package com.flexpag.agendarpagamento.entities;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Agendamento")
public class Schedule implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	private Long id;
	private String scheduleStatus;
	private Date SheduleDate;
	
	public Schedule() {}

	public Schedule(Long id, String scheduleStatus, Date sheduleDate) {
		this.id = id;
		this.scheduleStatus = scheduleStatus;
		SheduleDate = sheduleDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getScheduleStatus() {
		return scheduleStatus;
	}

	public void setScheduleStatus(String scheduleStatus) {
		this.scheduleStatus = scheduleStatus;
	}

	public Date getSheduleDate() {
		return SheduleDate;
	}

	public void setSheduleDate(Date sheduleDate) {
		SheduleDate = sheduleDate;
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