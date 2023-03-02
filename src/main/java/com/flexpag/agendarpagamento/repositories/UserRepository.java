package com.flexpag.agendarpagamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flexpag.agendarpagamento.entities.User;

public interface UserRepository extends JpaRepository<User,Long>{

}
