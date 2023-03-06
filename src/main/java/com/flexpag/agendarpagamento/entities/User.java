package com.flexpag.agendarpagamento.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name ="users")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String cpf;
	
	/*Associação
	@JsonIgnore
	@OneToMany(mappedBy ="client")
	private List<Payment> payments= new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy ="client")
	private List<Schedule> shedules= new ArrayList<>();*/
	
	 @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	   private List<TesteEntity> testeEntity;
	
	public User() {}

	public User(Long id, String name, String cpf) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	/*Como é uma collection só será preciso o set
	public List<Payment> getPayments(Payment pay) {
		this.payments.add(pay);
		return payments;
	}	

	public List<Schedule> getShedules(Schedule schedule) {
		this.shedules.add(schedule);
		return shedules;
	}*/

	public List<TesteEntity> getTesteEntity() {
		return testeEntity;
	}

	public void setTesteEntity(List<TesteEntity> testeEntity) {
		this.testeEntity = testeEntity;
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
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
