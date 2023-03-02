package com.flexpag.agendarpagamento.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flexpag.agendarpagamento.entities.Payment;
import com.flexpag.agendarpagamento.services.PaymentService;

@RestController
@RequestMapping(value ="/payment")
public class PaymentResource {
	
	@Autowired
	private PaymentService service;
	@GetMapping
	public ResponseEntity<List<Payment>> findAll(){
		List<Payment> payments= service.findAll();
		return ResponseEntity.ok().body(payments);
	}
	
	/*EndPoint findById*/
	@GetMapping(value = "/{id}")
	public ResponseEntity<Payment> findById(@PathVariable Long id){
		Payment pay= service.findById(id);
		return ResponseEntity.ok().body(pay);
	}

}
