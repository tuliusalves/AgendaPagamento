package com.flexpag.agendarpagamento.entities;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "payments")
public class Payments implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long identificationNumber;
	private String recipientBank;
	private Double paymentAmount;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy:MM:dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant dueDate;

	public Payments() {
	}

	public Payments(Long identificationNumber, String recipientBank, Double paymentAmount, Instant dueDate) {
		super();
		this.identificationNumber = identificationNumber;
		this.recipientBank = recipientBank;
		this.paymentAmount = paymentAmount;
		this.dueDate = dueDate;
	}

	public Long getidentificationNumber() {
		return identificationNumber;
	}

	public void setidentificationNumber(Long identificationNumber) {
		this.identificationNumber = identificationNumber;
	}

	public String getrecipientBank() {
		return recipientBank;
	}

	public void setrecipientBank(String recipientBank) {
		this.recipientBank = recipientBank;
	}

	public Double getpaymentAmount() {
		return paymentAmount;
	}

	public void setpaymentAmount(Double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Instant getDueDate() {
		return dueDate;
	}

	public void setDueDate(Instant dueDate) {
		this.dueDate = dueDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identificationNumber == null) ? 0 : identificationNumber.hashCode());
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
		Payments other = (Payments) obj;
		if (identificationNumber == null) {
			if (other.identificationNumber != null)
				return false;
		} else if (!identificationNumber.equals(other.identificationNumber))
			return false;
		return true;
	}

}
