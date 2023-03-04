package com.flexpag.agendarpagamento.entities;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="Pagamento")
public class Payment implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private Long identificationNumber;
	private String recipientBank;
	private Double paymentAmount;
	/*Usando a anotação @JsonFormat
	 *no formato("ano-mês-dia'T' hora:min:seg'Z', timezone="padrão universal grenuwich"*/
	@JsonFormat(shape= JsonFormat.Shape.STRING, pattern ="yyyy:MM:dd'T'HH:mm:ss'Z'", timezone="GMT")
	private Instant dueDate;
	/*Falta por a data de vencimento e data débito*/
	public Payment() {}
	//Criando associação com usuário
	@ManyToOne
	@JoinColumn(name= "client_id")
	private User client;
	
	@OneToOne(mappedBy="payment", cascade= CascadeType.ALL)
	private Schedule schedule;

	public Payment(Long identificationNumber, String recipientBank, Double paymentAmount, Instant dueDate, User client) {
		super();
		this.identificationNumber = identificationNumber;
		this.recipientBank = recipientBank;
		this.paymentAmount = paymentAmount;
		this.dueDate = dueDate;
		this.client = client;
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

	public User getClient() {
		return client;
	}

	public void setUserClient(User client) {
		this.client = client;
	}
	
	

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
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
