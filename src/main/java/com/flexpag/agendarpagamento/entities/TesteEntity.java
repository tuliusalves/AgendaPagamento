package com.flexpag.agendarpagamento.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "teste")
public class TesteEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "payment_id", referencedColumnName = "identificationNumber", nullable = false)
	private Payment payment;

	public TesteEntity() {
	}

	

	public TesteEntity(Long id, String name, User user, Payment payment) {
		super();
		this.id = id;
		this.name = name;
		this.user = user;
		this.payment = payment;
	}



	public TesteEntity(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
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

}
