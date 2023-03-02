package com.flexpag.agendarpagamento.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="payment")
public class Payment implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private Long identificationNumber;
	private String recipientBank;
	private String payingName;
	private Double paymentAmount;
	/*Falta por a data de vencimento e data débito*/
	public Payment() {}
	
	public Payment(Long identificationNumber, String recipientBank, String payingName, Double paymentAmount) {
		super();
		this.identificationNumber = identificationNumber;
		this.recipientBank = recipientBank;
		this.payingName = payingName;
		this.paymentAmount = paymentAmount;
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

	public String getpayingName() {
		return payingName;
	}

	public void setpayingName(String payingName) {
		this.payingName = payingName;
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
		Payment other = (Payment) obj;
		if (identificationNumber == null) {
			if (other.identificationNumber != null)
				return false;
		} else if (!identificationNumber.equals(other.identificationNumber))
			return false;
		return true;
	}
	
	
	
	
}
