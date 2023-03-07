package com.flexpag.agendarpagamento.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flexpag.agendarpagamento.entities.Payments;
import com.flexpag.agendarpagamento.services.PaymentsService;

@RestController
@RequestMapping(value = "/payments")
public class PaymentsController {

	@Autowired
	private PaymentsService paymentService;

	@GetMapping
	public ResponseEntity<List<Payments>> findAll() {
		List<Payments> payments = paymentService.findAll();
		return ResponseEntity.ok().body(payments);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Payments> findById(@PathVariable Long id) {
		Payments pay = paymentService.findById(id);
		return ResponseEntity.ok().body(pay);
	}

	@PostMapping
	public ResponseEntity<Payments> create(@RequestBody Payments obj) {
		try {

			Payments savedPayment = paymentService.save(obj);

			return ResponseEntity.status(HttpStatus.CREATED).body(savedPayment);
		} catch (Exception e) {
			throw new RuntimeException("Erro ao criar pagamento", e);
		}
	}

}
