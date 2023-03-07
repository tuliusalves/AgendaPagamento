package com.flexpag.agendarpagamento.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.flexpag.agendarpagamento.entities.Payments;
import com.flexpag.agendarpagamento.entities.Schedules;
import com.flexpag.agendarpagamento.entities.Users;
import com.flexpag.agendarpagamento.entities.enums.ScheduleStatus;
//import com.flexpag.agendarpagamento.entities.enums.ScheduleStatus;
import com.flexpag.agendarpagamento.repositories.PaymentsRepository;
import com.flexpag.agendarpagamento.repositories.SchedulesRepository;
import com.flexpag.agendarpagamento.repositories.UsersRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	// Instanciando as injeções de dependência
	@Autowired
	private PaymentsRepository paymentRepository;

	@Autowired
	private UsersRepository userRepository;
	@Autowired
	private SchedulesRepository scheduleRepository;

	@Override
	public void run(String... args) throws Exception {

		Users user1 = new Users(null, "Túlius", "012104505");
		Users user2 = new Users(null, "Djalma", "135649875");

		Payments pay1 = new Payments(null, "Bradesco", 150.50, Instant.parse("2020-06-20T19:50:07Z"));
		Payments pay2 = new Payments(null, "Itaú", 420.50, Instant.parse("2021-03-16T12:10:07Z"));
		Payments pay3 = new Payments(null, "Banco do Brasil", 420.50, Instant.parse("2022-03-16T12:10:07Z"));

		userRepository.saveAll(Arrays.asList(user1, user2));
		paymentRepository.saveAll(Arrays.asList(pay1, pay2, pay3));

		Schedules schedule1 = new Schedules(null, ScheduleStatus.PENDING, Instant.parse("2020-06-20T19:50:07Z"), user1,
				pay1);
		Schedules schedule2 = new Schedules(null, ScheduleStatus.PAID, Instant.parse("2021-06-20T19:50:07Z"), user1,
				pay1);
		Schedules schedule3 = new Schedules(null, ScheduleStatus.PAID, Instant.parse("2021-06-20T19:50:07Z"), user2,
				pay2);
		scheduleRepository.saveAll(Arrays.asList(schedule1, schedule2, schedule3));

	}

}
